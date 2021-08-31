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
    private Button[] btns;
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

        btns = new Button[]{yesBtn,noBtn,idkBtn,menuBtn};
        setVisibility(btns,"invisible");

        menuBtn.setOnClickListener(v -> startActivity("Menu"));

        String[] mindSpaceTxtArray = {
                "You're welcome here..",
                "This is a space for you..",
                "This is a space for your mind..",
                "Are You Happy?"
        };

        mindSpaceTxtView = findViewById(R.id.mindSpaceTxtVw);
        mindSpaceTxtView.setTexts(mindSpaceTxtArray);
        mindSpaceTxtView.setTimeout(5000,FadingTextView.MILLISECONDS);
        handler=new Handler();
        handler.postDelayed(() -> {
            setVisibility(btns,"visible");

            mindSpaceTxtView.stop();
            mindSpaceTxtView.setVisibility(View.INVISIBLE);
        },16500);

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

    public void setVisibility(Button[] btns, String visibility){
        for(int i=0;i < btns.length; i++){
            if(visibility == "visible"){
                btns[i].setVisibility(View.VISIBLE);
            }else{
                btns[i].setVisibility(View.INVISIBLE);
            }
        }
    }
    
    public void printToConfirm(String btn){
        System.out.println("You clicked the "+btn+" button");
    }
}
