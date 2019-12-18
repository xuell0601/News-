package xyz.xl06.news.ui.Framnt;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by xueliang
 */
public class BaseFramnt extends Fragment {
    public Context con;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建全局的上下文对象
        con = getActivity();
    }
}
