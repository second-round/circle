package com.example.circlezhuan.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomBingView extends View {
    float[] mAngles;
    RectF rectF;
    Paint paint;
    float mStartAngle=0;
    float textDegree=0;
    String[] str=new String[]{"一等奖","二等奖","三等奖","四等奖","特等奖","谢谢参与奖"};

    public CustomBingView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        paint.setTextSize(40);
        paint.setStyle(Paint.Style.FILL);

        rectF=new RectF();
        rectF.top=150;
        rectF.bottom=650;
        rectF.right=650;
        rectF.left=150;

    }

    public CustomBingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
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
        for (int i=0;i<6;i++){
            if (i%2==0){
                paint.setColor(Color.BLUE);
            }else {
                paint.setColor(Color.YELLOW);
            }
            canvas.drawArc(rectF,mStartAngle,60,true,paint);
            mStartAngle+=60;
            paint.setColor(Color.RED);
            Path path=new Path();
            path.addArc(rectF,textDegree,60);
            canvas.drawTextOnPath(str[i],path,60,60,paint);//设置字体
            textDegree+=60;
        }
    }
}
