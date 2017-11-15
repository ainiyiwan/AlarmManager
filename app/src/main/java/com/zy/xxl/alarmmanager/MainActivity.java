package com.zy.xxl.alarmmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zy.xxl.alarmmanager.schedule.PollingUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.start)
    Button start;
    @BindView(R.id.stop)
    Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.start, R.id.stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start:
                PollingUtils.startService(MainActivity.this, true);
                break;
            case R.id.stop:
                PollingUtils.stopPolling(MainActivity.this);
                break;
            default:
                break;
        }
    }
}
