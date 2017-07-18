package com.example.tuionf.onepointkeeplive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(new BootCompleteReceiver(),filter);

    }

    public class BootCompleteReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                HooliganActivity. startHooligan(MainActivity.this);
                Log.e(TAG, "onReceive: ACTION_SCREEN_OFF" );
            } else if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
                Log.e(TAG, "onReceive: ACTION_SCREEN_ON" );
                HooliganActivity. killHooligan();
            }
        }
    }

}
