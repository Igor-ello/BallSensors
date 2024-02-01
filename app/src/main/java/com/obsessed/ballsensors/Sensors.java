package com.obsessed.ballsensors;

import static android.content.Context.SENSOR_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

public class Sensors implements SensorEventListener {
    Sensor mAccelerometer, mMagnetic;
    SensorManager mSensorManager;

    public Sensors(Context context) {
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mMagnetic = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    float[] accel = new float[3];
    float[] magnet = new float[3];
    float[] rotationMatrix = new float[16];
    float[] orientation = new float[3];

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            accel = sensorEvent.values.clone();
        }
        if(sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            magnet = sensorEvent.values.clone();
        }

        SensorManager.getRotationMatrix(rotationMatrix, null, accel, magnet);
        SensorManager.getOrientation(rotationMatrix, orientation);

        ConvertingCornerToKord cornerToKord = new ConvertingCornerToKord();

        cornerToKord.setCornerX(Integer.parseInt(String.valueOf(Math.round(Math.toDegrees(orientation[2])))));
        cornerToKord.setCornerY(Integer.parseInt(String.valueOf(Math.round(Math.toDegrees(orientation[1])))));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void registerSensors(){
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mMagnetic, SensorManager.SENSOR_DELAY_UI);
    }

    public void unregisterSensors(){
        mSensorManager.unregisterListener(this);
    }
}
