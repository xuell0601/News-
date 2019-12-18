package xyz.xl06.news.ui.Actitvy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import xyz.xl06.news.R;
import xyz.xl06.news.ui.Framnt.BaseFramnt;
import xyz.xl06.news.ui.Framnt.Center;
import xyz.xl06.news.ui.Framnt.Find;
import xyz.xl06.news.ui.Framnt.MainFramnt;
import xyz.xl06.news.ui.Framnt.User;
import xyz.xl06.news.widget.DragLayout;

public class MainActivity extends BaseActivity {
    @InjectView(R.id.iv_bottom)
    ImageView ivBottom;
    @InjectView(R.id.ll1)
    LinearLayout ll1;
    @InjectView(R.id.tv_mail)
    TextView tvMail;

    @InjectView(R.id.iv_icon)
    ImageView ivIcon;
    @InjectView(R.id.rg_main)
    RadioGroup rgMain;

    @InjectView(R.id.tv_search)
    TextView tvSearch;
    @InjectView(R.id.rl_game)
    RelativeLayout rlGame;
    @InjectView(R.id.iv_record)
    ImageView ivRecord;
    @InjectView(R.id.rl_title)
    RelativeLayout rlTitle;
    @InjectView(R.id.framnt)
    FrameLayout framnt;

    private ArrayList<BaseFramnt> baseFramnets;
    private int postion = 0;
    private Fragment tempFramnt;
    private FragmentTransaction fragmentTransaction;


    public DragLayout getDl() {
        return dl;
    }

    public void setDl(DragLayout dl) {
        this.dl = dl;
    }

    private DragLayout dl;
    private ListView lv;
    private TextView tv_noimg;
    private ImageView iv_icon, iv_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setStatusBar();
        initFramnt();
        initDragLayout();
        initView();
        initLisner();
        //默认选中

    }

    private void initLisner() {

        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
//                    case R.id.home_1 :
//                        postion=0;
//                        //Toast.makeText(MainActivity.this, "sdsds", Toast.LENGTH_SHORT).show();
//                        break;
                    case R.id.home_2  :
                        postion=0;
                        // Toast.makeText(MainActivity.this, "sdsds", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.home_3:
                        postion=1;
                        // Toast.makeText(MainActivity.this, "sdsds", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.home_4:
                        postion=2;
                        // Toast.makeText(MainActivity.this, "sdsds", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.home_5:
                        postion=3;
                        // Toast.makeText(MainActivity.this, "sdsds", Toast.LENGTH_SHORT).show();
                        break;
                }

                Fragment fragment = getFramnt(postion);

                switchFramnt(tempFramnt, fragment);

            }
        });

        rgMain.check(R.id.home_2);
    }
    private void initFramnt() {
        baseFramnets = new ArrayList<>();
       //baseFramnets.add(new Home());
        baseFramnets.add(new MainFramnt());
        baseFramnets.add(new Center());
        baseFramnets.add(new Find());
        baseFramnets.add(new User());
    }

    private void switchFramnt(Fragment frmo, Fragment fragment) {
        if (tempFramnt != fragment) {
            tempFramnt = fragment;
            if (fragment != null) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                if (!fragment.isAdded()) {
                    //添加
                    if (frmo != null) {
                        fragmentTransaction.hide(frmo);
                    }
                    fragmentTransaction.add(R.id.framnt, fragment).commit();
                } else {
                    //显示
                    if (frmo != null) {
                        fragmentTransaction.hide(frmo);
                    }
                    fragmentTransaction.show(fragment).commit();
                }
            }
        }
    }

    private Fragment getFramnt(int postion) {
        if (baseFramnets.size() > 0 || baseFramnets != null) {

            BaseFramnt baseF = baseFramnets.get(postion);
            return baseF;
        }
        return null;
    }

    private void initDragLayout() {
        dl = (DragLayout) findViewById(R.id.dl);
        dl.setDragListener(new DragLayout.DragListener() {
            //界面打开的时候
            @Override
            public void onOpen() {
            }

            //界面关闭的时候
            @Override
            public void onClose() {
            }

            //界面滑动的时候
            @Override
            public void onDrag(float percent) {
                ViewHelper.setAlpha(iv_icon, 1 - percent);
            }
        });
    }

    private void initView() {
        iv_icon = (ImageView) findViewById(R.id.iv_icon);
        iv_bottom = (ImageView) findViewById(R.id.iv_bottom);
        //tv_noimg = (TextView) findViewById(R.id.iv_noimg);


        /**
         * 左侧的数据处理
         */
        lv = (ListView) findViewById(R.id.lv);
        //设置左边的数据
        lv.setAdapter(new LeftMenusAdapter(MainActivity.this));
        /**
         * 点击弹出左侧的菜单
         */
        iv_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dl.open();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}
