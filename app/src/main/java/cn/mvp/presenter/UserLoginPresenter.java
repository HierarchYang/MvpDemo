package cn.mvp.presenter;

import android.os.Handler;

import cn.mvp.bean.OnLoginListener;
import cn.mvp.bean.User;
import cn.mvp.model.UserModel;
import cn.mvp.model.UserModelImpl;
import cn.mvp.ui.UserLoginView;

/**
 * <p>Title: cn.mvp.presenter</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 15:32
 * Description:
 */

public class UserLoginPresenter {
    private UserLoginView mUserLoginView;
    private UserModel mUserModel;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(UserLoginView userLoginView) {
        this.mUserLoginView = userLoginView;
        mUserModel = new UserModelImpl();
    }

    public void login() {
        mUserLoginView.showLoading();
        mUserModel.login(mUserLoginView.getUserName(), mUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserLoginView.toMainActivity(user);
                        mUserLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserLoginView.hideLoading();
                        mUserLoginView.showFailedError();
                    }
                });
            }
        });
    }

    public void clear() {
        mUserLoginView.clearUserName();
        mUserLoginView.clearPassword();
    }
}
