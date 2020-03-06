package custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ChavoshiLight extends LinearLayout {

    ArrayList<Float> circlesX;
    ArrayList<Float> circlesY;
    ArrayList<Integer> alpha;
    ArrayList<String> colors;
    boolean addNew = true;
    int time;
    public ChavoshiLight(Context context) {
        super(context);
        setWillNotDraw(false);
        circlesX = new ArrayList<>();
        circlesY = new ArrayList<>();
        alpha = new ArrayList<>();
        colors = new ArrayList<>();
        startThread();
    }

    public ChavoshiLight(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        circlesX = new ArrayList<>();
        circlesY = new ArrayList<>();
        alpha = new ArrayList<>();
        colors = new ArrayList<>();
        startThread();
    }

    public ChavoshiLight(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
        circlesX = new ArrayList<>();
        circlesY = new ArrayList<>();
        alpha = new ArrayList<>();
        colors = new ArrayList<>();
        startThread();
    }

    public ChavoshiLight(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setWillNotDraw(false);
        circlesX = new ArrayList<>();
        circlesY = new ArrayList<>();
        alpha = new ArrayList<>();
        colors = new ArrayList<>();
        startThread();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);


        float width = getWidth();
        float height = getHeight();

        for(int i=0;i<circlesX.size();i++){
            alpha.set(i,(int)(alpha.get(i)-10));
            if(alpha.get(i)<0){
                alpha.set(i,0);
            }
            paint.setColor(Color.parseColor(colors.get(i)));
            paint.setAlpha(alpha.get(i));
            canvas.drawCircle(circlesX.get(i), circlesY.get(i), 6, paint);
        }

        if(addNew) {
            float random = (float) Math.random();
            if(random<0.5){
                paint.setColor(Color.parseColor("#EEC652"));
                colors.add("#EEC652");
            }else{
                paint.setColor(Color.parseColor("#C8C8C8"));
                colors.add("#C8C8C8");
            }
            float x = (float) (Math.random() * width);
            float y = (float) (Math.random() * height);
            circlesX.add(x);
            circlesY.add(y);
            alpha.add(255);


            canvas.drawCircle(x, y, 6, paint);
            addNew = false;
        }
    }

    private void  startThread(){
        addNew = true;
        time = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                  try {
                      Thread.sleep(10);
                      time+=20;
                      if(time <34000) {
                          if (time % 1000 == 0) {
                              addNew = true;
                          }
                      }else{
                          if (time % 40 == 0) {
                              addNew = true;
                          }
                      }
                      postInvalidate();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
            }
        }).start();

    }
}
