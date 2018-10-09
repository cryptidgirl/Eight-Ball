package com.bignerdranch.android.eightball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class EightBallActivity extends AppCompatActivity {
    private String[] fortune_list;
    private Button mShakeButton;
    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_ball);
        Intent intent = getIntent();

        mName = intent.getStringExtra("mUsername");

        fortune_list = getResources().getStringArray(R.array.fortunes);

        mShakeButton = (Button) findViewById(R.id.shake_button);
        mShakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView magic_fortune = (TextView) findViewById(R.id.magic_fortune);
                int randomIndex = new Random().nextInt(fortune_list.length);
                String randomFortune = fortune_list[randomIndex];
                magic_fortune.setText(randomFortune + ", " + mName);
            }
        });
    }


}
