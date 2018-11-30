package com.example.circlezhuan;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;

import com.example.circlezhuan.view.CustomBingView;
public class MainActivity extends AppCompatActivity {
    private CustomBingView customBingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customBingView=findViewById(R.id.zhuan);
        findViewById(R.id.dian).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float degree= (float) (720+Math.random()*1000);
                RotateAnimation animation=new RotateAnimation(0,-degree,400,400);
                animation.setDuration(5000);
                animation.setFillAfter(true);
                customBingView.startAnimation(animation);
            }
        });
    }
}