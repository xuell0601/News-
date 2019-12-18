package xyz.xl06.news.utils;

/**
 * Created by xueliang on 2019/2/16 0016.
 * 该类主要抽取 framnt 和actitvy中共同的使用方法
 */
public interface DefineView {
        public void initView();//初始化布局
        public void initData();//初始化数据
        public void initLisner();//监听
        public void BindData();//绑定数据

}
