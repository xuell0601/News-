package xyz.xl06.news.ui.Actitvy;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import xyz.xl06.news.R;
import xyz.xl06.news.net.OkhttpManager;
import xyz.xl06.news.utils.MyTextWatch;

public class LoginActitvy extends BaseActivity {
    /**
     * 用户名密码输入框
     **/
    @InjectView(R.id.username)
    EditText mUsername;
    @InjectView(R.id.password)
    EditText mPassword;

    /**
     * 快速登录
     */
    @InjectView(R.id.tv_quick_register)
    TextView mTvQuickRegister;
    /**
     * 帐号登录
     */
    @InjectView(R.id.tv_count_register)
    TextView mTvCountRegister;

    /**
     * tab下划线
     */
    @InjectView(R.id.view_line_left)
    View mViewLineLeft;
    @InjectView(R.id.view_line_right)
    View mViewLineRight;

    /**
     * 帐号登录的布局
     */
    @InjectView(R.id.ll_login)
    LinearLayout mLlLogin;
    /**
     * 快速登录的布局
     */
    @InjectView(R.id.ll_quick_login)
    LinearLayout mLlQuickLogin;
    /***
     * 忘记密码
     **/
    @InjectView(R.id.ll_forget_pwd)
    LinearLayout mLlForgetPwd;
    @InjectView(R.id.et_quick_phone)
    EditText mQuickPhone;
    @InjectView(R.id.et_quick_code)
    EditText mQuickCode;


    @InjectView(R.id.quick_login_btn)
    Button mBtnLogin;
    @InjectView(R.id.btn_get_code)
    Button mBtnGetCode;
    /**
     * tab下划线动画
     */
    private Animation mAnimRight;
    private Animation mAnimLeft;
    /**
     * 字体颜色
     */
    private int mOrrange;
    private int mGray;
    /**
     * 帐号名密码是否为空
     **/
    private boolean isUsernameNull = false;
    private boolean isPwdNull = false;
    /**
     * 手机号验证码是否为空
     **/
    private boolean isPhoneNull = false;
    private boolean isCodeNull = false;

