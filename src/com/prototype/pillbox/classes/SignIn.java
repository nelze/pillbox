package com.prototype.pillbox.classes;



import com.example.pillbox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SignIn extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_in);
	}
	public void signin(View v) {
		Intent intent = new Intent(SignIn.this, Journal.class);
    	startActivity(intent);    
    	SignIn.this.finish();
	}
}
