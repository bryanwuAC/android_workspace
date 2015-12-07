package com.example.bryan.testargs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
    private Button btnSubmit;
    private EditText etNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit=(Button)findViewById(R.id.btnSubmit);
        etNum=(EditText)findViewById(R.id.etNum);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, TargetAty.class);
                i.putExtra("data",etNum.getText().toString());
                startActivity(i);
            }
        });

    }

}
