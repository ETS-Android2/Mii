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

        menuBtn.setOnClickListener(v -> startMenuActivity());
        toLoveLanguageQuiz.setOnClickListener(v -> openLoveLanguages());
    }

    public void startMenuActivity() {
        Intent intent=new Intent(this,MenuActivity.class);
        String menuTriggerActivity = "activity";
        intent.putExtra(menuTriggerActivity,"LoveLanguages");
        startActivity(intent);
    }
    public void openLoveLanguages() {
        Uri uri = Uri.parse("https://5lovelanguages.com/quizzes/love-language");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}
