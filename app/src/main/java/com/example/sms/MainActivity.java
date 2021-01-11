package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num,msg;
    Button send;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate (savedInstanceState) ;
        setContentView (R. layout.activity_main);
        num =(EditText) findViewById (R. id. number);
        msg=(EditText) findViewById (R. id. message);
        send=findViewById (R.id.send);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber=num.getText().toString();
                String message=msg.getText().toString();
                if(message!=null && phoneNumber!=null) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS Sens Successfully", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please fill the blanks", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}