package com.techblogon.loginexample;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
 
public class Email extends Activity {
    Button send,back;
    EditText address, subject, emailbody;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        address = (EditText) findViewById(R.id.address);
        subject = (EditText) findViewById(R.id.subject);
        emailbody = (EditText) findViewById(R.id.body);
        send = (Button) findViewById(R.id.send);
 
        send.setOnClickListener(new OnClickListener() {
          
            public void onClick(View v) {
                sendEmail();
            }
        });
        
        back = (Button) findViewById(R.id.back);
        
        back.setOnClickListener(new OnClickListener() {
          
            public void onClick(View v) {
            	finish(); 
            }
        });
    }
 
    public void sendEmail(){
 
        if(!address.getText().toString().trim().equalsIgnoreCase("")){
          final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
          emailIntent.setType("plain/text");
          emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ address.getText().toString()});
          emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject.getText());
          emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, emailbody.getText());
          Email.this.startActivity(Intent.createChooser(emailIntent, "MailBox"));
        }
        else{
            Toast.makeText(getApplicationContext(), "Please enter an email address..", Toast.LENGTH_LONG).show();
        }
      }
    }