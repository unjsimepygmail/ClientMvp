package com.example.simepy.clientmvp.mvp.biz;

import com.example.simepy.clientmvp.mvp.bean.User;

/**
 * Created by simepy on 2016/11/14.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
