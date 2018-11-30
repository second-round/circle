package com.example.exam_two;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.exam_two.bean.UserBean;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import me.maxwin.view.XListView;

public class MainActivity extends AppCompatActivity {
    private XListView xListView;
    private XlistAdapter adapter;
    private int page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        page=1;
        xListView=findViewById(R.id.xList);
        xListView.setPullLoadEnable(true);
        xListView.setPullRefreshEnable(true);
        adapter=new XlistAdapter(MainActivity.this);
        xListView.setAdapter(adapter);
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                page=1;
                load();
            }

            @Override
            public void onLoadMore() {
                load();
            }
        });
        load();
    }
    @SuppressLint("StaticFieldLeak")
    private void load() {
        new AsyncTask<String, Void, List<UserBean.DataBean>>() {
            @Override
            protected List<UserBean.DataBean> doInBackground(String... strings) {
                try {
                    URL url=new URL(strings[0]);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.setReadTimeout(5000);
                    int responseCode = urlConnection.getResponseCode();
                    if (responseCode==200){
                        String s=stream2string(urlConnection.getInputStream());
                        UserBean userBean = new Gson().fromJson(s, UserBean.class);;
                        return userBean.getData();

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(List<UserBean.DataBean> dataBeans) {
                super.onPostExecute(dataBeans);
                if (page==1){
                    adapter.setList(dataBeans);
                }else {
                    adapter.addList(dataBeans);
                }
                page++;
                xListView.stopLoadMore();
                xListView.stopRefresh();
            }
        }.execute("http://www.xieast.com/api/news/news.php?page="+page);
    }

    private String stream2string(InputStream inputStream) throws IOException {
        InputStreamReader reader=new InputStreamReader(inputStream);
        BufferedReader bf=new BufferedReader(reader);
        StringBuilder builder=new StringBuilder();
        for (String emp=bf.readLine();emp!=null;emp=bf.readLine()){
            builder.append(emp);
        }
        return builder.toString();
    }
}
