package cn.mvp.model;

import cn.mvp.bean.OnLoginListener;
import cn.mvp.bean.User;

/**
 * <p>Title: cn.mvp.model</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 15:30
 * Description:
 */

public class UserModelImpl implements UserModel {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("zhy".equals(username) && "123".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
