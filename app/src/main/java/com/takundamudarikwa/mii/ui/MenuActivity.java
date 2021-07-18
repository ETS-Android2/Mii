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
        toMindSpace.setOnClickListener(v -> startActivity("MindSpace"));
        toSelf.setOnClickListener(v -> startActivity("Self"));
        toLoveLanguages.setOnClickListener(v -> startActivity("LoveLanguages"));
        closeMenu.setOnClickListener(v -> returnToPreviousActivity(tActivty));
    }

    //this method is for dynamically starting activities and also setting the trigger activity
    public void startActivity(String activityName) {
        Intent intent= null;

        if(activityName.equals("LoveLangauges"))intent = new Intent(this,LoveLanguagesActivity.class);
        if(activityName.equals("MindSpace"))intent = new Intent(this,MindSpaceActivity.class);
        if(activityName.equals("Self"))intent = new Intent(this,SelfActivity.class);

        if(intent != null) {
            startActivity(intent);
            finish();
        }
    }

    //when the close menu button is clicked we dynamically take the user back to their previous activity
    public void returnToPreviousActivity(String tActivity){
        Intent intent = null;

        if(tActivity.trim().equals("Login"))intent = new Intent(this, LoginActivity.class);
        if(tActivity.trim().equals("LoveLanguages")) intent = new Intent(this, LoveLanguagesActivity.class);
        if(tActivity.trim().equals("MindSpace")) intent = new Intent(this, MindSpaceActivity.class);
        if(tActivity.trim().equals("Self"))intent=new Intent(this,SelfActivity.class);

        if(intent != null){
            startActivity(intent);
        }
    }
}
