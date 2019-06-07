package com.example.mvplogin.LoginPresenter;

import android.text.TextUtils;

import com.example.mvplogin.LoginView.LoginView;
import com.example.mvplogin.Model.User;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private User user;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        user = new User();
    }


    @Override
    public void onLogin() {


    }

    @Override
    public void onValidation(String uName, String password) {

        if (TextUtils.isEmpty(uName)) {
            loginView.onShowValidateMsg("Please enter the username");
        } else if (TextUtils.isEmpty(password)) {
            loginView.onShowValidateMsg("Please enter the password");
        } else {
            if (uName.equalsIgnoreCase("admin") || password.equalsIgnoreCase("admin")) {

                loginView.onSuccessMsg();
                user.setUserName(uName);
                user.setPaswword(password);

            } else {
                loginView.onFailureMsg();
            }


        }

    }
}
