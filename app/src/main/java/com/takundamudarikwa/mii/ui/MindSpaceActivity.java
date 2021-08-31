package com.takundamudarikwa.mii.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import com.takundamudarikwa.mii.R;
import com.tomer.fadingtextview.FadingTextView;

public class MindSpaceActivity extends AppCompatActivity {
    private FadingTextView mindSpaceTxtView;
    private Button yesBtn;
    private Button noBtn;
    private Button idkBtn;
    private Button menuBtn;
    private Handler handler;
    private int counter = 0;
    private String mindSpacePrevAccess = "false";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind_space);

        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);
        idkBtn = findViewById(R.id.idkBtn);
        menuBtn = findViewById(R.id.menuBtn);

        yesBtn.setOnClickListener(v -> printToConfirm("Yes")); // todo: this will redirect you to the recording screen
        noBtn.setOnClickListener(v -> printToConfirm("NO")); // todo: if its the user's first time and they press NO they should be taken to a page with general uplifting message ELSE they're redirected to the previously recorded messages
        idkBtn.setOnClickListener(v -> printToConfirm("I DON'T KNOW")); // todo: redirects to the Confirmation Corner

        yesBtn.setVisibility(View.INVISIBLE);
        noBtn.setVisibility(View.INVISIBLE);
        idkBtn.setVisibility(View.INVISIBLE);
        menuBtn.setVisibility(View.INVISIBLE);

        menuBtn.setOnClickListener(v -> startActivity("Menu"));

        // to get the previously accessed activity we grab the set value in the getIntent()
        mindSpacePrevAccess = getIntent().getStringExtra("mindSpacePrevAccess");
        String[] mindSpaceTxtArray = {};
        int timeOut = 5100;
        int timeOut2 = 16500;

        if(mindSpacePrevAccess.equals("true")) mindSpaceTxtArray = new String[]{"Are You Happy?"};
        if(mindSpacePrevAccess.equals("false")) mindSpaceTxtArray = new String[]{"You're welcome here..", "This is a space for you..", "This is a space for your mind..", "Are You Happy?"};

        if(mindSpaceTxtArray.length == 1) timeOut = 6000;
        if(mindSpaceTxtArray.length == 1) timeOut2 = timeOut;

        mindSpaceTxtView = findViewById(R.id.mindSpaceTxtVw);
        mindSpaceTxtView.setTexts(mindSpaceTxtArray);
        mindSpaceTxtView.setTimeout(timeOut,FadingTextView.MILLISECONDS);
        handler=new Handler();
        handler.postDelayed(() -> {
            yesBtn.setVisibility(View.VISIBLE);
            noBtn.setVisibility(View.VISIBLE);
            idkBtn.setVisibility(View.VISIBLE);
            menuBtn.setVisibility(View.VISIBLE);
            menuBtn.setVisibility(View.VISIBLE);

            mindSpaceTxtView.stop();
            mindSpaceTxtView.setVisibility(View.INVISIBLE);
        },timeOut2);

    }
    //this method is for dynamically starting activities and also setting the trigger activity
    public void startActivity(String activityName) {
        Intent intent= null;

        if(activityName.equals("Menu"))intent = new Intent(this,MenuActivity.class);

        //to avoid appending to the null object will ensure that intent is not null
        if(intent != null) {
            String menuTriggerActivity = "activity";
            intent.putExtra(menuTriggerActivity, "MindSpace");
            startActivity(intent);
        }
    }

    public void printToConfirm(String btn){
        System.out.println("You clicked the "+btn+" button");
    }
}