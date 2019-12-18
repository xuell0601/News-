package xyz.xl06.news.utils;

import java.util.ArrayList;
import java.util.List;

import xyz.xl06.news.ben.CateBen;

/**
 * Created by xueliang on 2019/2/16 0016.
 */
public class DeFinde_nav {
    public static List<CateBen> getTopNav(){
        ArrayList<CateBen> ben= new ArrayList<>();
        ben.add(new CateBen("推荐","https://www.apiopen.top/journalismApi",1));
        ben.add(new CateBen("娱乐","http://api.dagoogle.cn/news/nlist?cid=1",2));
        ben.add(new CateBen("军事","http://api.dagoogle.cn/news/nlist?cid=2",3));
        ben.add(new CateBen("汽车","http://api.dagoogle.cn/news/nlist?cid=3",4));
        ben.add(new CateBen("财经","http://api.dagoogle.cn/news/nlist?cid=4",5));
        ben.add(new CateBen("体育","http://api.dagoogle.cn/news/nlist?cid=6",7));
        ben.add(new CateBen("科技","http://api.dagoogle.cn/news/nlist?cid=7",8));
        ben.add(new CateBen("头条","http://api.dagoogle.cn/news/nlist?cid=9",9));
        return ben;


    }
}
