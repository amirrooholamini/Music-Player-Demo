package activities;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.audiofx.Equalizer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.i3center.android.musicdemo.App;
import com.i3center.android.musicdemo.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import custom.FarzinTextAnimation;
import custom.MohsenPlayIcon;
import custom.MohsenProgress;
import custom.MohsenTitle;
import helper.Help;

public class ActivityMohsen extends ActivityParent {

    private MediaPlayer player;
    private boolean increaseTime;
    int r = 0;
    int g = 0;
    int b = 0;


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
        setContentView(R.layout.activity_mohsen);

        player = MediaPlayer.create(App.context, R.raw.behet_ghol_midam);

        final TextView txtDuration = (TextView)findViewById(R.id.txtDuration);
        final TextView txtNow = (TextView)findViewById(R.id.txtNow);
        txtNow.setTypeface(App.mohsenTitleFont);
        txtDuration.setTypeface(App.mohsenTitleFont);
        final MohsenProgress progressBar = (MohsenProgress)findViewById(R.id.progressBar);
        final FloatingActionButton btnPlay = (FloatingActionButton) findViewById(R.id.btnPlay);
        final FarzinTextAnimation txtText = (FarzinTextAnimation) findViewById(R.id.txtText);
        final ArrayList<Integer> rgb = new ArrayList<>();

        rgb.add(255);
        rgb.add(3);
        rgb.add(66);
        increaseTime = false;

        r = rgb.get(0);
        g = rgb.get(1);
        b = rgb.get(2);

