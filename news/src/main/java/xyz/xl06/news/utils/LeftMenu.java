package xyz.xl06.news.utils;

import java.util.ArrayList;
import java.util.List;

import xyz.xl06.news.R;
import xyz.xl06.news.leftmenu.LeftBen;

/**
 * Created by xueliang on 2019/2/15 0015.
 */
public  class LeftMenu {

    //
    public static List<LeftBen> getLeftMenu(){
        ArrayList<LeftBen> menus = new ArrayList<>();
        menus.add(new LeftBen(R.drawable.icon_zhanghaoxinxi,"账号信息"));
        menus.add(new LeftBen(R.drawable.icon_wodeguanzhu,"我的关注"));
        menus.add(new LeftBen(R.drawable.icon_shoucang,"我的收藏"));
        menus.add(new LeftBen(R.drawable.icon_yijianfankui,"意见反馈"));
        menus.add(new LeftBen(R.drawable.icon_shezhi,"设置"));
        return menus;
    }
}
