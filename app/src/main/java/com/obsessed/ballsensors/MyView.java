package com.obsessed.ballsensors;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

public class MyView extends View {
    Ball ball;
    boolean abroad = false;

    public MyView(Context context) {
        super(context);
        ball = new Ball(0, 0, 1);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if(!abroad){
            abroad = true;
            ball.setKord_x(canvas.getWidth()/2);
            ball.setKord_y(canvas.getHeight()/2);
        }

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);

        //Logic
        ConvertingCornerToKord cornerToKord = new ConvertingCornerToKord();
        ball.setKord_x(ball.getKord_x() + cornerToKord.getKordX());
        ball.setKord_y(ball.getKord_y() + cornerToKord.getKordY());

        Log.d("MyLog", ball.getKord_x() + " " + ball.getKord_y());
        Log.d("MyLog", cornerToKord.getCornerX() + " " + cornerToKord.getCornerY());

        canvas.drawCircle(ball.getKord_x(), ball.getKord_y(), ball.getRadius(), paint);

        if(ball.getKord_x() <= 0 || ball.getKord_y() <= 0 || ball.getKord_x() >= canvas.getWidth() || ball.getKord_y() >= canvas.getHeight()){
            ball.setKord_x(canvas.getWidth()/2);
            ball.setKord_y(canvas.getHeight()/2);
        }

        invalidate(); //обновление экрана

    }
}
