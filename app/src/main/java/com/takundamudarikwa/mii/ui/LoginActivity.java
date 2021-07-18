package com.takundamudarikwa.mii.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.takundamudarikwa.mii.R;

public class LoginActivity extends AppCompatActivity {
    private Button menuBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        menuBtn = (Button) findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(v -> startActivity("Menu"));
    }

    //this method is for dynamically starting activities and also setting the trigger activity
    public void startActivity(String activityName) {
        Intent intent= null;

        if(activityName.equals("Menu"))intent = new Intent(this,MenuActivity.class);

        //to avoid appending to the null object will ensure that intent is not null
        if(intent != null) {
            String menuTriggerActivity = "activity";
            intent.putExtra(menuTriggerActivity, "Login");
            startActivity(intent);
        }
    }
}