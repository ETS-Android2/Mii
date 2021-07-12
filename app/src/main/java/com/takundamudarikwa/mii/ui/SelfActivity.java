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

        menuBtn.setOnClickListener(v -> startMenuActivity());
        toMindSpace.setOnClickListener(v -> startMindSpaceActivity());
    }

    public void startMenuActivity() {
        Intent intent=new Intent(this,MenuActivity.class);
        startActivity(intent);
        finish();
    }
    public void startMindSpaceActivity() {
        Intent intent=new Intent(this,MindSpaceActivity.class);
        startActivity(intent);
        finish();
    }
}