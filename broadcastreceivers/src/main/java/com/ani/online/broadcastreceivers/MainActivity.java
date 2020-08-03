package com.ani.online.broadcastreceivers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver br = new MyReceiver();
    private Intent intent;

    MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, MyService.class);
        startService(intent);

        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                MyService.MyBinder binder = (MyService.MyBinder) service;
                myService = binder.getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                myService = null;
            }
        }, BIND_AUTO_CREATE);

        Button btnSend = findViewById(R.id.btSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(myService != null ) {
                    if(myService.getMp() != null) {
                        myService.getMp().isPlaying();
                    }
                }
                //sstopService(intent);

                Intent data = new Intent("com.ani.my.intent");
                data.putExtra("button", "play");

                LocalBroadcastManager
                        .getInstance(MainActivity.this)
                        .sendBroadcast(data);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

//        registerBR();

        ImageView img = findViewById(R.id.imageView);
        if(isAirplaneModeOn()) {
            img.setImageResource(R.drawable.ic_baseline_airplanemode_active_24);
        }else {
            img.setImageResource(R.drawable.ic_baseline_airplanemode_inactive_24);
        }
    }

    private boolean isAirplaneModeOn() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return Settings.System.getInt(getContentResolver(),
                    Settings.System.AIRPLANE_MODE_ON, 0) != 0;
        } else {
            return Settings.Global.getInt(getContentResolver(),
                    Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
        }
    }

    private void registerBR() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(br, filter);
    }
}