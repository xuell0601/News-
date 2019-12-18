package xyz.xl06.news.Bmob;


import java.util.List;

import cn.bmob.v3.exception.BmobException;
import xyz.xl06.news.ben.FavorInfo;

/**
 * Created by hongkl on 16/9/3.
 */
public interface IBmobLoginListener {

    void sendMsgSucess();
    void loginSucess();
    void querySucess(List<FavorInfo> object);
    void queryFailure(BmobException e);
}
