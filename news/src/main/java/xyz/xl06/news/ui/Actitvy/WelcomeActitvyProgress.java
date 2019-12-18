package xyz.xl06.news.ui.Actitvy;

import android.app.Activity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import xyz.xl06.news.R;
import xyz.xl06.news.utils.CustomHorizontalProgresWithNum;

public class WelcomeActitvyProgress extends Activity {

    private CustomHorizontalProgresWithNum horizontalProgress1;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_actitvy_progress);
        initView();
        initData();
    }

    private void initData() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //实时更新进度
                if (horizontalProgress1.getProgress() >= 100) {//指定时间取消
                    timer.cancel();
                }
                horizontalProgress1.setProgress(horizontalProgress1.getProgress()+1);
                horizontalProgress1 .setProgress(horizontalProgress1 .getProgress()+1);
            }
        }, 0, 500);

    }

    private void initView() {

        horizontalProgress1 = (CustomHorizontalProgresWithNum) findViewById(R.id.horizontalProgress1);
        horizontalProgress1.setProgress(0);
        horizontalProgress1.setMax(100);
    }

}
