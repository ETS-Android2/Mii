package com.takundamudarikwa.mii.ui;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.takundamudarikwa.mii.R;

public class MenuActivity extends AppCompatActivity {
    private String tActivty;
    private Button toMindSpace;
    private Button toSelf;
    private Button toLoveLanguages;
    private Button closeMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        toMindSpace = findViewById(R.id.mindSpaceBtn);
        toSelf = findViewById(R.id.selfBtn);
        toLoveLanguages = findViewById(R.id.loveLanguagesBtn);
        closeMenu = findViewById(R.id.btnCloseMenu);


        tActivty = getIntent().getStringExtra("activity");
        toMindSpace.setOnClickListener(v -> startMindSpaceActivity());
        toSelf.setOnClickListener(v -> startSelfActivity());
        toLoveLanguages.setOnClickListener(v -> startLoveLangaugesActivity());
        closeMenu.setOnClickListener(v -> returnToPreviousActivity(tActivty));
    }

    public void startMindSpaceActivity() {
        Intent intent=new Intent(this,MindSpaceActivity.class);
        startActivity(intent);
        finish();
    }

    public void startSelfActivity() {
        Intent intent=new Intent(this,SelfActivity.class);
        startActivity(intent);
    }

    public void startLoveLangaugesActivity() {
        Intent intent=new Intent(this,LoveLanguagesActivity.class);
        startActivity(intent);
    }

    public void returnToPreviousActivity(String tActivity){
        if(tActivity.trim().equals("Login")) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else if(tActivity.trim().equals("LoveLanguages")) {
            Intent intent = new Intent(this, LoveLanguagesActivity.class);
            startActivity(intent);
        }else if(tActivity.trim().equals("MindSpace")) {
            Intent intent = new Intent(this, MindSpaceActivity.class);
            startActivity(intent);
        }else if(tActivity.trim().equals("Self")){
            Intent intent=new Intent(this,SelfActivity.class);
            startActivity(intent);
        }
    }
}
