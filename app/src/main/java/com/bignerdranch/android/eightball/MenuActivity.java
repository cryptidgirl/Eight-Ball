package com.bignerdranch.android.eightball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private Button mAboutButton;
    private Button mStartButton;
    private Button mSubmitButton;
    private EditText mSubmittedText;
    private String mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mSubmittedText = (EditText) findViewById(R.id.user_name);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUsername = mSubmittedText.getText().toString();
                Toast.makeText(MenuActivity.this, "Press Start and get your fortune told, " + mUsername, Toast.LENGTH_SHORT).show();
            }
        });


        mStartButton = (Button) findViewById(R.id.start_button);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, EightBallActivity.class);
                intent.putExtra("mUsername", mUsername);
                startActivity(intent);
            }
        });

        mAboutButton = (Button) findViewById(R.id.about_button);
        mAboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}
