package cn.etzmico;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import cn.etzmico.sendsms_saved.R;

public class SMSSending extends Activity {
	private EditText telNum;
	private EditText messageText;
	private Button sendBtn;

	/**
	 * override the method onCreate() 1.bind the data telNum and
	 * 
	 * messageText. 2.set the sendBtn's listener.
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		telNum = (EditText) findViewById(R.id.telNumText_send);
		messageText = (EditText) findViewById(R.id.message_copntent_send);
		sendBtn = (Button) findViewById(R.id.send_button_send);

		sendBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 获取输入信息
				String telNumStr = telNum.getText().toString();
				String messageStr = messageText.getText().toString();
				// 判断输入信息不为空
				if (null != telNumStr && null != messageStr) {
					// 短信发送
					SmsManager smsMgr = SmsManager.getDefault();
					Intent i = new Intent("cn.etzmico.smssending");
					PendingIntent dummyEvent = PendingIntent.getBroadcast(
							SMSSending.this, 0, i, 0);
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