    /**
     * 倒计时秒数
     */
    private int mCount;
    private OkhttpManager okhttpManager=null;
    private OkHttpClient client=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
        ButterKnife.inject(this);
        //init();
        initAnimation();
    }

    /***
     * 初始化操作
     */
    private void init() {
        mOrrange = getResources().getColor(R.color.orange);
        mGray = getResources().getColor(R.color.content_color);

        mQuickPhone.addTextChangedListener(new MyTextWatch() {
            @Override
            public void afterTextChanged(Editable editable) {
                isPhoneNull = TextUtils.isEmpty(editable.toString()) ? false : true;
                mBtnLogin.setEnabled((isPhoneNull && isCodeNull) ? true : false);
            }
        });
        mQuickCode.addTextChangedListener(new MyTextWatch() {
            @Override
            public void afterTextChanged(Editable editable) {
                isCodeNull = TextUtils.isEmpty(editable.toString()) ? false : true;
                mBtnLogin.setEnabled((isPhoneNull && isCodeNull) ? true : false);
            }
        });
    }

    /***
     * 初始化动画
     */
    private void initAnimation() {
          /* 线左边移动 */
        mAnimRight = AnimationUtils.loadAnimation(LoginActitvy.this, R.anim.view_line_move_left);
        mAnimRight.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mTvQuickRegister.setTextColor(mOrrange);
                mTvCountRegister.setTextColor(mGray);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mViewLineLeft.setVisibility(View.VISIBLE);
                mViewLineRight.setVisibility(View.INVISIBLE);
                mLlLogin.setVisibility(View.GONE);
                mLlQuickLogin.setVisibility(View.VISIBLE);
                mLlForgetPwd.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        /* 线右边移动 */
        mAnimLeft = AnimationUtils.loadAnimation(LoginActitvy.this, R.anim.view_line_move_right);
        mAnimLeft.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mTvQuickRegister.setTextColor(mGray);
                mTvCountRegister.setTextColor(mOrrange);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mViewLineLeft.setVisibility(View.INVISIBLE);
                mViewLineRight.setVisibility(View.VISIBLE);
                mLlLogin.setVisibility(View.VISIBLE);
                mLlQuickLogin.setVisibility(View.GONE);
                mLlForgetPwd.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    /**
     * 发送验证码倒计时
     */
    private void countdownTimer() {
        mBtnGetCode.setEnabled(false);
        mCount = 60;
        final Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mCount--;
                        mBtnGetCode.setText(mCount + "");
                        if (mCount <= 0) {
                            mBtnGetCode.setText("重新发送");
                            mBtnGetCode.setEnabled(true);
                            timer.cancel();
                        }
                    }
                });
            }
        };
        timer.schedule(task, 1000, 1000);
    }

    /***
     * 登录操作
     */
    public void login() {
        String username = mUsername.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password)) {
            Toast.makeText(LoginActitvy.this, "您的用户名或者密码为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        //创建网络请求
        // Map<String,String> params=new hMap<String, String>();

        okhttpManager=new OkhttpManager();
        client=new OkHttpClient();
        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
        RequestBody requestBody = formEncodingBuilder.add("username", username).add("password",password).build();
       // Request.Builder builder = new Request.Builder();
       // Request request = builder.url(url).post(requestBody).build();
         Request request = new Request.Builder()
                .url("https://api2.bmob.cn/1/users")
                .addHeader("X-Bmob-Application-Id","97b6172e25f63d8447aad05b67b00629")
                .addHeader("X-Bmob-REST-API-Key","42b8b9590b9bb1ae6e4f2fca9a4b129c")
                .addHeader("Content-Type","application/json")
                .post(requestBody)
                .build();
              client.newCall(request).enqueue(new Callback() {
                  @Override
                  public void onFailure(Request request, IOException e) {
                      Log.d("", "onResponse: ----------------------"+"成功");
                      Toast.makeText(LoginActitvy.this, "onResponse: ----------------------"+"失败", Toast.LENGTH_SHORT).show();
                  }

                  @Override
                  public void onResponse(Response response) throws IOException {
                     // Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                      Toast.makeText(LoginActitvy.this, "onResponse: ----------------------"+"成功", Toast.LENGTH_SHORT).show();
                  }
              });





//        Request<String> request = NoHttp.createStringRequest("https://api.bmob.cn/1/users", RequestMethod.POST);
//        //添加头部
//        request.addHeader("X-Bmob-Application-Id", "555b31ec65459cd361ea36884fb733f7");
//        request.addHeader("X-Bmob-REST-API-Key", "63df6b698ddce30d5162ce84c3bf0d75");
//
//        //添加Body
//        //{"username":"1111","password":"1111"}
//        String body = "{\"username\"" + ":" + username + "\"password\"" + ":" + password;
//        request.setDefineRequestBodyForJson(body);
//
//        CallServer.getInstance().add(LoginActivity.this, 0, request, this, true, true);
//    }
//
//
//    @Override
//    public void onSucceed(int what, Response<String> response) {
//        switch (what) {
//            case 0:
//                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
//                break;
//        }
//    }
//
//    @Override
//    public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
//        switch (what) {
//            case 0:
//                Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
//                break;
//        }
    }

    @OnClick({R.id.login_btn, R.id.tv_quick_register, R.id.tv_count_register, R.id.tv_register, R.id.btn_get_code})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                login();


                break;
            case R.id.tv_register:
                //startActivity(new Intent(LoginActitvy.this, RegisterActivity.class));
                break;
            case R.id.tv_quick_register:
                mViewLineRight.startAnimation(mAnimRight);
                break;
            case R.id.tv_count_register:
                mViewLineLeft.startAnimation(mAnimLeft);
                break;
            case R.id.btn_get_code:
//                BmobManager.getInstance().initListener(new BmobLoginCallback() {
//                    @Override
//                    public void loginSuccess() {
//                        Toast.makeText(LoginActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
//                        countdownTimer();
//                    }
//
//                    @Override
//                    public void loginFailure() {
//                    }
//                });
//                BmobManager.getInstance(new BmobLoginCallback() {
//                    @Override
//                    public void loginSuccess() {
//                        Toast.makeText(LoginActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
//                        countdownTimer();
//                    }
//
//                    @Override
//                    public void loginFailure() {
//
//                    }
//                }).requestSMSCode("18559802120");
//                break;
        }
    }
}
