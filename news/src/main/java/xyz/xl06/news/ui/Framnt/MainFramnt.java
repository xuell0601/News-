package xyz.xl06.news.ui.Framnt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import xyz.xl06.news.R;
import xyz.xl06.news.ben.CateBen;
import xyz.xl06.news.ui.Actitvy.MainActivity;
import xyz.xl06.news.ui.adapter.Main_Framnt_stateAdapter;
import xyz.xl06.news.utils.DeFinde_nav;
import xyz.xl06.news.utils.DefineView;

/**
 * Created by xueliang on 2019/2/16 0016.
 */
public class MainFramnt extends BaseFramnt implements DefineView,ViewPager.OnPageChangeListener {

    private View main_view;
    //创建导航标题
    // String title[]=new String[]{"你哈","你哈","你哈","你哈","你哈","你哈","你哈","你哈","你哈","你哈","你哈","你哈","你哈",};
    List<CateBen>  titlelist= DeFinde_nav.getTopNav();
   // DeFinde_nav.getTopNav();

    //framnt集合
    List<BaseFramnt> framntss=null;
    private Main_Framnt_stateAdapter main_framnt_stateAdapter;
    private TabLayout tabMain;
    private ViewPager mainVp;
    BaseFramnt  baseFramnt=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (main_view == null) {
            main_view = View.inflate(con, R.layout.main_frmant_, null);
            //绑定View
           // ButterKnife.inject(con, main_view);
            initView();
            initData();
            initLisner();
            BindData();
        }
        return main_view;
    }

    @Override
    public void initView() {
          //设置模式
        //绑定适配器
        tabMain = (TabLayout) main_view.findViewById(R.id.tab_main);
        mainVp = (ViewPager) main_view.findViewById(R.id.main_vp);
    }

    @Override
    public void initData() {
    main_framnt_stateAdapter = new Main_Framnt_stateAdapter(getChildFragmentManager());
        main_framnt_stateAdapter.setTitlelist(titlelist);
        framntss=new ArrayList<>();
        //添加子
        for(int i=0;i<titlelist.size();i++){
            if(i==0){
                baseFramnt=HomeFramnt.newInstance(titlelist.get(i));
               // boolean add = framntss.add(HomeFramnt.newInstance(titlelist.get(i)));
            }else  {
                // framntss.add(PageFramnt.newInstance(titlelist.get(i)));
                baseFramnt = PageFramnt.newInstance(titlelist.get(i));
            }
            framntss.add(baseFramnt);
        }
        //设置到
        main_framnt_stateAdapter.setFramnt(framntss);
        tabMain.setTabMode(TabLayout.MODE_SCROLLABLE);//设置滑动模式
        //设置适配器
        mainVp.setAdapter(main_framnt_stateAdapter);
        //绑定
        tabMain.setupWithViewPager(mainVp);
    }

    @Override
    public void initLisner() {
        mainVp.setOnPageChangeListener(this);
    }

    @Override
    public void BindData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position==0){
            ((MainActivity)getActivity()).getDl().setIsdrop(true);
        }else{
            ((MainActivity)getActivity()).getDl().setIsdrop(false);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
