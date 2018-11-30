package ningjiaxin1.bwie.com.day2_lian;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class xiao extends View {
    Paint mPaint;
    private  float mStartAngle=60;
    public xiao(Context context) {
        super(context);
        init();
    }

    public xiao(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init(){
      mPaint=new Paint();
      mPaint.setColor(Color.RED);
      mPaint.setStrokeWidth(10);
      mPaint.setTextSize(40);
      mPaint.setStyle(Paint.Style.FILL);
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
        //canvas.drawColor(Color.RED);
        RectF rectF = new RectF();
        rectF.top = 100;
        rectF.bottom = 200;
        rectF.right = 400;
        rectF.left = 300;
        canvas.drawArc(rectF,60,60,true,mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawArc(rectF, mStartAngle , 60, true, mPaint);
     //   mStartAngle+=mStartAngle;
          mPaint.setColor(Color.RED);
          canvas.drawCircle(350, 280, 100, mPaint);
          mPaint.setColor(Color.BLACK);
          canvas.drawText("开始", 310, 300, mPaint);
    }
}
