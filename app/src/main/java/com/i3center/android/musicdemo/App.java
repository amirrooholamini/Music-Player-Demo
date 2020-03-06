package com.i3center.android.musicdemo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v4.content.res.ResourcesCompat;

public class App extends Application {

    public static Context context;
    public static Activity currentActivity;
    public static Handler handler;
    public static Typeface persianFont;
    public static Typeface shekastehFont;
    public static Typeface nastaliq;
    public static Typeface mohsenTitleFont;
    public static Typeface mohsenTimeFont;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        persianFont = ResourcesCompat.getFont(context, R.font.persian);
        shekastehFont = ResourcesCompat.getFont(context, R.font.shekasteh);
        nastaliq = ResourcesCompat.getFont(context, R.font.nastaliq);
        mohsenTitleFont = ResourcesCompat.getFont(context, R.font.mohsenfont);
        mohsenTimeFont = ResourcesCompat.getFont(context, R.font.mohsentimefont);
    }
}
