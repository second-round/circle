package com.example.dey3demo01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText one, two, three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = findViewById(R.id.edit1);
        two = findViewById(R.id.edit2);
        three = findViewById(R.id.edit3);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入框的值
                int oneNum = Integer.valueOf(one.getText().toString().trim());
                int twoNum = Integer.valueOf(two.getText().toString().trim());
                int threeNum = Integer.valueOf(three.getText().toString().trim());

                if (oneNum<0 || oneNum>100){
                    Toast.makeText(MainActivity.this,"只能输入0-100的数字",Toast.LENGTH_SHORT).show();
                    one.setText(0);
                    oneNum= Integer.valueOf(0);
                    return;
                }
                if (twoNum<0 || twoNum>100){
                    Toast.makeText(MainActivity.this,"只能输入0-100的数字",Toast.LENGTH_SHORT).show();
                    two.setText(0);
                    twoNum= Integer.valueOf(0);
                    return;
                }
                if (threeNum<0 || threeNum>100){
                    Toast.makeText(MainActivity.this,"只能输入0-100的数字",Toast.LENGTH_SHORT).show();
                    three.setText(0);
                    threeNum= Integer.valueOf(0);
                    return;
                }
                ArrayList<Integer> list = new ArrayList<>();
                list.add(oneNum);
                list.add(twoNum);
                list.add(threeNum);

                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                intent.putIntegerArrayListExtra("number",list);
                startActivity(intent);
            }
        });

    }
}
