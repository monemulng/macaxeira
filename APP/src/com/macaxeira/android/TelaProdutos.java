package com.macaxeira.android;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.macaxeira.DAO.ProdutoDAO;
import com.macaxeira.DAO.ProdutoDAOImpl;
import com.macaxeira.model.Categoria;
import com.macaxeira.model.Produto;
import com.macaxeira.util.MyApp;

public class TelaProdutos extends Activity {
	
	ListView lista;
	//private int cod;
	private ProdutoDAO prodDao = new ProdutoDAOImpl();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_produtos);
		
		int idCategoria = getIntent().getExtras().getInt("id");
		
		String nomeCat;
		if(idCategoria==1) nomeCat="Sanduiche";
		else nomeCat="Batata";
		
		Categoria cat = new Categoria(idCategoria,nomeCat);
		cat.setProdutos(prodDao.buscarProdutoPorCategoria(cat));
		
		ArrayAdapter <Produto> filelist = null;
		lista = (ListView) findViewById(R.id.listaprodutos);
		
		filelist = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, cat.getProdutos());

		lista.setAdapter(filelist);
		
		lista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> filelist, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				Produto p = (Produto) filelist.getItemAtPosition(position);
				
				Toast.makeText(MyApp.getAppContext(), "você clicou em: " + p, Toast.LENGTH_LONG).show();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_produtos, menu);
		return true;
	}
}
