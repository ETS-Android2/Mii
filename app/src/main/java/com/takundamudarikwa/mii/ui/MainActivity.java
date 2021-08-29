package com.takundamudarikwa.mii.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.takundamudarikwa.mii.R;
import com.takundamudarikwa.mii.model.DBManager;

import kotlinx.coroutines.android.HandlerDispatcher;

import static com.takundamudarikwa.mii.R.*;

public class MainActivity extends AppCompatActivity {
    private WebView wbv;
    private ImageView gifImageView;
    private Handler handler;

    private DBManager usersDB = new DBManager(this);
    //private File saveFile = new File(context.getFilesDir(),filename);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        usersDB.open();
        gifImageView = findViewById(id.gifImageView);
        Glide.with(this).load(drawable.miilogo).into(gifImageView);

        Cursor userData = usersDB.fetchUser();
        String prevAccess = "false";
        if(userData.getCount()>2)userData.getString(3);
        System.out.println("******** PREVACESS ************");
        System.out.println(prevAccess);
        System.out.println(userData);
        System.out.println("******** PREVACESS ************");
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(prevAccess == "True"){
                    startActivity("MindSpace");

                }else{
                    startActivity("Login");
                }
            }
        },3000);
    }

    // dynamically starting activities and also setting the trigger activity
    public void startActivity(String activityName) {
        Intent intent= null;
        if(activityName.equals("MindSpace"))intent = new Intent(this,MindSpaceActivity.class);
        if(activityName.equals("Login"))intent = new Intent(this,LoginActivity.class);

        if(intent != null) {
            startActivity(intent);
            finish();
        }
    }


}