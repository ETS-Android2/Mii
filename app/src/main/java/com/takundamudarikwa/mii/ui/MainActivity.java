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
    private String prevAccess = "false";
    private String mindSpacePrevAccess = "false";

    //private File saveFile = new File(context.getFilesDir(),filename);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        // open database
        usersDB.open();

        // loading the gif icon
        gifImageView = findViewById(id.gifImageView);
        Glide.with(this).load(drawable.miilogo).into(gifImageView);

        // fetching userData if
        Cursor userData = usersDB.fetchUser();
        if(userData.moveToFirst()) prevAccess = userData.getString(userData.getColumnIndex("prev_access"));
        if(userData.moveToFirst()) mindSpacePrevAccess = userData.getString(userData.getColumnIndex("mindspace_prev_access"));
        userData.close();
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(prevAccess.equals("true")){
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
            if(mindSpacePrevAccess.equals("true")){
                String mindspaceprevacccess = "mindSpacePrevAccess";
                intent.putExtra(mindspaceprevacccess, "true");
                startActivity(intent);
                finish();
            }else{
                startActivity(intent);
                finish();
            }
        }
    }


}