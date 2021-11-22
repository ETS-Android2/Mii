package com.takundamudarikwa.mii.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.takundamudarikwa.mii.R;

public class SelfActivity  extends AppCompatActivity{

    private Button menuBtn;
    private Button toMindSpace;
    private Button editBtn;
    private Button cancelBtn;
    private Button uploadImg1;
    private Button uploadImg2;
    private Button uploadImg3;
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
    private ImageButton imageBtn1;
    private ImageButton imageBtn2;
    private ImageButton imageBtn3;
    private LinearLayout uploadImgsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self);

        menuBtn = findViewById(R.id.menuBtn);
        toMindSpace = findViewById(R.id.mindSpaceBtn);
        editBtn = findViewById(R.id.editBtn);
        cancelBtn = findViewById(R.id.cancelEditBtn);

        // creating instances of all the fields that the user may enter data into
        // todo I have to grab that database values to set the the fields with the saved if not empty. Might do it on line 50
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
        imageBtn1 = findViewById(R.id.imagePlaceHolder);
        imageBtn2 = findViewById(R.id.imagePlaceHolder2);
        imageBtn3 = findViewById(R.id.imagePlaceHolder3);
        uploadImgsLayout = findViewById(R.id.selfPUploadImages);
        uploadImg1 = findViewById(R.id.uploadBtn1);
        uploadImg2 = findViewById(R.id.uploadBtn2);
        uploadImg3 = findViewById(R.id.uploadBtn3);

        EditText[] editTextsArray = {sacredName, selfImage,handI1, handI2, handI3, handI4, handI5, handI6, handI7, handI8, handI9};
        Button[] editBtns = {editBtn,cancelBtn};

        // iterating over all the editable elements to make the uneditable
        for( int i=0; i < editTextsArray.length; i++){
            makeUneditable(editTextsArray[i],false);
        }

        // setting onclicklisteners for our buttons
        menuBtn.setOnClickListener(v -> startActivity("Menu"));
        toMindSpace.setOnClickListener(v -> startActivity("MindSpace"));
        editBtn.setOnClickListener(v -> editMode(editTextsArray,editBtns));
        cancelBtn.setOnClickListener(v -> exitEditMode(editTextsArray,editBtns));
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

    // edit mode configurations
    public void editMode(EditText[] editTextsArray , Button[] editBtns){
        if (editBtns[0].getText().toString().equals("Edit")){
            editBtns[0].setText("Save");
            editBtns[1].setVisibility(View.VISIBLE);
            for( int i=0; i < editTextsArray.length; i++){
                makeUneditable(editTextsArray[i],true);
                editTextsArray[i].setCompoundDrawablesWithIntrinsicBounds(0, 0,R.drawable.ic_baseline_edit_24, 0);
                editTextsArray[i].setCompoundDrawablePadding(5);
            }
            uploadImgsLayout.setVisibility(View.VISIBLE);
            uploadImg1.setVisibility(View.VISIBLE);
            uploadImg2.setVisibility(View.VISIBLE);
            uploadImg3.setVisibility(View.VISIBLE);
        }else if(editBtns[0].getText().toString().equals("Save")){
            editBtns[0].setText("Edit");
            editBtns[1].setVisibility(View.INVISIBLE);
            for( int i=0; i < editTextsArray.length; i++){
                makeUneditable(editTextsArray[i],false);
                editTextsArray[i].setCompoundDrawablesWithIntrinsicBounds(0, 0,0, 0);
            }
            uploadImgsLayout.setVisibility(View.INVISIBLE);
            uploadImg1.setVisibility(View.INVISIBLE);
            uploadImg2.setVisibility(View.INVISIBLE);
            uploadImg3.setVisibility(View.INVISIBLE);
        }
    }

    public void exitEditMode(EditText[] editTextsArray, Button[] editBtns){
        //simply call our editMode to exit edit mode
        editMode(editTextsArray,editBtns);
    }
    public void getImages(){};
    public void makeUneditable(EditText e, Boolean setChoice){
        e.setEnabled(setChoice);
    }
}