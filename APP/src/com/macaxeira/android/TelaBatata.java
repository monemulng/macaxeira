package com.macaxeira.android;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TelaBatata extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_batata);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_batata, menu);
		return true;
	}

}
