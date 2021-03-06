package com.app.sportzfever.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.app.sportzfever.R;
import com.app.sportzfever.utils.AppUtils;

public class Splash extends AppCompatActivity {

    String type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("type")) {
                type = intent.getStringExtra("type");
            }
        }
        Log.e("gcm", AppUtils.getGcmRegistrationKey(getApplicationContext()));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (AppUtils.getUserId(getApplicationContext()).equalsIgnoreCase("")) {

                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                    intent.putExtra("type", type);
                    startActivity(intent);
                    finish();
                }

            }
        }, 1000);

    }
}
