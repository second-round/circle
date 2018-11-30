package com.example.dey3demo01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Intent intent = getIntent();
        ArrayList<Integer> number1 = intent.getIntegerArrayListExtra("number");

        int aa = number1.get(0);
        int bb = number1.get(1);
        int cc = number1.get(2);

        int[] ints = new int[]{aa,bb,cc};

        CustomStatView customView = findViewById(R.id.custom);
        customView.setNumber(ints);
    }
}
