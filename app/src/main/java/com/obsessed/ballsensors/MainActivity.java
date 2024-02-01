package com.obsessed.ballsensors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnBallPositionChangeListener {
    Sensors sensors;
    TextView speed, speedX, speedY, defeat;
    ConvertingCornerToKord cornerToKord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cornerToKord = new ConvertingCornerToKord();

        FrameLayout container = findViewById(R.id.ball);
        BallView ballView = new BallView(this, cornerToKord);
        container.addView(ballView);

        sensors = new Sensors(this);

        speed = findViewById(R.id.speed);
        speedX = findViewById(R.id.speedX);
        speedY = findViewById(R.id.speedY);
        defeat = findViewById(R.id.defeat);

        cornerToKord.setOnBallPositionChangeListener(this);
    }

    @Override
    public void onPositionChanged(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        speed.setText(String.valueOf(Math.round(Math.sqrt(x*x+y*y))));
        speedX.setText(" " + x);
        speedY.setText(" " + y);
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