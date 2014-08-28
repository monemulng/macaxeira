package com.macaxeira.android;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	  public void escolheCategoria(View v){			
	    	if(v.getId() == R.id.batat)
	    		alterarTelaBatata(v);
	    	
	    	if(v.getId() == R.id.sanduba)
	    		alterarTelaSanduba(v);
	    	
	    }
	    
		private void alterarTelaSanduba(View v) {
			Intent intent = new Intent(MainActivity.this, TelaSanduiches.class);
			intent.putExtra("id", 1);
			startActivity(intent);
		}

		private void alterarTelaBatata(View v){
			Intent intent = new Intent(MainActivity.this, TelaBatata.class);
			intent.putExtra("id", 2);
			startActivity(intent);
		}


}
