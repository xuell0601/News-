package xyz.xl06.news.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

import xyz.xl06.news.ben.CateBen;
import xyz.xl06.news.ui.Framnt.BaseFramnt;

/**
 * Created by xueliang on 2019/2/16 0016.
 */
public class Main_Framnt_stateAdapter extends FragmentStatePagerAdapter {
     private List<BaseFramnt>  Framnts=null;

    public void setTitlelist(List<CateBen> titlelist) {
        this.titlelist = titlelist;
    }

    List<CateBen> titlelist=null;


    private String title[]=null;
    private Fragment fragment=null;


    public Main_Framnt_stateAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return Framnts.get(position);
    }

    public void setFramnt(List<BaseFramnt> Framnts) {
        this.Framnts=Framnts;
    }
    @Override
    public int getCount() {
        return Framnts.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        fragment = (Fragment) super.instantiateItem(container, position);
        return  fragment;
    }
    //biaoti

    /**
     * 设置标题
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position).getTitle();
    }


}
