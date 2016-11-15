package com.example.simepy.clientmvp.mvp.biz;

import com.example.simepy.clientmvp.mvp.bean.User;

/**
 * Created by simepy on 2016/11/14.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username, final String password,final OnLoginListener loginListener ) {
        new Thread()
        {
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                if("admin".equals(username)&&"admin".equals(password))
                {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                }else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();

    }


}
