package com.example.simepy.clientmvp.mvp.view;

import com.example.simepy.clientmvp.mvp.bean.User;

/**
 * Created by simepy on 2016/11/14.
 */

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();


}
