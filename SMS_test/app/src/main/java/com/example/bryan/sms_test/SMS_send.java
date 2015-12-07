package com.example.bryan.sms_test;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class SMS_send extends ActionBarActivity {
    private Button btnSend;
    private EditText etTel;
    private EditText etContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_send);

        btnSend = (Button) findViewById(R.id.btnSend);
        etTel = (EditText) findViewById(R.id.etTel);
        etContent = (EditText) findViewById(R.id.etContent);

        btnSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String telNumStr = etTel.getText().toString();
                String messageStr = etContent.getText().toString();
                if (null != telNumStr && null != messageStr) {
                    SmsManager smsMgr = SmsManager.getDefault();
                    Intent i = new Intent("com.example.bryan.sms_test.SMS_send");
                    PendingIntent dummyEvent = PendingIntent.getBroadcast(
                            SMS_send.this, 0, i, 0);
                    Toast.makeText(SMS_send.this,"信息已发送",Toast.LENGTH_SHORT);
                    try {
                        smsMgr.sendTextMessage(telNumStr, null, messageStr,
                                dummyEvent, dummyEvent);
                        ContentValues values = new ContentValues();
                        values.put("address", telNumStr);
                        values.put("body", messageStr);
                        getContentResolver().insert(
                                Uri.parse("content://sms/sent"), values);

                    } catch (Exception e) {
                        Log.e("SmsSending", "SendException", e);
                    }
                } else {
                    showDialog(getTaskId());
                }
            }
        });
    }

}
