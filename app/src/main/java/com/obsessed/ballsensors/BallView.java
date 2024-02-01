package com.obsessed.ballsensors;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

public class BallView extends View {
    public Ball ball;
    public ConvertingCornerToKord cornerToKord;
    private boolean firstAbroad = false;


    public BallView(Context context) {
        super(context);
        ball = new Ball();
        cornerToKord = new ConvertingCornerToKord();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if(!firstAbroad){
            firstAbroad = true;
            ball.setKord_x(canvas.getWidth()/2);
            ball.setKord_y(canvas.getHeight()/2);
            ball.updateSpeed();
            ball.updateAbroad();
        }

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);

        //Logic
        ball.setSpeedX(cornerToKord.getSpeedX());
        ball.setSpeedY(cornerToKord.getSpeedY());
        ball.setKord_x(ball.getKord_x() + ball.getSpeedX());
        ball.setKord_y(ball.getKord_y() + ball.getSpeedY());
        ball.updateSpeed();

        Log.d("MyLog", ball.getKord_x() + " " + ball.getKord_y());
        Log.d("MyLog", cornerToKord.getCornerX() + " " + cornerToKord.getCornerY());

        canvas.drawCircle(ball.getKord_x(), ball.getKord_y(), ball.getRadius(), paint);

        if(ball.getKord_x() <= 0 || ball.getKord_y() <= 0 || ball.getKord_x() >= canvas.getWidth() || ball.getKord_y() >= canvas.getHeight()){
            ball.setKord_x(canvas.getWidth()/2);
            ball.setKord_y(canvas.getHeight()/2);
            ball.setAbroad(ball.getAbroad()+1);
            ball.updateAbroad();
        }

        invalidate(); //обновление экрана

    }
}
