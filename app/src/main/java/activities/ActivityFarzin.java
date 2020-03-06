package activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.i3center.android.musicdemo.App;
import com.i3center.android.musicdemo.R;

import java.util.ArrayList;

import custom.FarzinProgress;
import custom.FarzinTextAnimation;

public class ActivityFarzin extends ActivityParent {


    MediaPlayer player;
    FarzinProgress progressBar;
    FarzinTextAnimation textAnimation;

    TextView txtTitle;
    TextView txtTime;
    TextView txtDuration;

    int[][] startCoordinates;
    int[][] endCoordinates;
    ArrayList<String> texts;
    ArrayList<Integer> durations;
    ArrayList<String> colors;
    ArrayList<Integer> startTimes;
    ArrayList<Integer> fontSizes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farzin);
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        progressBar = (FarzinProgress) findViewById(R.id.progressBar);
        textAnimation = (FarzinTextAnimation) findViewById(R.id.textAnimation);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTime = (TextView) findViewById(R.id.txtTime);
        txtDuration = (TextView) findViewById(R.id.txtDuration);

        txtTitle.setText("فرزاد فرزین - اقیانوس");
        txtTitle.setTypeface(App.nastaliq);
        txtTime.setTypeface(App.persianFont);
        txtDuration.setTypeface(App.persianFont);

        texts = new ArrayList<>();
        durations = new ArrayList<>();
        colors = new ArrayList<>();
        startTimes = new ArrayList<>();
        fontSizes = new ArrayList<>();

        texts.add("این که تورو از دست بدم");
        texts.add("کابوس من   بود");
        texts.add("آغوش آروم تو");
        texts.add("اقیانوس");
        texts.add("من   بود");
        texts.add("تو تا همیشه");
        texts.add("توی قلبم");
        texts.add("موندگاری");
        texts.add("واسه پشیمونی  همیشه وقت داری");
        texts.add("این که تورو از دست بدم");
        texts.add("کابوس");
        texts.add("من   بود");
        texts.add("آغوش آروم تو");
        texts.add("اقیانوس");
        texts.add("تموم لحظه  های بی  تو نا  تمومه");
        texts.add("تصویر خنده هات همیشه رو به رومه");

        startCoordinates = new int[texts.size()][2];
        endCoordinates = new int[texts.size()][2];

        startCoordinates[0][0] = 65;
        startCoordinates[0][1] = 65;
        endCoordinates[0][0] = 60;
        endCoordinates[0][1] = 55;

        startCoordinates[1][0] = 30;
        startCoordinates[1][1] = 30;
        endCoordinates[1][0] = 35;
        endCoordinates[1][1] = 35;

        startCoordinates[2][0] = 60;
        startCoordinates[2][1] = 70;
        endCoordinates[2][0] = 55;
        endCoordinates[2][1] = 65;

        startCoordinates[3][0] = 60;
        startCoordinates[3][1] = 20;
        endCoordinates[3][0] = 60;
        endCoordinates[3][1] = 30;

        startCoordinates[4][0] = 35;
        startCoordinates[4][1] = 20;
        endCoordinates[4][0] = 30;
        endCoordinates[4][1] = 30;

        startCoordinates[5][0] = 50;
        startCoordinates[5][1] = 70;
        endCoordinates[5][0] = 50;
        endCoordinates[5][1] = 65;

        startCoordinates[6][0] = 60;
        startCoordinates[6][1] = 40;
        endCoordinates[6][0] = 65;
        endCoordinates[6][1] = 40;

        startCoordinates[7][0] = 30;
        startCoordinates[7][1] = 40;
        endCoordinates[7][0] = 25;
        endCoordinates[7][1] = 40;

        startCoordinates[8][0] = 50;
        startCoordinates[8][1] = 50;
        endCoordinates[8][0] = 50;
        endCoordinates[8][1] = 45;

        startCoordinates[9][0] = 65;
        startCoordinates[9][1] = 30;
        endCoordinates[9][0] = 70;
        endCoordinates[9][1] = 30;

        startCoordinates[10][0] = 75;
        startCoordinates[10][1] = 70;
        endCoordinates[10][0] = 70;
        endCoordinates[10][1] = 65;

        startCoordinates[11][0] = 50;
        startCoordinates[11][1] = 50;
        endCoordinates[11][0] = 50;
        endCoordinates[11][1] = 45;

        startCoordinates[12][0] = 35;
        startCoordinates[12][1] = 30;
        endCoordinates[12][0] = 30;
        endCoordinates[12][1] = 30;

        startCoordinates[13][0] = 20;
        startCoordinates[13][1] = 62;
        endCoordinates[13][0] = 25;
        endCoordinates[13][1] = 65;

        startCoordinates[14][0] = 50;
        startCoordinates[14][1] = 30;
        endCoordinates[14][0] = 50;
        endCoordinates[14][1] = 40;

        startCoordinates[15][0] = 50;
        startCoordinates[15][1] = 70;
        endCoordinates[15][0] = 50;
        endCoordinates[15][1] = 60;



        colors.add("#000000");
        colors.add("#a62626");
        colors.add("#000000");
        colors.add("#a62626");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#a62626");
        colors.add("#000000");
        colors.add("#a62626");
        colors.add("#000000");
        colors.add("#a62626");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#a62626");
        colors.add("#a62626");
        colors.add("#a62626");

        durations.add(4000);
        durations.add(4000);
        durations.add(3000);
        durations.add(3000);
        durations.add(5000);
        durations.add(3500);
        durations.add(3500);
        durations.add(3000);
        durations.add(6500);
        durations.add(3500);
        durations.add(8000);
        durations.add(8500);
        durations.add(2500);
        durations.add(4000);
        durations.add(14200);
        durations.add(11000);


        int startTime = 2500;
        startTimes.add(startTime);
        startTime += 1800;
        startTimes.add(startTime);
        startTime += 3500;
        startTimes.add(startTime);
        startTime += 2000;
        startTimes.add(startTime);
        startTime += 1000;
        startTimes.add(startTime);
        startTime += 3500;
        startTimes.add(startTime);
        startTime += 1000;
        startTimes.add(startTime);
        startTime += 1500;
        startTimes.add(startTime);
        startTime += 3000;
        startTimes.add(startTime);
        startTime += 6000;
        startTimes.add(startTime);
        startTime += 2000;
        startTimes.add(startTime);
        startTime += 1000;
        startTimes.add(startTime);
        startTime += 3500;
        startTimes.add(startTime);
        startTime += 1500;
        startTimes.add(startTime);
        startTime += 3000;
        startTimes.add(startTime);
        startTime += 3000;
        startTimes.add(startTime);

        fontSizes.add(120);
        fontSizes.add(140);
        fontSizes.add(120);
        fontSizes.add(140);
        fontSizes.add(130);
        fontSizes.add(120);
        fontSizes.add(140);
        fontSizes.add(120);
        fontSizes.add(130);
        fontSizes.add(100);
        fontSizes.add(120);
        fontSizes.add(100);
        fontSizes.add(100);
        fontSizes.add(120);
        fontSizes.add(130);
        fontSizes.add(130);

        //----------------------------------------------
        //----------------------------------------------
        //----------------------------------------------
        //----------------------------------------------
        App.handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textAnimation.setData(texts,
                        durations,
                        startTimes,
                        startCoordinates,
                        endCoordinates,
                        colors,
                        fontSizes);
                player = MediaPlayer.create(App.context, R.raw.oghyanoos);
                player.start();
                player.seekTo(168000);
                startThread();
            }
        }, 1000);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        player.stop();
    }

    private void startThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        final float now = player.getCurrentPosition();
                        final float duration = player.getDuration();
                        float progress = 100 * now / duration;
                        progressBar.setProgress(progress);
                        App.handler.post(new Runnable() {
                            @Override
                            public void run() {
                                int min = (int) Math.min(now-500,player.getDuration());
                                txtTime.setText(convertToTimeFormat(min));
                                txtDuration.setText(convertToTimeFormat((int) duration) + "");
                            }
                        });
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private String convertToTimeFormat(int time) {
        time /= 1000;
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
}
