package com.example.bryan.sms_test;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class SMS_broadcastreceiver extends BroadcastReceiver {
    private String sms;

    private static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";

    @TargetApi(Build.VERSION_CODES.DONUT)
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION)) {
            StringBuffer SMSAddress = new StringBuffer();
            StringBuffer SMSContent = new StringBuffer();
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdusObjects = (Object[]) bundle.get("pdus");
                SmsMessage[] messages = new SmsMessage[pdusObjects.length];
                for (int i = 0; i < pdusObjects.length; i++) {
                    messages[i] = SmsMessage
                            .createFromPdu((byte[]) pdusObjects[i]);
                }
                for (SmsMessage message : messages) {
                    SMSAddress.append(message.getDisplayOriginatingAddress());
                    SMSContent.append(message.getDisplayMessageBody());
                    sms=SMSAddress.toString()+"\n"+SMSContent.toString();
                    System.out.println(sms);
                }
            }
        }
    }
}
