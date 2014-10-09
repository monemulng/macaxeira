package com.macaxeira.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.macaxeira.android.R;
import com.macaxeira.http.GetHttpClientTask;
import com.macaxeira.http.HttpClientListener;
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
		
		
		
		task.execute("http://10.2.236.191:8080/macaxeira/categoria/read?id="+categoriaId.getText().toString());
		
	}

	@Override
	public void updateHttpClientListener(String result) {
		
		
		Categoria c = gson.fromJson(result, Categoria.class);
		
		categoriaNome.setText(c.getNome());
		
		/*
		JsonElement jelement = new JsonParser().parse(result);
	    JsonObject  jobject = jelement.getAsJsonObject();
	    jobject = jobject.getAsJsonObject("data");
	    JsonArray jarray = jobject.getAsJsonArray("translations");
	    jobject = jarray.get(0).getAsJsonObject();
	    String produtos = jobject.get("translatedText").toString();
	    */
		
	}

}
