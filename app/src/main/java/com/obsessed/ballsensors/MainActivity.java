package com.obsessed.ballsensors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnBallPositionChangeListener {
    Sensors sensors;
    TextView tv_speed, tv_speedX, tv_speedY, tv_defeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout container = findViewById(R.id.ball);
        BallView ballView = new BallView(this);
        container.addView(ballView);

        sensors = new Sensors(this);

        tv_speed = findViewById(R.id.speed);
        tv_speedX = findViewById(R.id.speedX);
        tv_speedY = findViewById(R.id.speedY);
        tv_defeat = findViewById(R.id.defeat);

        ballView.ball.setOnBallPositionChangeListener(this);
    }

    @Override
    public void onPositionChanged(int speed, int speedX, int speedY) {
        speedX = Math.abs(speedX);
        speedY = Math.abs(speedY);
        tv_speed.setText(String.valueOf(speed));
        tv_speedX.setText(" " + speedX);
        tv_speedY.setText(" " + speedY);
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