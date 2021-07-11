package com.takundamudarikwa.mii.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.takundamudarikwa.mii.R;

public class SelfActivity  extends AppCompatActivity{

    private Button toMindSpace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self);

        toMindSpace = (Button) findViewById(R.id.mindSpaceBtn);
        toMindSpace.setOnClickListener(v -> startMindActivity());
    }

    public void startMindActivity() {
        Intent intent=new Intent(this,MindSpaceActivity.class);
        startActivity(intent);
        finish();
    }
}