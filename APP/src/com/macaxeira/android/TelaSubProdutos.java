package com.macaxeira.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.macaxeira.model.Ingrediente;
import com.macaxeira.model.ItemPedido;
import com.macaxeira.model.Produto;
import com.macaxeira.util.CategoriaAdapter;

public class TelaSubProdutos extends Activity {
	private Produto p;
	private ItemPedido i ;
	
	private ExpandableListView ingredientes;
	//private ExpandableListView adicionais;
	private BaseExpandableListAdapter adapter;
	
	private TextView nome;
	private TextView preco;
	
	private String[] txtProduto;
	private String[] listaIngredientes;
	private String[] listaAdcionais;
	private String[][] txtIngredientes;

	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_subprodutos);
		p = (Produto) getIntent().getExtras().getSerializable("produto");
		
		i = new ItemPedido();
		i.setProduto(p);
	
		nome = (TextView) findViewById(R.id.produto);
		preco = (TextView) findViewById(R.id.preco);
		ingredientes = (ExpandableListView) findViewById(R.id.expandableListView1);
		
		//setando texto da ExpandableListView
		txtProduto = new String[] {"Ingredientes", "Adcionais"};
		
		//depois pegar isso aqui do banco...
		listaIngredientes = new String[]{"cebola", "milho", "etc"};
		listaAdcionais = new String[]{"mais cebola", "mais milho", "etc"};
		txtIngredientes = new String[][]{listaIngredientes, listaAdcionais};
		
		adapter = new CategoriaAdapter(this, txtProduto, txtIngredientes);
		ingredientes.setAdapter(adapter);
		
		
		nome.setText(i.getProduto().getNome());
		preco.setText("R$: "+i.getProduto().getPreco());

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_subprodutos, menu);
		return true;
	}
}
