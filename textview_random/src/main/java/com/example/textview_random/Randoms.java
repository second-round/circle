package com.example.textview_random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class Randoms extends android.support.v7.widget.AppCompatTextView {
//    Paint paint;

    public Randoms(Context context) {
        super(context);
//        init();
    }

    private void init() {
//        paint=new Paint();
//        paint.setTextSize(30);
//        paint.setColor(Color.YELLOW);
//        paint.setStrokeWidth(5);
//        paint.setStyle(Paint.Style.FILL);
    }

    public Randoms(Context context, AttributeSet attrs) {
        super(context, attrs);
//        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawCircle(200,200,100,paint);
    }
}
