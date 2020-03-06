package activities;

import android.content.Intent;
import android.os.Bundle;

import com.i3center.android.musicdemo.R;

public class MainActivity extends ActivityParent {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, ActivityMohsen.class);
        startActivity(intent);
        finish();
    }
}
