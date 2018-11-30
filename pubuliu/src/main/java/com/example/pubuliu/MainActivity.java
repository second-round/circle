package com.example.pubuliu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> list=new ArrayList<>();
    UserDao dao;
    CustomWaterFallViewGroup customWaterFallViewGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao=new UserDao(MainActivity.this);
        initView();
    }
    private void initView() {
        final EditText editText = findViewById(R.id.edit);
        customWaterFallViewGroup = findViewById(R.id.water_fall);
        setdata();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取输入框文字
                String str = editText.getText().toString();
                // 将文字放入列表
                dao.add(str);
                // 设置数据
                setdata();
                editText.setText("");
            }
        });
    }

    private void setdata() {
        List<String> select = dao.select();
        customWaterFallViewGroup.setdata(select);
    }
}
