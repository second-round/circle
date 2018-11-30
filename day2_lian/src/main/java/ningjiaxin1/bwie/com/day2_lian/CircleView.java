package ningjiaxin1.bwie.com.day2_lian;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CircleView extends View {
    Paint mpaint;
    int mCircleCount=6;
    RectF rectF;
    float mStartAngle=0;
    public CircleView(Context context) {
        super(context);
        init();
    }
    public CircleView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        String string = typedArray.getString(R.styleable.CircleView_text);
        init();
    }
    private void init(){
        mpaint = new Paint();
        mpaint.setColor(Color.RED);
        mpaint.setStrokeWidth(10);
        mpaint.setTextSize(60);
        mpaint.setStyle(Paint.Style.FILL);
        rectF = new RectF();
        rectF.top=100;
        rectF.left=100;
        rectF.bottom=600;
        rectF.right=600;
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float mTouchX;
                float mTouchY;
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //获取点击位置的x,y
                    mTouchX = event.getX();
                    mTouchY = event.getY();
                }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    //获取点击位置的x,y
                    mTouchX = event.getX();
                    mTouchY = event.getY();
                }

                invalidate();
                return true;
            }
        });

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i=0;i<mCircleCount;i++){
            if(i%2==0){
                mpaint.setColor(Color.BLUE);
            }
            else{
                mpaint.setColor(Color.LTGRAY);
            }
            canvas.drawArc(rectF,mStartAngle,60,true,mpaint);
            mStartAngle+=60;
        }
    }
}