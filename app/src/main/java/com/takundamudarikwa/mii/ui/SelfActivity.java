package com.takundamudarikwa.mii.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.takundamudarikwa.mii.R;

public class SelfActivity  extends AppCompatActivity{

    private Button menuBtn;
    private Button toMindSpace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self);

        menuBtn = findViewById(R.id.menuBtn);
        toMindSpace = findViewById(R.id.mindSpaceBtn);

        menuBtn.setOnClickListener(v -> startActivity("Menu"));
        toMindSpace.setOnClickListener(v -> startActivity("MindSpace"));
    }

    public void startActivity(String activityName) {
        Intent intent= null;

        if(activityName.equals("Menu"))intent = new Intent(this,MenuActivity.class);
        if(activityName.equals("MindSpace"))intent = new Intent(this,MindSpaceActivity.class);

        if(intent != null) {
            String menuTriggerActivity = "activity";
            intent.putExtra(menuTriggerActivity, "MindSpace");
            startActivity(intent);
        }
    }
}