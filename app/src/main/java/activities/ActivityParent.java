package activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.i3center.android.musicdemo.App;

public class ActivityParent extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        App.currentActivity = this;
    }
}
