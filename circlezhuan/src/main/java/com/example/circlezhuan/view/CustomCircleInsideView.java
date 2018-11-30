package com.example.circlezhuan.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomCircleInsideView extends View {
    Paint paint;
    public CustomCircleInsideView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        paint.setTextSize(40);
        paint.setStyle(Paint.Style.FILL);
    }

    public CustomCircleInsideView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(200, 220);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF=new RectF();
        rectF.top=-100;
        rectF.bottom=100;
        rectF.right=150;
        rectF.left=50;
        paint.setColor(Color.BLACK);
        canvas.drawArc(rectF,60,60,true,paint);
        paint.setColor(Color.RED);
        canvas.drawCircle(100,120,100,paint);
        paint.setColor(Color.BLACK);
        canvas.drawText("开始",60,130,paint);
    }
}
