package com.yly.trainsystem.ui.login;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.yly.trainsystem.R;
import com.yly.trainsystem.databinding.ActivityLoginBinding;
import com.yly.trainsystem.volley.HttpUtils;
import com.yly.trainsystem.volley.ServerUserInfoResponse;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private final Response.Listener<String> listener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Gson gson = new Gson();
           ServerUserInfoResponse serverUserInfoResponse = gson.fromJson(response, ServerUserInfoResponse.class);
           serverUserInfoResponse.getData();
           int code = serverUserInfoResponse.getCode();

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LoginViewModel loginViewModel = new LoginViewModel();
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setLogin(loginViewModel);
        binding.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = loginViewModel.userName.get();
                if (TextUtils.isEmpty(userName)) {
                    Toast.makeText(LoginActivity.this, R.string.username_empty, Toast.LENGTH_LONG).show();
                }

                String password = loginViewModel.password.get();
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, R.string.password_empty, Toast.LENGTH_LONG).show();
                }

                HashMap<String, String> map = new HashMap<>();
                map.put("userName", userName);
                map.put("password", password);
                HttpUtils.post(HttpUtils.LOGIN_REGISTER, map, listener, null);


            }
        });

    }
}
