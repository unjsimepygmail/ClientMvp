package com.example.simepy.clientmvp.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.simepy.clientmvp.R;
import com.example.simepy.clientmvp.mvp.bean.User;
import com.example.simepy.clientmvp.mvp.presenter.UserLoginPresenter;
import com.example.simepy.clientmvp.mvp.view.IUserLoginView;

public class UserLoginView extends AppCompatActivity implements IUserLoginView {
    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");

    }

    @Override
    public void clearPassword() {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);

    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() + "login succese,to MainActivity", Toast.LENGTH_LONG).show();

    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();

    }

    private void initView() {
        mEtUsername = (EditText) findViewById(R.id.et1);
        mEtPassword = (EditText) findViewById(R.id.et2);
        mBtnLogin = (Button) findViewById(R.id.bt1);
        mBtnClear = (Button) findViewById(R.id.bt2);
        mPbLoading = (ProgressBar) findViewById(R.id.pb);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserLoginPresenter.login();
            }
        });
        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserLoginPresenter.clear();
            }
        });
    }
}
