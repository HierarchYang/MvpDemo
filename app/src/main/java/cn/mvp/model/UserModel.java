package cn.mvp.model;

import cn.mvp.bean.OnLoginListener;

/**
 * <p>Title: cn.mvp.model</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 15:30
 * Description:
 */

public interface UserModel {
    void login(String username, String password, OnLoginListener loginListener);
}
