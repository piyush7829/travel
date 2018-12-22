package com.aabsys.practice.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.aabsys.practice.R;
import com.aabsys.practice.Utilty.SharePreferenceUtility;
import com.aabsys.practice.home.HomeActivity;
import com.aabsys.practice.login.SigninActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    private void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(SharePreferenceUtility.getInstance().getString("Token").equalsIgnoreCase("")){
                    Intent intent = new Intent(SplashActivity.this,SigninActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 5000);
    }
}
