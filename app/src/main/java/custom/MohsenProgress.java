package custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import com.i3center.android.musicdemo.App;

import java.util.ArrayList;

public class MohsenProgress extends LinearLayout {
    Paint paint;
    float progress = 0;

    float width;
    float height;

    public MohsenProgress(Context context) {
        super(context);
        setWillNotDraw(false);

    }

    public MohsenProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

    }

    public MohsenProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);

    }

    public MohsenProgress(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setWillNotDraw(false);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        width = getWidth();
        height = getHeight();

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.parseColor("#761616"));
        paint.setAntiAlias(true);
        paint.setStrokeWidth(3);

        float stopX = width*(progress/100);

        Log.i("LOG",stopX + " | "+width);
        canvas.drawLine(0,height/2,stopX,height/2, paint);
        paint.setColor(Color.parseColor("#b62626"));
        canvas.drawLine(stopX,height/2,width,height/2, paint);
        paint.setStrokeWidth(0);
        paint.setColor(Color.parseColor("#551122"));
        canvas.drawCircle(stopX-2,height/2,height/2,paint);
    }

    public void setProgress(float progress) {
        this.progress = progress;
        postInvalidate();

    }




}
