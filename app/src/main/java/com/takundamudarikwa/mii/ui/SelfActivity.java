package com.takundamudarikwa.mii.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.takundamudarikwa.mii.R;

public class SelfActivity  extends AppCompatActivity{

    private Button menuBtn;
    private Button toMindSpace;
    private Button editBtn;
    private EditText sacredName;
    private EditText selfImage;
    private EditText handI1;
    private EditText handI2;
    private EditText handI3;
    private EditText handI4;
    private EditText handI5;
    private EditText handI6;
    private EditText handI7;
    private EditText handI8;
    private EditText handI9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self);

        menuBtn = findViewById(R.id.menuBtn);
        toMindSpace = findViewById(R.id.mindSpaceBtn);
        editBtn = findViewById(R.id.editBtn);

        sacredName = findViewById(R.id.sacredNameTxt);
        selfImage = findViewById(R.id.selfBiotxtVw);
        handI1 = findViewById(R.id.txtHobbiesInterests1);
        handI2 = findViewById(R.id.txtHobbiesInterests2);
        handI3 = findViewById(R.id.txtHobbiesInterests3);
        handI4 = findViewById(R.id.txtHobbiesInterests4);
        handI5 = findViewById(R.id.txtHobbiesInterests5);
        handI6 = findViewById(R.id.txtHobbiesInterests6);
        handI7 = findViewById(R.id.txtHobbiesInterests7);
        handI8 = findViewById(R.id.txtHobbiesInterests8);
        handI9 = findViewById(R.id.txtHobbiesInterests9);

        EditText[] editTextsArray = { sacredName, selfImage,handI1, handI2, handI3, handI4, handI5, handI6, handI7, handI8, handI9};

        for( int i=0; i < editTextsArray.length; i++){
            makeUneditable(editTextsArray[i],false);
        }

        menuBtn.setOnClickListener(v -> startActivity("Menu"));
        toMindSpace.setOnClickListener(v -> startActivity("MindSpace"));
        editBtn.setOnClickListener(v -> editMode(editTextsArray,editBtn));
    }

    public void startActivity(String activityName) {
        Intent intent= null;

        if(activityName.equals("Menu"))intent = new Intent(this,MenuActivity.class);
        if(activityName.equals("MindSpace"))intent = new Intent(this,MindSpaceActivity.class);

        if(intent != null) {
            String menuTriggerActivity = "activity";
            intent.putExtra(menuTriggerActivity, "Self");
            startActivity(intent);
        }
    }

    public void editMode(EditText[] editTextsArray , Button editBtn){
        System.out.println(editBtn.getText());
        if (editBtn.getText().toString().equals("Edit")){
            editBtn.setText("Save");
            for( int i=0; i < editTextsArray.length; i++){
                makeUneditable(editTextsArray[i],true);
                editTextsArray[i].setCompoundDrawablesWithIntrinsicBounds(0, 0,R.drawable.ic_baseline_edit_24, 0);
                editTextsArray[i].setCompoundDrawablePadding(5);
            }
        }else if(editBtn.getText().toString().equals("Save")){
            editBtn.setText("Edit");
            for( int i=0; i < editTextsArray.length; i++){
                makeUneditable(editTextsArray[i],false);
                editTextsArray[i].setCompoundDrawablesWithIntrinsicBounds(0, 0,0, 0);
            }
        }

    }

    public void makeUneditable(EditText e, Boolean setChoice){
        e.setEnabled(setChoice);
    }
}