        final MohsenTitle txtTitle = (MohsenTitle) findViewById(R.id.txtTitle);
        final MohsenTitle txtMusicName = (MohsenTitle) findViewById(R.id.txtMusicName);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    while (true) {
                        App.handler.post(new Runnable() {
                            @Override
                            public void run() {
                                btnPlay.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(r, g, b)));

                            }
                        });

                        Thread.sleep(40);
                        float progress = 100*(float)player.getCurrentPosition()/(float)player.getDuration();
                        progressBar.setProgress(progress);
                        if (increaseTime) {
                            r++;
                            b--;
                            if (r > 255 || b < 66) {
                                r -= 2;
                                b += 2;
                                increaseTime = false;
                            }
                        } else {
                            r--;
                            b++;
                            if (r < 140 || b > 180) {
                                r += 2;
                                b -= 2;
                                increaseTime = true;
                            }
                        }
                        rgb.set(0, r);
                        rgb.set(2, b);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        txtDuration.setText(Help.convertToTimeFormat(player.getDuration()));
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);



        txtTitle.setText("MOHSEN YEGANEH");
        txtTitle.setTextSize(55);
        txtTitle.setARGB(255, 180, 20, 100);
        //txtTitle.startMove();
        //txtTitle.setSleepTime(3000000);

        txtMusicName.setText("I PROMISE YOU");
        txtMusicName.setTextSize(45);
        txtMusicName.setARGB(200, 140, 20, 100);
        txtMusicName.setSleepTime(3000);
        txtMusicName.startMove();


        texts = new ArrayList<>();
        durations = new ArrayList<>();
        colors = new ArrayList<>();
        startTimes = new ArrayList<>();
        fontSizes = new ArrayList<>();

        texts.add("I promise you");
        texts.add("that this is not difficult");
        texts.add("at least for you");
        texts.add("Do not worry");
        texts.add("I am far away from you");
        texts.add("and your world");
        texts.add("Do not worry");
        texts.add("No one will replace you");
        texts.add("I am just anxious");

        texts.add("for the tomorrow that awaits you");
        texts.add("for the tomorrow that awaits you");
        texts.add("for the tomorrow that awaits you");
        texts.add("for the tomorrow that awaits you");

        texts.add("I promise you");
        texts.add("that this is not difficult");
        texts.add("at least for you");
        texts.add("Do not worry");
        texts.add("I am far away from you");
        texts.add("and your world");
        texts.add("Do not worry");
        texts.add("No one will replace you");
        texts.add("I am just anxious");
        texts.add("for the tomorrow that awaits you");
        texts.add("♪ ♪ ♪ ♪ ♪ ♪");


        startCoordinates = new int[texts.size()][2];
        endCoordinates = new int[texts.size()][2];

        for (int i = 0; i < 9 ; i++) {
            startCoordinates[i][0] = 50;
            startCoordinates[i][1] = 50;
            endCoordinates[i][0] = 50;
            endCoordinates[i][1] = 50;
        }
        for (int i = 13; i < texts.size() ; i++) {
            startCoordinates[i][0] = 50;
            startCoordinates[i][1] = 50;
            endCoordinates[i][0] = 50;
            endCoordinates[i][1] = 50;
        }


        startCoordinates[9][0] = 70;
        startCoordinates[9][1] = 40;
        endCoordinates[9][0] = 70;
        endCoordinates[9][1] = 40;

        startCoordinates[10][0] = 30;
        startCoordinates[10][1] = 60;
        endCoordinates[10][0] = 30;
        endCoordinates[10][1] = 60;

        startCoordinates[11][0] = 50;
        startCoordinates[11][1] = 60;
        endCoordinates[11][0] = 50;
        endCoordinates[11][1] = 60;

        startCoordinates[12][0] = 50;
        startCoordinates[12][1] = 50;
        endCoordinates[12][0] = 50;
        endCoordinates[12][1] = 50;

        colors.add("#000000");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#aaaaaa");
        colors.add("#aaaaaa");
        colors.add("#aaaaaa");
        colors.add("#000000");

        colors.add("#000000");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#000000");
        colors.add("#441133");

        durations.add(1800);
        durations.add(1800);
        durations.add(2000);
        durations.add(1700);
        durations.add(1500);
        durations.add(1000);
        durations.add(1900);
        durations.add(3000);
        durations.add(3500);
        durations.add(500);
        durations.add(500);
        durations.add(500);
        durations.add(1000);

        durations.add(1800);
        durations.add(1800);
        durations.add(2000);
        durations.add(1700);
        durations.add(1500);
        durations.add(1000);
        durations.add(1900);
        durations.add(3000);
        durations.add(3000);
        durations.add(3000);
        durations.add(10000);

        int startTime = 700;
        startTimes.add(startTime);
        startTime += 2000;
        startTimes.add(startTime);
        startTime += 2000;
        startTimes.add(startTime);
        startTime += 2000;
        startTimes.add(startTime);
        startTime += 1800;
        startTimes.add(startTime);
        startTime += 1400;
        startTimes.add(startTime);
        startTime += 1000;
        startTimes.add(startTime);
        startTime += 2000;
        startTimes.add(startTime);
        startTime += 3000;
        startTimes.add(startTime);
        startTime += 3400;
        startTimes.add(startTime);
        startTime += 200;
        startTimes.add(startTime);
        startTime += 200;
        startTimes.add(startTime);
        startTime += 200;
        startTimes.add(startTime);


        startTime += 1000;
        startTimes.add(startTime);
        startTime += 1800;
        startTimes.add(startTime);
        startTime += 1800;
        startTimes.add(startTime);
        startTime += 2000;
        startTimes.add(startTime);
        startTime += 1800;
        startTimes.add(startTime);
        startTime += 1500;
        startTimes.add(startTime);
        startTime += 1200;
        startTimes.add(startTime);
        startTime += 2100;
        startTimes.add(startTime);
        startTime += 3000;
        startTimes.add(startTime);
        startTime += 3000;
        startTimes.add(startTime);
        startTime += 3000;
        startTimes.add(startTime);

        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(30);
        fontSizes.add(30);
        fontSizes.add(30);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(60);
        fontSizes.add(90);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                player = MediaPlayer.create(App.context, R.raw.behet_ghol_midam);
                player.seekTo(44000);
                player.start();
                txtText.setFont(App.mohsenTitleFont);
                txtText.setData(texts,
                        durations,
                        startTimes,
                        startCoordinates,
                        endCoordinates,
                        colors,
                        fontSizes);

                while (true){
                    try {
                        Thread.sleep(500);
                        App.handler.post(new Runnable() {
                            @Override
                            public void run() {
                                txtNow.setText(Help.convertToTimeFormat(player.getCurrentPosition()));
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        player.stop();
    }
}
