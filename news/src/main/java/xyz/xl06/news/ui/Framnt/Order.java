package xyz.xl06.news.ui.Framnt;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.xl06.news.R;


/**
 * Created by xueliang on 2019/1/29 0029.
 */
public class Order extends BaseFramnt {

    private View home_framnt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(home_framnt==null){
            home_framnt = inflater.inflate(R.layout.order, container,false);

//            initView();
//            initData();
//            initLisner();
        }
        return home_framnt;
    }
}