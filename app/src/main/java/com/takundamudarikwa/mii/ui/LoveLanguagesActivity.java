package com.takundamudarikwa.mii.ui;

import com.takundamudarikwa.mii.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LoveLanguagesActivity extends AppCompatActivity {
    private Button menuBtn;
    private Button toLoveLanguageQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lovelanguages);

        menuBtn = findViewById(R.id.menuBtn);
        toLoveLanguageQuiz = findViewById(R.id.btnToLoveLanguages);

        menuBtn.setOnClickListener(v -> startActivity("Menu"));
        toLoveLanguageQuiz.setOnClickListener(v -> openLoveLanguages());
    }

    //this method is for dynamically starting activites and also setting the trigger activity
    public void startActivity(String activityName) {
        Intent intent= null;

        if(activityName.equals("Menu"))intent = new Intent(this,MenuActivity.class);

        if(intent != null) {
            String menuTriggerActivity = "activity";
            intent.putExtra(menuTriggerActivity, "LoveLanguages");
            startActivity(intent);
        }
    }

    //redirect the user to the default device browser and opens the parsed URL
    //might end up changing this to consume an API instead
    public void openLoveLanguages() {
        Uri uri = Uri.parse("https://5lovelanguages.com/quizzes/love-language");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}
