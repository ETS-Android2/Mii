package com.takundamudarikwa.mii.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.takundamudarikwa.mii.R;

import kotlinx.coroutines.android.HandlerDispatcher;

import static com.takundamudarikwa.mii.R.*;

public class MainActivity extends AppCompatActivity {
    private WebView wbv;
    private ImageView gifImageView;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        gifImageView = findViewById(id.gifImageView);
        Glide.with(this).load(drawable.miilogo).into(gifImageView);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startLoginActivity();
            }
        },3000);
    }

    public void startLoginActivity() {
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}