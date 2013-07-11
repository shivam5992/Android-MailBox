package com.techblogon.loginexample;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profile extends Activity{

 
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
               
        Bundle b = getIntent().getExtras();
        String id = b.getString("id");
        
        TextView tv = (TextView)findViewById(R.id.textView1);
        tv.setText(id);
		
		Button compose = (Button) findViewById(R.id.compose);
		compose.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.techblogon.loginexample.HomeActivity.compose")); //listV
			}
		});
		
		Button inbox = (Button) findViewById(R.id.inbox);
		inbox.setOnClickListener(new View.OnClickListener() {
			
		
			public void onClick(View v) {
				Intent intent = getPackageManager().getLaunchIntentForPackage("com.android.email");
				startActivity(intent);
			}
		});
		
		Button so = (Button) findViewById(R.id.exit);
		so.setOnClickListener(new View.OnClickListener() {
			
		
			public void onClick(View v) {
				
				finish();          
				moveTaskToBack(true);
			}
		});
		
		Button so1 = (Button) findViewById(R.id.signout);
		so1.setOnClickListener(new View.OnClickListener() {
			
		
			public void onClick(View v) {
				
				startActivity(new Intent("com.techblogon.loginexample.HomeActivity.logout"));
		      
			}
		});
      
}
}