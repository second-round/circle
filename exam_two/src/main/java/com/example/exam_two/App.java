package com.example.exam_two;

import android.app.Application;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(this).memoryCacheSize(10).diskCacheSize(50*1024*1024).defaultDisplayImageOptions(new DisplayImageOptions.Builder()
        .cacheOnDisk(true)
        .cacheInMemory(true)
                .build())
                .build()
        );
    }
}
