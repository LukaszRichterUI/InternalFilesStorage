package com.example.internalfilestorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	Button save, gotob;
	EditText username, password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		username = (EditText) findViewById(R.id.editText1);
		password = (EditText) findViewById(R.id.editText2);
		save = (Button) findViewById(R.id.button1);
		gotob = (Button) findViewById(R.id.button2);
		save.setOnClickListener(listener);
		gotob.setOnClickListener(listener);
	}

	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if(v.getId()==R.id.button1) {				
				String user = username.getText().toString();
				String pass = password.getText().toString();
				user += " ";
				FileOutputStream out = null;
				File file = null;
				
				try {
					file = getFilesDir();
					out = openFileOutput("test.txt", Context.MODE_PRIVATE); // open/create file
					out.write(user.getBytes()); // write to file
					out.write(pass.getBytes());
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();					
				} finally {
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				Toast.makeText(MainActivity.this, "saved to " + file, Toast.LENGTH_LONG).show();
				
			} else if(v.getId()==R.id.button2) {
				Intent intent = new Intent(MainActivity.this, BActivity.class);
				startActivity(intent);
			}			
		}		
	};
}
