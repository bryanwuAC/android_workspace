package com.bryanwu95.learncontext;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Bryan on 2015/6/8.
 */
public class Main2 extends Activity{
    private TextView tv;
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        tv= (TextView)findViewById(R.id.textView);
        et=(EditText)findViewById(R.id.editText);
        tv.setText("The sharing data is:" + getapp().getTextData());
        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((App) getApplicationContext()).setTextData(et.getText().toString());
                tv.setText("The sharing data is:" + et.getText().toString());

            }
        });
    }
    public App getapp(){
        return (App)getApplicationContext();
    }
}
