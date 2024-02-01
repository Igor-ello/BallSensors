package com.obsessed.ballsensors;

public class Ball {
    private int kord_x;
    private int kord_y;
    private int radius = 100;
    private int speed = 0;
    private static double multiplierSpeed = 10;
    private OnBallPositionChangeListener listener;

    public Ball(int kord_x, int kord_y, int multiplierSpeed) {
        this.kord_x = kord_x;
        this.kord_y = kord_y;
        this.multiplierSpeed = multiplierSpeed;
    }

    public int getKord_x() {
        return kord_x;
    }

    public void setKord_x(int kord_x) {
        this.kord_x = kord_x;
    }

    public int getKord_y() {
        return kord_y;
    }

    public void setKord_y(int kord_y) {
        this.kord_y = kord_y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public static double getMultiplierSpeed() {
        return multiplierSpeed;
    }

    public static void setMultiplierSpeed(double multiplierSpeed) {
        Ball.multiplierSpeed = multiplierSpeed;
    }

    //interface
    public void setOnBallPositionChangeListener(OnBallPositionChangeListener listener) {
        this.listener = listener;
    }

    public void removeOnBallPositionChangeListener() {
        this.listener = null;
    }

    public void updatePosition() {
        if (listener != null) {
            listener.onPositionChanged(kord_x, kord_y);
        }
    }
}
