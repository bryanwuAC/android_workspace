package com.example.bryan.sinedemo;

import android.app.Activity;

import android.os.Bundle;

import android.view.MotionEvent;

import android.view.View;

import android.widget.Button;

import android.widget.TextView;

import java.io.BufferedReader;
import java.net.Socket;


public class MainActivity extends Activity{

    private TextView frequency=null;
    private TextView phase=null;
    private TextView amplifier=null;
    private Button   btnwave=null;
    SineWave sw=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sw = new SineWave(this);
        setContentView(R.layout.activity_main);
        btnwave = (Button)findViewById(R.id.wave);
        frequency = (TextView)findViewById(R.id.frequency);
        phase = (TextView)findViewById(R.id.phase);
        amplifier = (TextView)findViewById(R.id.amplifier);


        btnwave.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                sw.Set(Float.parseFloat(amplifier.getText().toString()), Float.parseFloat(frequency.getText().toString()), Float.parseFloat(phase.getText().toString()));

            }

        });

    }



    @Override

    protected void onStart() {

        // TODO Auto-generated method stub

        super.onStart();

        frequency.setText(Float.toString(sw.GetFrequency()));

        phase.setText(Float.toString(sw.GetPhase()));

        amplifier.setText(Float.toString(sw.GetAmplifier()));

    }



    @Override

    public boolean onTouchEvent(MotionEvent event) {

        // TODO Auto-generated method stub

        //float px = event.getX();

        //float py = event.getY();

        //sw.SetXY(px, py);

        return super.onTouchEvent(event);

    }

}
