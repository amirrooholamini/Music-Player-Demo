package activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.i3center.android.musicdemo.App;
import com.i3center.android.musicdemo.R;

import java.util.ArrayList;


public class ActivityChavoshi extends ActivityParent {

    ArrayList<String> texts;
    ArrayList<Integer> times;
    int i = 0;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chavoshi);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        texts = new ArrayList<>();
        times = new ArrayList<>();

        texts.add("از کرمت من به ناز");
        texts.add("می نگرم در بقا");
        texts.add("کی بفریبد شه آ");
        texts.add("دولت فانی مرا");
        texts.add("بیست هزار آرزو");
        texts.add("بود مرا پیش از این");
        texts.add("در هوس خود نماند");
        texts.add("هیچ امانی مرا");
        texts.add("ای که به هنگام درد راحت جانی مرا");
        texts.add("وی که به تلخی فقر گنج روانی مرا");
        texts.add("سجده کنم من به جان");
        texts.add("روی نهم من به خاک");
        texts.add("گویم از این ها همه");
        texts.add("عشق فلانی مرا");

        texts.add("♡♥♡");
        texts.add("♥");
        texts.add("♥♡♥♡♥");
        texts.add("♥♡♥");
        texts.add("♡♥♡♥♡");
        texts.add("♥♡♥");
        texts.add("♥");
        texts.add("♡");
        texts.add("♥♡♥♡♥");
        texts.add("♡♥♡♥♡");


        times.add(3600);
        times.add(2000);
        times.add(2000);
        times.add(2000);
        times.add(2000);
        times.add(2000);
        times.add(2000);
        times.add(1500);
        times.add(3500);
        times.add(4000);
        times.add(2000);
        times.add(2000);
        times.add(2000);
        times.add(2000);

        times.add(500);
        times.add(500);
        times.add(500);
        times.add(500);
        times.add(500);
        times.add(500);
        times.add(500);
        times.add(500);
        times.add(500);
        times.add(500);

        TextView txtMusicName = (TextView) findViewById(R.id.txtMusicName);
        TextView txtName = (TextView) findViewById(R.id.txtName);
        final TextView txtText = (TextView) findViewById(R.id.txtText);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        player = MediaPlayer.create(App.context, R.raw.bist);
        player.start();
        player.seekTo(126000);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(50);
                        seekBar.setProgress(100*player.getCurrentPosition()/player.getDuration());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (i < times.size()) {
                        int sleepTime = times.get(i);
                        final String text = texts.get(i);
                        App.handler.post(new Runnable() {
                            @Override
                            public void run() {
                                txtText.setText(text);
                            }
                        });
                        Thread.sleep(sleepTime);
                        i++;

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        txtMusicName.setTypeface(App.persianFont);
        txtName.setTypeface(App.persianFont);
        txtText.setTypeface(App.persianFont);
    }
}
