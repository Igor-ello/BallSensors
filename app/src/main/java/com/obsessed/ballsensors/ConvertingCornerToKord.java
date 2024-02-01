package com.obsessed.ballsensors;

public class ConvertingCornerToKord {
    private static double multiplier = Ball.getMultiplierSpeed();
    private static int cornerX, cornerY;

    public static int getSpeedX() {
        if(Math.abs(cornerX) > 90) {
            if(cornerX > 0)
                return (int) ((180-cornerX) * multiplier);
            else return (int) (-1*(180+cornerX) * multiplier);
        }
        else return (int) (cornerX * multiplier);
    }

    public static int getSpeedY() {
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
