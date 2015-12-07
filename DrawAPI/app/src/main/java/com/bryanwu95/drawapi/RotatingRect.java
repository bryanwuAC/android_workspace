package com.bryanwu95.drawapi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Bryan on 2015/6/15.
 */
public class RotatingRect extends View{
    private Paint paint;
    private float degrees=0;
    public RotatingRect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initProperties();
    }
    public RotatingRect(Context context) {
        super(context);
        initProperties();
    }

    public RotatingRect(Context context, AttributeSet attrs) {
        super(context, attrs);
        initProperties();
    }

    private void initProperties(){
        paint=new Paint();
        paint.setColor(Color.GREEN);
    }



    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.save();
        //canvas.rotate(degrees);
        canvas.rotate(degrees,150,150);
        canvas.drawRect(100,100,200,200,paint);
        degrees++;
        canvas.restore();
        invalidate();
    }

}

