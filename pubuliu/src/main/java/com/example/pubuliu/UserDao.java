package com.example.pubuliu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    SQLiteDatabase database;
    SqlHelper sqlHelper;

    public UserDao(Context context) {
        sqlHelper=new SqlHelper(context);
        database=sqlHelper.getWritableDatabase();
    }
    public void add(String info){
        ContentValues values=new ContentValues();
        values.put("info",info);
        database.insert("users",null,values);
    }

    public List<String> select(){
        List<String> list=new ArrayList<>();
        Cursor users = database.query("users", null, null, null, null, null, null);
        while (users.moveToNext()){
            String info = users.getString(users.getColumnIndex("info"));
            list.add(info);
        }
        return list;
    }

}
