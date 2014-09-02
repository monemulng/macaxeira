package com.macaxeira.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.macaxeira.DAO.ProdutoDAO;
import com.macaxeira.DAO.ProdutoDAOImpl;
import com.macaxeira.model.Categoria;

public class TelaProdutos extends Activity {
	private ProdutoDAO prodDao = new ProdutoDAOImpl();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_batata);
		
		int idCategoria = getIntent().getExtras().getInt("id");
		
		Categoria cat = new Categoria(idCategoria,"Batata");
		cat.setProdutos(prodDao.buscarProdutoPorCategoria(cat));
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_batata, menu);
		return true;
	}

}
