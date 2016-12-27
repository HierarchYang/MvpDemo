package cn.mvp.ui;

import cn.mvp.bean.User;

/**
 * <p>Title: cn.mvp.ui</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 15:31
 * Description:
 */

public interface UserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
