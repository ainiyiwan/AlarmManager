package com.zy.xxl.alarmmanager.schedule;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by SilenceDut on 2016/10/20 .
 */

public class AlarmService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO: 2017/11/15 do some work
        mJobHandler.sendMessage( Message.obtain( mJobHandler, 1, null ) );
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private Handler mJobHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage( Message msg ) {
            Toast.makeText( getApplicationContext(), "JobService task running", Toast.LENGTH_SHORT ).show();
            return true;
        }
    } );
}
