package com.example.mvplogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvplogin.LoginPresenter.LoginPresenterImpl;
import com.example.mvplogin.LoginView.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    LoginPresenterImpl loginPresenter;
    EditText edtUserName, edtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUserName = findViewById(R.id.loginUserNameEdt);
        edtPassword = findViewById(R.id.loginPasswordEdt);
        btnLogin = findViewById(R.id.loginSubmitBtn);

        loginPresenter = new LoginPresenterImpl(this);

        btnLogin.setOnClickListener(v -> loginPresenter.onValidation(edtUserName.getText().toString(), edtPassword.getText().toString()));
    }

    @Override
    public void onShowValidateMsg(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessMsg() {

        Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFailureMsg() {
        Toast.makeText(MainActivity.this, "Login Failure", Toast.LENGTH_SHORT).show();

    }
}
