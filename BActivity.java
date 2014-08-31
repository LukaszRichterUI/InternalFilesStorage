package com.example.internalfilestorage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BActivity extends ActionBarActivity {

	Button load, previous;
	TextView username, password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		username = (TextView) findViewById(R.id.textView3);
		password = (TextView) findViewById(R.id.textView4);
		load = (Button) findViewById(R.id.button1);
		previous = (Button) findViewById(R.id.button2);
		load.setOnClickListener(listener);
		previous.setOnClickListener(listener);
	}

	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if(v.getId()==R.id.button1) {				
				try {
					FileInputStream in = openFileInput("test.txt"); // open file
					int read = -1;	
					StringBuffer buf = new StringBuffer();
					// read from file
					while((read=in.read())!=-1) {
						buf.append((char)read);
					}
					
					String user = buf.substring(0, buf.indexOf(" "));
					String pass = buf.substring(buf.indexOf(" ")+1);
					
					username.setText(user);
					password.setText(pass);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if(v.getId()==R.id.button2) {
				Intent intent = new Intent(BActivity.this, MainActivity.class);
				startActivity(intent);
			}
		}		
	};
}
