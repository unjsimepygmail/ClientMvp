package com.example.simepy.clientmvp.mvp.biz;

/**
 * Created by simepy on 2016/11/14.
 */

public interface IUserBiz {
    public void login(String username,String password,OnLoginListener loginListener );
}
