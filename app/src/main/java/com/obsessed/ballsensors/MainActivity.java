package com.obsessed.ballsensors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Sensors sensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));

        sensors = new Sensors(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensors.registerSensors();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensors.unregisterSensors();
    }
}