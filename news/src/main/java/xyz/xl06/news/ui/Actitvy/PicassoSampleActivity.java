package xyz.xl06.news.ui.Actitvy;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import cn.sharesdk.onekeyshare.OnekeyShare;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;
import xyz.xl06.news.R;

public class PicassoSampleActivity extends Activity {
    private String url;
    private Button btn_back;
    private Button btn_share;
    private Button btn_font;
    private Button btn_night;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_sample);
       url = getIntent().getStringExtra("url");


        PhotoView photoView = (PhotoView) findViewById(R.id.iv_photo);

        final PhotoViewAttacher attacher = new PhotoViewAttacher(photoView);

        Picasso.with(this)
                .load(url).config(Bitmap.Config.RGB_565)
                .into(photoView, new Callback() {
                    @Override
                    public void onSuccess() {
                        attacher.update();
                    }

                    @Override
                    public void onError() {

                    }
                });

        initView();
        initListener();
    }

    private void initView() {
        btn_back=(Button)this.findViewById(R.id.btn_back);
        btn_share=(Button)this.findViewById(R.id.btn_share);
        btn_font=(Button)this.findViewById(R.id.btn_font);
        btn_night=(Button)this.findViewById(R.id.btn_night);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Picasso.invalidate(url);
    }
    public void initListener() {
        btn_back.setOnClickListener(new CustomOnClickListener());
        btn_share.setOnClickListener(new CustomOnClickListener());
        btn_font.setOnClickListener(new CustomOnClickListener());
        btn_night.setOnClickListener(new CustomOnClickListener());
    }
    class CustomOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_back:
                    PicassoSampleActivity.this.finish();
                    break;
                case R.id.btn_share:
                    showShare();
                    Toast.makeText(PicassoSampleActivity.this,"点击了分享按钮",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_night:
                    Toast.makeText(PicassoSampleActivity.this,"点击了白天/黑夜切换按钮",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btn_font:
                    Toast.makeText(PicassoSampleActivity.this,"点击了字体按钮",Toast.LENGTH_SHORT).show();

                    break;
            }
        }
    }

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，微信、QQ和QQ空间等平台使用
        oks.setTitle(getString(R.string.share));
        // titleUrl QQ和QQ空间跳转链接
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        oks.setImageUrl(url);
        // url在微信、微博，Facebook等平台中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网使用
        oks.setComment("我是测试评论文本");
        // 启动分享GUI
        oks.show(this);
    }
}