package com.takundamudarikwa.mii.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.takundamudarikwa.mii.R;

public class RecordActivity extends AppCompatActivity {
    private Button recordVideoBtn;
    private Button recordAudioBtn;
    private Button menuBtn;

    static final int REQUEST_VIDEO_CAPTURE;

    static {
        REQUEST_VIDEO_CAPTURE = 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind_space);

        recordAudioBtn = findViewById(R.id.recordAudio);
        recordVideoBtn = findViewById(R.id.recordVideo);
        menuBtn = findViewById(R.id.menuBtn);

        recordAudioBtn.setOnClickListener(v -> printToConfirm("Yes")); // todo: this will redirect you to the recording screen
        recordVideoBtn.setOnClickListener(v -> dispatchTakeVideoIntent()); // todo: if its the user's first time and they press NO they should be taken to a page with general uplifting message ELSE they're redirected to the previously recorded message

        menuBtn.setOnClickListener(v -> startActivity("Menu"));
    }
    //this method is for dynamically starting activities and also setting the trigger activity
    public void startActivity(String activityName) {
        Intent intent= null;

        if(activityName.equals("Menu"))intent = new Intent(this,MenuActivity.class);

        //to avoid appending to the null object will ensure that intent is not null
        if(intent != null) {
            String menuTriggerActivity = "activity";
            intent.putExtra(menuTriggerActivity, "Record");
            startActivity(intent);
        }
    }


    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = intent.getData();
            VideoView videoView = null;
            videoView.setVideoURI(videoUri);
        }
    }
    public void printToConfirm(String btn){
        System.out.println("You clicked the "+btn+" button");
    }
}
