package com.zy.xxl.alarmmanager.schedule;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

/**
 * Created by SilenceDut on 2016/10/23 .
 */

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class JobSchedulerService extends JobService {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        // TODO: 2017/11/15 do some work
        mJobHandler.sendMessage( Message.obtain( mJobHandler, 1, params ) );
        return true;
    }


    @Override
    public boolean onStopJob(JobParameters params) {
        mJobHandler.removeMessages( 1 );
        return false;
    }

    private Handler mJobHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage( Message msg ) {
            Toast.makeText( getApplicationContext(), "JobService task running", Toast.LENGTH_SHORT ).show();
            jobFinished( (JobParameters) msg.obj, false );
            return true;
        }
    } );

}
