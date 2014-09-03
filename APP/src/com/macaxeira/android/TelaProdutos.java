package com.macaxeira.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.macaxeira.DAO.ProdutoDAO;
import com.macaxeira.DAO.ProdutoDAOImpl;
import com.macaxeira.model.Categoria;
import com.macaxeira.model.Produto;

public class TelaProdutos extends Activity {
	
	ListView lista;
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

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_produtos, menu);
		return true;
	}

}
