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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind_space);

        yesBtn = (Button)findViewById(R.id.yesBtn);
        noBtn = (Button)findViewById(R.id.noBtn);
        idkBtn = (Button)findViewById(R.id.idkBtn);
        menuBtn = (Button) findViewById(R.id.menuBtn);

        yesBtn.setVisibility(View.INVISIBLE);
        noBtn.setVisibility(View.INVISIBLE);
        idkBtn.setVisibility(View.INVISIBLE);
        menuBtn.setVisibility(View.INVISIBLE);

        menuBtn.setOnClickListener(v -> startMenuActivity());

        String[] mindSpaceTxtArray = {
                "You're welcome here..",
                "This is a space for you..",
                "This is a space for your mind..",
                "Are You Happy?"
        };

        mindSpaceTxtView = (FadingTextView)findViewById(R.id.mindSpaceTxtVw);
        mindSpaceTxtView.setTexts(mindSpaceTxtArray);
        mindSpaceTxtView.setTimeout(5000,FadingTextView.MILLISECONDS);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                yesBtn.setVisibility(View.VISIBLE);
                noBtn.setVisibility(View.VISIBLE);
                idkBtn.setVisibility(View.VISIBLE);
                menuBtn.setVisibility(View.VISIBLE);

                mindSpaceTxtView.stop();
                mindSpaceTxtView.setVisibility(View.INVISIBLE);
            }
        },19000);

    }
    public void startMenuActivity() {
        Intent intent=new Intent(this,MenuActivity.class);
        startActivity(intent);
        finish();
    }
}