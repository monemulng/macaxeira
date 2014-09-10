package com.macaxeira.http;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.macaxeira.android.R;
import com.macaxeira.model.Categoria;

public class HttpActivityTeste extends Activity implements HttpClientListener{

	private Gson gson = new Gson();
	private EditText categoriaId;
	private EditText categoriaNome;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_http_teste);
		
		categoriaId   = (EditText)findViewById(R.id.categoria_id);
		categoriaNome = (EditText)findViewById(R.id.categoria_nome);
	}


	
	public void buscar(View v){
		GetHttpClientTask task = new GetHttpClientTask();
		
		task.addHttpClientListener(this);
		
		task.execute("http://192.168.25.8:8080/macaxeira/categoria/read?id="+categoriaId.getText().toString());
		
		//veja que a thread principal continua
		for(int i =0;i<10000;i++);
		
		
	}

	@Override
	public void updateHttpClientListener(String result) {
		Log.i("Json : ", result);
		
		Categoria c = gson.fromJson(result, Categoria.class);
		
		categoriaNome.setText(c.getNome());
		
	}

}
