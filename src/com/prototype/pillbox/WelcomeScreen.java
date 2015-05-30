package com.prototype.pillbox;

import com.example.pillbox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WelcomeScreen extends Activity {
	Button signIn;
	Button joinUs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_screen);
		Bundle bundle = getIntent().getExtras();
    	
    	joinUs = (Button)findViewById(R.id.button1); 
    	//signIn = (ImageButton)findViewById(R.id.button1); 
	}
	
	public void joinus(View v) {
		    	Intent intent = new Intent(WelcomeScreen.this, SignUp.class);
		    	startActivity(intent);
	}
	public void signin(View v) {
		Intent intent = new Intent(WelcomeScreen.this, SignIn.class);
    	startActivity(intent);    
	}
}
