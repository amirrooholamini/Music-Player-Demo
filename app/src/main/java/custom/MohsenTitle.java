package custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import com.i3center.android.musicdemo.App;

import java.util.ArrayList;

public class MohsenTitle extends LinearLayout {
    Paint paint;
    private int textSize = 100;
    private String name = "";
    private ArrayList<Integer> rgb = new ArrayList<>();
    private int alpha = 255;
    boolean isMoving = false;
    int sleepTime = 5000;

    float movePositionX = 0;
    int moveAlpha = 0;

    float width;
    float height;

    public MohsenTitle(Context context) {
        super(context);
        setWillNotDraw(false);
        rgb.add(0);
        rgb.add(0);
        rgb.add(0);

    }

    public MohsenTitle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        rgb.add(0);
        rgb.add(0);
        rgb.add(0);

    }

    public MohsenTitle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
        rgb.add(0);
        rgb.add(0);
        rgb.add(0);

    }

    public MohsenTitle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setWillNotDraw(false);
        rgb.add(0);
        rgb.add(0);
        rgb.add(0);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        width = getWidth();
        height = getHeight();

        paint = new Paint();
        paint.setTextSize(textSize);
        paint.setStyle(Paint.Style.FILL);
        paint.setARGB(alpha, rgb.get(0), rgb.get(1), rgb.get(2));
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(App.mohsenTitleFont);
        //paint.setShadowLayer(1, 2, 2, Color.parseColor("#000000"));
        // COMMENT FOR GIT
            canvas.drawText(name, width / 2, height / 2 - (paint.ascent() + paint.descent()) / 2, paint);
        if (moveAlpha > 0) {
            paint.setAlpha(moveAlpha);
            canvas.drawText(name, 3 * width / 4 + movePositionX, getHeight() / 2 - (paint.ascent() + paint.descent()) / 2, paint);
            canvas.drawText(name, width / 4 - movePositionX, getHeight() / 2 - (paint.ascent() + paint.descent()) / 2, paint);
        }
    }

    public void setTextSize(int size) {
        textSize = size;
        postInvalidate();

    }

    public void setText(String name) {
        this.name = name;
        postInvalidate();
    }

    public void setSleepTime(int sleepTime){
        this.sleepTime = sleepTime;
    }

    public void setARGB(int alpha , int r, int g, int b) {
        this.alpha = alpha;
        rgb = new ArrayList<>();
        rgb.add(r);
        rgb.add(g);
        rgb.add(b);
        postInvalidate();
    }

    private String convertToTimeFormat(int time) {
        time = time / 1000;
        String stringTime = "";
        int minutes = time / 60;
        int seconds = time % 60;
        if (minutes < 10) {
            stringTime += "0";
        }
        stringTime += minutes;
        stringTime += ":";

        if (seconds < 10) {
            stringTime += "0";
        }
        stringTime += seconds;
        return stringTime;
    }


    public void startMove() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int time = 0;

                    while (true) {
                        Thread.sleep(sleepTime);
                        time += sleepTime;
                        if (time % sleepTime < 30 && !isMoving) {
                            isMoving = true;
                            move();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    private void move() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    movePositionX = 0;
                    moveAlpha = 100;
                    while (moveAlpha > 0) {
                        movePositionX += width / 200;
                        Thread.sleep(20);
                        moveAlpha -= 2;
                        postInvalidate();
                    }
                    isMoving = false;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
