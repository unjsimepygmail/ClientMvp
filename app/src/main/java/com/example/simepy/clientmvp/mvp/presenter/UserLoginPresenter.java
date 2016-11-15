package com.example.simepy.clientmvp.mvp.presenter;

import com.example.simepy.clientmvp.mvp.bean.User;
import com.example.simepy.clientmvp.mvp.biz.IUserBiz;
import com.example.simepy.clientmvp.mvp.biz.OnLoginListener;
import com.example.simepy.clientmvp.mvp.biz.UserBiz;
import com.example.simepy.clientmvp.mvp.view.IUserLoginView;

import android.os.Handler;
import android.os.SystemClock;


/**
 * Created by simepy on 2016/11/14.
 */

public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView)
    {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login()
    {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });
            }

    });
}

            public void clear() {
                userLoginView.clearUserName();
                userLoginView.clearPassword();
            }
    private void sys()
    {
        SystemClock.currentThreadTimeMillis();
    }


}
