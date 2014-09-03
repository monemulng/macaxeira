package com.macaxeira.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void escolheCategoria(View v) {		
		
		if (v.getId() == R.id.sanduba) {
			mudarParaTelaProd(1);
		}
		
		if (v.getId() == R.id.batata) {
			mudarParaTelaProd(2);
		}
		

	}
	private void mudarParaTelaProd(int idCatDoProd){
		Intent intent = new Intent(MainActivity.this, TelaProdutos.class);
		intent.putExtra("id", idCatDoProd);
		startActivity(intent);
	}
}
