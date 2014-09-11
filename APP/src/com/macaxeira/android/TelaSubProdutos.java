package com.macaxeira.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.macaxeira.model.ItemPedido;
import com.macaxeira.model.Produto;

public class TelaSubProdutos extends Activity {
	private Produto p;
	private ItemPedido i = new ItemPedido();
	private ExpandableListView ingredientes;
	private ExpandableListView adicionais;
	private TextView nome;
	private TextView preco;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_subprodutos);
		p = (Produto) getIntent().getExtras().getSerializable("produto");
		
		i.setProduto(p) ;
	
		nome = (TextView) findViewById(R.id.produto);
		preco = (TextView) findViewById(R.id.preco);
		ingredientes = (ExpandableListView) findViewById(R.id.expandableListView1);
		adicionais = (ExpandableListView) findViewById(R.id.expandableListView2);
		
		nome.setText(i.getProduto().getNome());
		preco.setText(""+i.getProduto().getPreco());
		
		
		
		
		
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_subprodutos, menu);
		return true;
	}
}
