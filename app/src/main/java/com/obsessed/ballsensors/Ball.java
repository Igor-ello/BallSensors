package com.obsessed.ballsensors;

public class Ball {
    private int kord_x;
    private int kord_y;
    private int radius = 100;
    private int speed;
    private int speedX = 0;
    private int speedY = 0;
    private static double multiplierSpeed = 2.5;
    private int abroad = 0;
    private OnBallPositionChangeListener listenerPosChange;
    private OnBallAbroadListener listenerAbroad;


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

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getAbroad() {
        return abroad;
    }

    public void setAbroad(int abroad) {
        this.abroad = abroad;
    }

    public static double getMultiplierSpeed() {
        return multiplierSpeed;
    }

    public static void setMultiplierSpeed(double multiplierSpeed) {
        Ball.multiplierSpeed = multiplierSpeed;
    }

    //interface PositionChange
    public void setOnBallPositionChangeListener(OnBallPositionChangeListener listener) {
        this.listenerPosChange = listener;
    }

    public void removeOnBallPositionChangeListener() {
        this.listenerPosChange = null;
    }

    public void updateSpeed() {
        speed = (int) Math.round(Math.sqrt(speedX*speedX + speedY*speedY));
        if (listenerPosChange != null) {
            listenerPosChange.onPositionChanged(speed, speedX, speedY);
        }
    }

    //interface Abroad
    public void setOnBallAbroadListener(OnBallAbroadListener listener) {
        this.listenerAbroad = listener;
    }

    public void removeOnBallAbroadListener(){
        this.listenerAbroad = null;
    }

    public void updateAbroad() {
        if (listenerAbroad != null) {
            listenerAbroad.onAbroad(abroad);
        }
    }
}
