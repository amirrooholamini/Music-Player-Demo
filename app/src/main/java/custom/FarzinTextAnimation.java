package custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import com.i3center.android.musicdemo.App;

import java.util.ArrayList;

public class FarzinTextAnimation extends LinearLayout {
    int currentTime = 0;
    int size = 0;
    int sleepTime = 20;
    int textSize = 100;
    private ArrayList<String> texts;
    private ArrayList<Integer> passedTimes;
    private ArrayList<Integer> realDurations;
    private float[][] startCordinates;
    private float[][] endCordinates;
    private ArrayList<String> colors;
    private int[] alphas;
    private ArrayList<Float> stepsX;
    private ArrayList<Float> stepsY;
    private ArrayList<Integer> startTimes;
    private ArrayList<Integer> fontSizes;

    Typeface font = App.shekastehFont;

    float width = getWidth();
    float height = getHeight();
    Paint paint;


    public FarzinTextAnimation(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public FarzinTextAnimation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    public FarzinTextAnimation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
    }

    public FarzinTextAnimation(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < size; i++) {
            String text = texts.get(i);
            float startX = startCordinates[i][0];
            float startY = startCordinates[i][1];
            float endX = endCordinates[i][0];
            float endY = endCordinates[i][1];
            int passedTime = passedTimes.get(i);
            int realDuration = realDurations.get(i);

            if (passedTime>=realDuration || currentTime<startTimes.get(i)) {
                continue;
            }

            paint.setColor(Color.parseColor(colors.get(i)));
            if(passedTime<0.25*realDuration){
              paint.setAlpha((int) ((255*passedTime)/(0.30*realDuration)));
            }else if(passedTime>0.70*realDuration){
                float  temp = (float) (passedTime-0.70*realDuration);
                float ratio = (float) (temp/(0.30*realDuration));
                paint.setAlpha((int) (-255*ratio+255));
            }
            paint.setTextSize(fontSizes.get(i));
            canvas.drawText(text, startX, startY, paint);
            startCordinates[i][0] += stepsX.get(i);
            startCordinates[i][1] += stepsY.get(i);
            passedTimes.set(i,passedTimes.get(i)+sleepTime);
        }

    }

    public void setData(ArrayList<String> texts, ArrayList<Integer> durations,ArrayList<Integer> startTimes, int[][] startCordinates, int[][] endCordinates, ArrayList<String> colors,ArrayList<Integer>fontSizes) {

        size = texts.size();
        this.texts = texts;
        this.fontSizes = fontSizes;
        this.realDurations = durations;
        this.startTimes = startTimes;
        this.passedTimes = new ArrayList<>();
        this.startCordinates = new float[texts.size()][2];
        this.endCordinates = new float[texts.size()][2];

        this.colors = colors;
        alphas = new int[texts.size()];
        stepsX = new ArrayList<>();
        stepsY = new ArrayList<>();
        for (int i = 0; i < texts.size(); i++) {
            passedTimes.add(0);
            this.startCordinates[i][0] = startCordinates[i][0] * getWidth() / 100;
            this.startCordinates[i][1] = startCordinates[i][1] * getHeight() / 100;
            this.endCordinates[i][0] = endCordinates[i][0] * getWidth() / 100;
            this.endCordinates[i][1] = endCordinates[i][1] * getHeight() / 100;

            float distanceX = this.endCordinates[i][0]-this.startCordinates[i][0];
            float distanceY = this.endCordinates[i][1]-this.startCordinates[i][1];
            stepsX.add(sleepTime*distanceX/durations.get(i));
            stepsY.add(sleepTime*distanceY/durations.get(i));

        }
        startAnimation();

    }

    public void setFont(Typeface font){
        this.font = font;
    }

    private void startAnimation() {

        width = getWidth();
        height = getHeight();

        paint = new Paint();
        paint.setColor(Color.parseColor("#661111"));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(textSize);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(font);
        paint.setAlpha(0);
        paint.setShadowLayer(25, 10, 10, Color.parseColor("#551111"));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(sleepTime);
                        currentTime +=sleepTime;
                        postInvalidate();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private float dpToPx(float dp){
        float px = dp * getResources().getDisplayMetrics().density;
        return px;
    }
}
