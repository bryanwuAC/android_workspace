package org.crazyit.sound;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Timer extends Activity {
    private EditText etGetTimer;
    private Button btnTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        btnTimer=(Button)findViewById(R.id.btnTimer);
        etGetTimer=(EditText)findViewById(R.id.etTimer);
        btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Timer.this,CaptureImage.class);
                i.putExtra("data",etGetTimer.getText().toString());
                startActivity(i);
            }
        });


    }
}
