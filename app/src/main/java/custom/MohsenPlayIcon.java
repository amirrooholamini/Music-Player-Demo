package custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

public class MohsenPlayIcon extends ImageView {

    private float width;
    private float height;
    int strokeWidth = 5;
    private int borderColor = Color.BLACK;
    private int flowColor = Color.RED;
    private int backgroundColor = Color.WHITE;
    private float flowRadius = 0;
    private float radius = 0;
    int sleepTime = 50;

    public MohsenPlayIcon(Context context) {
        super(context);
    }

    public MohsenPlayIcon(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MohsenPlayIcon(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MohsenPlayIcon(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        width = getWidth();
        height = getHeight();

        radius = Math.min(width/2,height/2);
        Paint paint = new Paint();
        paint.setColor(backgroundColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);


        canvas.drawCircle(width/2,height/2,radius-strokeWidth/2,paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(borderColor);
        canvas.drawCircle(width/2,height/2,radius-strokeWidth/2,paint);
        paint.setColor(flowColor);
        canvas.drawCircle(width/2,height/2,flowRadius-strokeWidth/2,paint);


    }

    public void setColor(int borderColor,int flowColor){
        this.borderColor = borderColor;
        this.flowColor = flowColor;
    }

    public void setBackgroundColor(int backgroundColor){
        this.backgroundColor = backgroundColor;
    }

    public void setSleepTime(int sleepTime){
        this.sleepTime = sleepTime;
    }

    public void startFlow(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                while (true){
                        Thread.sleep(sleepTime);
                        flowRadius += radius/50;
                        if(flowRadius>radius){
                            Log.i("LOG","fr : "+flowRadius+" | r : "+radius);
                            flowRadius = strokeWidth/2;
                        }
                        postInvalidate();
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
