package com.takundamudarikwa.mii.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.takundamudarikwa.mii.R;
import com.takundamudarikwa.mii.model.DBHelper;


public class LoginActivity extends AppCompatActivity {
    private Handler handler;
    private Button menuBtn;
    private Button saveBtn;

    private TableLayout introLayout;
    private TextView header;
    private TextView givenName;
    private TextView familyName;
    private TextView email;
    private TextView phone;

    private DBHelper usersDB = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        header = findViewById(R.id.appNameLabel);

        menuBtn = findViewById(R.id.menuBtn);
        saveBtn = findViewById(R.id.btnSubmitLogin);

        menuBtn.setOnClickListener(v -> startActivity("Menu"));

        introLayout = findViewById(R.id.introLayout);
        givenName = findViewById(R.id.txtGivenName);
        familyName = findViewById(R.id.txtFamilyName);
        email = findViewById(R.id.txtEmail);
        phone = findViewById(R.id.txtPhone);

        saveBtn.setOnClickListener(v -> saveNewUser(givenName.getText(),familyName.getText(),email.getText(),phone.getText(),header,introLayout,saveBtn,menuBtn));

    }

    //this method is for dynamically starting activities and also setting the trigger activity
    public void startActivity(String activityName) {
        Intent intent= null;

        if(activityName.equals("Menu"))intent = new Intent(this,MenuActivity.class);
        if(activityName.equals("MindSpace"))intent = new Intent(this,MindSpaceActivity.class);

        //to avoid appending to the null object will ensure that intent is not null
        if(intent != null) {
            String menuTriggerActivity = "activity";
            intent.putExtra(menuTriggerActivity, "Login");
            startActivity(intent);
        }
    }

    public void saveNewUser(CharSequence givenName, CharSequence familyName, CharSequence email, CharSequence phone, TextView header, TableLayout introLayout, Button saveBtn, Button menuBtn){
        String valid = validateInput(givenName,familyName,email,phone);
        // todo cache database user creation response in order to use that for future user app access
        if(valid == "True"){
            String createdNewUser =  usersDB.createNewUser(givenName.toString(),familyName.toString(), email.toString(), phone.toString());
            toastMessages(createdNewUser);
            takingYouToMindSpace(introLayout,saveBtn,header,menuBtn);
        }else{
            toastMessages(valid);
        }
    }

    public String validateInput(CharSequence  giveName, CharSequence  lastName, CharSequence email, CharSequence phone){
        if(giveName.toString().isEmpty() || lastName.toString().isEmpty() || email.toString().isEmpty() || phone.toString().isEmpty()){
            return "Please make sure you've entered all the fields";
        }else if(Patterns.EMAIL_ADDRESS.matcher(email).matches() == false || Patterns.PHONE.matcher(phone).matches() == false){
            return "Please enter a valid email address or phone number";
        }
        return "True";
    }

    public void toastMessages(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }

    public void takingYouToMindSpace(TableLayout introLayout, Button saveBtn, TextView header, Button menuBtn){
        header.setText(" .. to Mindspace ..");
        //header.setPadding(0,50,0,0);
        header.setHeight(1550);
        introLayout.setVisibility(View.INVISIBLE);
        saveBtn.setVisibility(View.INVISIBLE);
        menuBtn.setVisibility(View.INVISIBLE);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity("MindSpace");
            }
        },2000);
    }
}