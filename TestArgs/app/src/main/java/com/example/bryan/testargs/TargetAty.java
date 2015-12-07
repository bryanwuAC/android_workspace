package com.example.bryan.testargs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class TargetAty extends Activity {
    private TextView tvGetArg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_aty);
        tvGetArg=(TextView)findViewById(R.id.tvGetArg);
        Intent i=getIntent();
        tvGetArg.setText(i.getStringExtra("data"));


    }
}
