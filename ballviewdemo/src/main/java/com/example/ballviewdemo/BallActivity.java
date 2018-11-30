package com.example.ballviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BallActivity extends AppCompatActivity {
    BallView ballView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball);
        ballView=findViewById(R.id.ball);
    }
}
