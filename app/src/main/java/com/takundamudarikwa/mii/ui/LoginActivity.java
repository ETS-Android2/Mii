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
        menuBtn.setOnClickListener(v -> startMenuActivity());
    }

    public void startMenuActivity() {
        Intent intent=new Intent(this,MenuActivity.class);
        String menuTriggerActivity = "activity";
        intent.putExtra(menuTriggerActivity,"Login");
        startActivity(intent);
    }
}