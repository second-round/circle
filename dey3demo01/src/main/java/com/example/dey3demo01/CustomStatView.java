package com.example.dey3demo01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.List;

public class CustomStatView extends View {

    Paint mPaint;
    int[] mFloats=new int[]{};

    public CustomStatView(Context context) {
        this(context, null);
        init();
    }
    public CustomStatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(30);
        setBackgroundColor(Color.GREEN);
    }
    public void setNumber(int[] ints) {
         this.mFloats = ints;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("100", 20, 25, mPaint);
        canvas.drawLine(50,30,50,500, mPaint);
        canvas.drawLine(50, 500, 600, 500, mPaint);
        canvas.drawRect(80,(float)(500-mFloats[0]*4.7),130,500,mPaint);
        canvas.drawText((float)mFloats[0]+"", 70, 550, mPaint);
        canvas.drawRect(180,(float)(500-mFloats[1]*4.7),230,500,mPaint);
        canvas.drawText((float)mFloats[1]+"", 175, 550, mPaint);
        canvas.drawRect(280,(float)(500-mFloats[2]*4.7),330,500,mPaint);
        canvas.drawText((float)mFloats[2]+"", 280, 550, mPaint);
    }
}