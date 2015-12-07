package com.example.bryan.sinedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Bryan on 2015/7/30.
 */


public class SineWave extends View implements Runnable{

    private Paint mPaint = null;
    private  static float amplifier = 100.0f;
    private  static float frequency = 2.0f;
    private  static float phase = 0f;
    private  int height = 0;
    private  int width = 0;
    private  static float px=-1,py=-1;
    private  boolean sp=false;



    public SineWave(Context context){
        super(context);
        mPaint = new Paint();
        new Thread(this).start();
    }


    public SineWave(Context context, AttributeSet attrs){
        super(context,attrs);
        mPaint = new Paint();
        new Thread(this).start();
    }

    public SineWave(Context context,float amplifier,float frequency,float phase){
        super(context);
        this.frequency=frequency;
        this.amplifier=amplifier;
        this.phase=phase;
        mPaint=new Paint();
        new Thread(this).start();
    }

    public float GetAmplifier(){
        return amplifier;
    }

    public float GetFrequency(){
        return frequency;
    }

    public float GetPhase(){
        return phase;
    }

    public void Set(float amplifier,float frequency,float phase){
        this.frequency=frequency;
        this.amplifier=amplifier;
        this.phase=phase;
    }

    public void SetXY(float px,float py) {
        this.px=px;
        this.py=py;
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        height=this.getHeight();
        width=this.getWidth();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GREEN);
        amplifier = (amplifier*2>height)?(height/2):amplifier;
        mPaint.setAlpha(200);
        mPaint.setStrokeWidth(5);
        float cy = height/2;
        for(int i=0;i<width-1;i++) {
            canvas.drawLine((float)i, cy-amplifier*(float)(Math.sin(phase*2*(float)Math.PI/360.0f+2*Math.PI*frequency*i/width)), (float)(i+1), cy-amplifier*(float)(Math.sin(phase*2*(float)Math.PI/360.0f+2*Math.PI*frequency*(i+1)/width)), mPaint);
            float point = cy-amplifier*(float)(Math.sin(phase*2*(float)Math.PI/360.0f+2*Math.PI*frequency*i/width));
            if((py>=(point-2.5f))&&(py<=(point+2.5f))&&(px>=i-2.5f)&&(px<=i+2.5f))
                sp = true;
        }

        if(sp) {
            mPaint.setColor(Color.RED);
            mPaint.setTextSize(20);
            canvas.drawText("(x="+Float.toString(px)+",y="+Float.toString(py)+")", 20, 20, mPaint);
            sp = false;
        }
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(20);
        canvas.drawText("(x="+Float.toString(px)+",y="+Float.toString(py)+")", 20, this.getHeight()-20, mPaint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        float px=event.getX();
        float py=event.getY();
        this.SetXY(px, py);
        return super.onTouchEvent(event);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(!Thread.currentThread().isInterrupted()) {
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            postInvalidate();
        }
    }



}