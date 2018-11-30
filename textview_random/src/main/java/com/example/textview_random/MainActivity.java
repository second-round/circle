package com.example.textview_random;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Randoms randoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randoms=findViewById(R.id.randoms);
        final Random rand = new Random();
        randoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=rand.nextInt(9000)+1000;
                String a=""+i;
                randoms.setText(a);
                randoms.setBackgroundColor(getResources().getColor(R.color.RED));
            }
        });
    }
}
