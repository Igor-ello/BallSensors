package com.obsessed.ballsensors;

import android.graphics.Canvas;

public class ConvertingCornerToKord {
    private static double multiplier = Ball.getMultiplierSpeed();
    private static int cornerX, cornerY;
    private OnBallPositionChangeListener listener;

    public static int getKordX() {
        return (int) (cornerX * multiplier);
    }

    public static int getKordY() {
        return -1 * (int) (cornerY * multiplier);
    }


    public int getCornerX() {
        return cornerX;
    }
    public void setCornerX(int cornerX) {
        this.cornerX = cornerX;
    }

    public int getCornerY() {
        return cornerY;
    }
    public void setCornerY(int cornerY) {
        this.cornerY = cornerY;
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
            listener.onPositionChanged(getKordX(), getKordY());
        }
    }
}
