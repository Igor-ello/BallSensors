package com.obsessed.ballsensors;

import android.graphics.Canvas;

public class ConvertingCornerToKord {
    private static double multiplier = Ball.getMultiplierSpeed();
    private static int cornerX, cornerY;

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
}
