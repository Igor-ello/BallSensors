package com.obsessed.ballsensors;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

public class MyView extends View {
    boolean abroad = false;
    int kord_x, kord_y;

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if(!abroad){
            abroad = true;
            kord_x = canvas.getWidth()/2;
            kord_y = canvas.getHeight()/2;
        }

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);

        ConvertingCornerToKord cornerToKord = new ConvertingCornerToKord();
        kord_x += cornerToKord.getKordX(canvas);
        kord_y += cornerToKord.getKordY(canvas);
        Log.d("MyLog", kord_x + " " + kord_y);
        Log.d("MyLog", cornerToKord.getCornerX() + " " + cornerToKord.getCornerY());

        canvas.drawCircle(kord_x, kord_y, 100, paint);

        if(kord_x <= 0 || kord_y <= 0 || kord_x >= canvas.getWidth() || kord_y >= canvas.getHeight()){
            kord_x = canvas.getWidth()/2;
            kord_y = canvas.getHeight()/2;
        }

        invalidate(); //обновление экрана

    }
}
