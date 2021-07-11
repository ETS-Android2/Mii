package com.takundamudarikwa.mii.ui;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.takundamudarikwa.mii.R;

public class MenuActivity extends AppCompatActivity {
    private Button toMindSpace;
    private Button toSelf;
    private Button toLoveLanguages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        toMindSpace = (Button) findViewById(R.id.mindSpaceBtn);
        toSelf = (Button) findViewById(R.id.selfBtn);
        toLoveLanguages = (Button) findViewById(R.id.loveLanguagesBtn);

        toMindSpace.setOnClickListener(v -> startMindActivity());
        toSelf.setOnClickListener(v -> startSelfActivity());
        toLoveLanguages.setOnClickListener(v -> openLoveLanguages());
    }

    public void startMindActivity() {
        Intent intent=new Intent(this,MindSpaceActivity.class);
        startActivity(intent);
        finish();
    }

    public void startSelfActivity() {
        Intent intent=new Intent(this,SelfActivity.class);
        startActivity(intent);
        finish();
    }

    public void openLoveLanguages() {
        Uri uri = Uri.parse("https://5lovelanguages.com/quizzes/love-language");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}
