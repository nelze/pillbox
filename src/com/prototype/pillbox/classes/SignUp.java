package com.prototype.pillbox.classes;



import com.example.pillbox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SignUp extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);
	}
	public void register(View v) {
    	Intent intent = new Intent(SignUp.this, WelcomeScreen.class);
    	startActivity(intent);
    	SignUp.this.finish();
}
}
