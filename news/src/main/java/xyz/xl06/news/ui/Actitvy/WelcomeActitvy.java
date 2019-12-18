package xyz.xl06.news.ui.Actitvy;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import xyz.xl06.news.R;

public class WelcomeActitvy extends BaseActivity {


    @InjectView(R.id.btn_dao)
    TextView btnDao;
    private Handler handler = new Handler();
    @InjectView(R.id.btn)
    Button btn;
    @InjectView(R.id.CustromVideoView)
    xyz.xl06.news.ui.CustromVideoView CustromVideoView;
    public int alltime;
    public int now;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_actitvy);
        ButterKnife.inject(this);
        CustromVideoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.kr36));
        //获取视屏的长多
        CustromVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                alltime = CustromVideoView.getDuration() / 1000;
                now=alltime-3;
            }
        });
        CustromVideoView.start();
        //播放完成后跳转

        CustromVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // CustromVideoView.start();
                opeanActviy(MainActivity.class);
                //销毁页面
                finish();
            }
        });
        /**
         * 倒计时
         *
         */
        initDaojishi();

        //跳转
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opeanActviy(MainActivity.class);
                //销毁页面
                finish();
            }
        });
    }

    /**
     * 倒计时
     */
    private void initDaojishi() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                now--;
                btnDao.setEnabled(false);
                btnDao.setText("剩余时间：" + now + "s");
                if (now >= 0) {
                    handler.postDelayed(this, 1000);
                } else {
                    //当倒计时为0秒时，恢复初始状态
                    now = 0;
                    btnDao.setEnabled(true);
                    btnDao.setTextColor(Color.BLUE);
                }
            }
        }, 1000);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        CustromVideoView.stopPlayback();
        handler.removeCallbacksAndMessages(null);
    }
}
