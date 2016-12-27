package cn.mvp.bean;

/**
 * <p>Title: cn.mvp.bean</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 15:29
 * Description:
 */

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
