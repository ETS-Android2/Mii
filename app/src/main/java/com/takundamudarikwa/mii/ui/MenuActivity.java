package com.takundamudarikwa.mii.ui;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.takundamudarikwa.mii.R;

public class MenuActivity extends AppCompatActivity {
    private String tActivty;
    private Button toAbout;
    private Button toAffirmationsCorner;
    private Button toBadges;
    private Button toCommune;
    private Button toShadowWork;
    private Button toSitwithMii;
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

        // inactive menu items
        toAbout = findViewById(R.id.aboutBtn);
        toAffirmationsCorner = findViewById(R.id.affirmationsBtn);
        toBadges = findViewById(R.id.badgesBtn);
        toCommune = findViewById(R.id.communeBtn);
        toShadowWork = findViewById(R.id.shadowWorkBtn);
        toSitwithMii = findViewById(R.id.sitWithMiiBtn);

        // creating an array of inactive menu items so that we can dynamically set the same options on them
        Button[] inactiveMenuItems = {toAbout,toAffirmationsCorner,toBadges,toCommune,toShadowWork,toSitwithMii};
        for(int i=0; i<inactiveMenuItems.length;i++){
            notYetActive(inactiveMenuItems[i]);
        }
        // setting onclick listeners for our buttons
        toMindSpace.setOnClickListener(v -> startActivity("MindSpace"));
        toSelf.setOnClickListener(v -> startActivity("Self"));
        toLoveLanguages.setOnClickListener(v -> startActivity("LoveLanguages"));

        // to get the previously accessed activity we grab the set value in the getIntent()
        tActivty = getIntent().getStringExtra("activity");
        closeMenu.setOnClickListener(v -> returnToPreviousActivity(tActivty));
    }

    // dynamically starting activities and also setting the trigger activity
    public void startActivity(String activityName) {
        Intent intent= null;
        if(activityName.equals("LoveLanguages"))intent = new Intent(this,LoveLanguagesActivity.class);
        if(activityName.equals("MindSpace"))intent = new Intent(this,MindSpaceActivity.class);
        if(activityName.equals("Self"))intent = new Intent(this,SelfActivity.class);

        if(intent != null) {
            startActivity(intent);
            finish();
        }
    }

    // when the close menu button is clicked we dynamically take the user back to their previous activity
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

    // we don't not have all our menu buttons linked to activities yet.
    // till then we can use this method to to gray them out and display a message to let the user know of our future intent
    public void notYetActive(Button b){
        b.setTextColor(getResources().getColor(R.color.lightgray));
        String menuName = b.getText().toString();
        b.setOnClickListener(v -> toastMessages(""+menuName+" is not quite ready. Stay tuned!"));
    }

    public void toastMessages(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }
}
