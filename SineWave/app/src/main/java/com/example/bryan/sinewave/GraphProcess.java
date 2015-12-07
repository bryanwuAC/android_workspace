package com.example.bryan.sinewave;

import android.content.Intent;
import android.graphics.Path;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class GraphProcess extends AppCompatActivity {
    private TextView tvData;
    private String data;
    private String[] points=new String[21];
    private double[] x=new double[21];
    private double[] y=new double[21];
    SineWave graph;

    private TextView tvfrequency;
    private TextView tvamplitude;
    private TextView tvphase;

    private double xMax=0.0;
    private double xMin=0.0;
    private double yMax=0.0;
    private double yMin=0.0;

    private double amplitude;
    private double frequency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_process);
        tvfrequency= (TextView) findViewById(R.id.tvFrequency);
        tvamplitude= (TextView) findViewById(R.id.tvAmplitude);
        tvphase= (TextView) findViewById(R.id.tvPhase);
        graph=new SineWave(this);
        getData();
        if(data.length()==0) {
            Toast.makeText(GraphProcess.this, "获取数据失败，请再试一次", Toast.LENGTH_SHORT).show();
            this.finish();
        }else{
            Toast.makeText(GraphProcess.this, "获取数据成功", Toast.LENGTH_SHORT).show();
            dealData();
            draw();
        }
    }

    private void getData(){
        Intent i=getIntent();
        data=i.getStringExtra("20points").toString();
    }

    private void dealData(){
        data=data.substring(1);
        for(int i=0; i<=20; i++){
            int endIndex=data.indexOf(":");
            points[i]=data.substring(0,endIndex+1);
            x[i]=Double.parseDouble(points[i].substring(9,10))+(Double.parseDouble(points[i].substring(10,24))/1000000/100000000);
            y[i]=Double.parseDouble(points[i].substring(25,26))+(Double.parseDouble(points[i].substring(26,40))/1000000/100000000);
            if(points[i].substring(24,25).equals("1"))
                y[i]=-y[i];

            if(y[i]>yMax){
                yMax=y[i];
                xMax=x[i];
            }

            if(y[i]<yMin){
                yMin=y[i];
                xMin=x[i];
            }
            data=data.substring(endIndex + 1);
        }
    }

    private void draw(){
        amplitude=(yMax-yMin)/2;
        frequency=1/(2*(xMin-xMax));
        System.out.println(amplitude + ":" + frequency);
        tvfrequency.setText(frequency + "");
        tvamplitude.setText(amplitude+"");
        graph.Set((float)(325.94932*amplitude), (float) ( 2*Math.PI*frequency),0.0f);
    }


}
