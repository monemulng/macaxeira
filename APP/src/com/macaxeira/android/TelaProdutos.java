package com.macaxeira.android;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.macaxeira.DAO.CategoriaDAO;
import com.macaxeira.DAO.CategoriaDAOImpl;
import com.macaxeira.model.Atendimento;
import com.macaxeira.model.Categoria;
import com.macaxeira.model.Produto;

public class TelaProdutos extends Activity implements OnItemClickListener{
	
	private ListView lista;
	private Atendimento a;
	private CategoriaDAO catDao= new CategoriaDAOImpl();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_produtos);
		a = (Atendimento) getIntent().getExtras().getSerializable("atendimento");
		int idCategoria = Integer.parseInt(getIntent().getExtras().getString("id"));
		Categoria cat = catDao.buscarCategoriaPorId(idCategoria);


		ArrayAdapter <Produto> filelist = null;
		lista = (ListView) findViewById(R.id.listaprodutos);
		filelist = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, cat.getProdutos());
		lista.setAdapter(filelist);
		
		lista.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_produtos, menu);
		return true;
	}

	
	@Override
	public void onItemClick(AdapterView<?> filelist, View v, int position, long id){

		Produto p = (Produto) filelist.getItemAtPosition(position);		
		//Toast.makeText(MyApp.getAppContext(), "você clicou em: " + p, Toast.LENGTH_LONG).show();
		
		Intent intent = new Intent(TelaProdutos.this, TelaSubProdutos.class);
		intent.putExtra("atendimento", a);
		intent.putExtra("produto", p);
		startActivity(intent);
		
	}
}
