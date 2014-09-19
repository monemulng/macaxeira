package com.macaxeira.android;


import java.util.ArrayList;
import java.util.List;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.macaxeira.model.Adicional;
import com.macaxeira.model.Ingrediente;
import com.macaxeira.model.ItemPedido;
import com.macaxeira.model.Produto;
import com.macaxeira.util.AdapterChild;
import com.macaxeira.util.AdapterParent;
import com.macaxeira.util.ExpandableAdapter;

public class TelaSubProdutos extends ExpandableListActivity {
	private Produto p;
	private ItemPedido i ;
	private BaseExpandableListAdapter adapter;
	
	private TextView nome;
	private TextView preco;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_subprodutos);
		p = (Produto) getIntent().getExtras().getSerializable("produto");
		
		i = new ItemPedido();
		i.setProduto(p);
	
		nome = (TextView) findViewById(R.id.produto);
		preco = (TextView) findViewById(R.id.preco);
		
		nome.setText(i.getProduto().getNome());
		preco.setText("R$: "+i.getProduto().getPreco());
		
		ArrayList<AdapterChild> childsIngredientes = converterIEmAdapter(i.getProduto().getIngredientes());
		ArrayList<AdapterChild> childsAdicionais = converterAEmAdapter(i.getProduto().getAdicionais());
		
		AdapterParent ingredientes = new AdapterParent("Ingredientes", childsIngredientes);
		AdapterParent adicionais  = new AdapterParent("Adicionais", childsAdicionais);;
		
		ArrayList<AdapterParent> listas = new ArrayList<AdapterParent>();
		listas.add(ingredientes);
		listas.add(adicionais);
		
		loadHosts(listas);
		
	}

	private ArrayList<AdapterChild> converterAEmAdapter(List<Adicional> adicionais) {
		ArrayList<AdapterChild> children = new ArrayList<AdapterChild>();
		for(Adicional a:adicionais){
			children.add(new AdapterChild(a));
		}
		return children;
	}

	private ArrayList<AdapterChild> converterIEmAdapter(List<Ingrediente> ingredientes) {
		ArrayList<AdapterChild> children = new ArrayList<AdapterChild>();
		for(Ingrediente i:ingredientes){
			children.add(new AdapterChild(i));
		}
		return children;
	
	}

	private String[] pegarNomesIngredientes(List<Ingrediente> itens) {
		String[] nomes = new String[itens.size()];
		for(int i = 0; i< itens.size();i++ ){
			nomes[i] = itens.get(i).toString();
		}
		return nomes;
	}
	private String[] pegarNomesAdicionais(List<Adicional> itens) {
		String[] nomes = new String[itens.size()];
		for(int i = 0; i< itens.size();i++ ){
			nomes[i] = itens.get(i).toString();
		}
		return nomes;
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_subprodutos, menu);
		return true;
	}
	
	private void loadHosts(final ArrayList<AdapterParent> newParents){
		if (newParents == null)
			return;
		
		//parents = newParents;
		
		// Check for ExpandableListAdapter object
		if (this.getExpandableListAdapter() == null)
		{
			 //Create ExpandableListAdapter Object
			final ExpandableAdapter mAdapter = new ExpandableAdapter(newParents);
			
			// Set Adapter to ExpandableList Adapter
			this.setListAdapter(mAdapter);
		}
		else
		{
			 // Refresh ExpandableListView data 
			((ExpandableAdapter)getExpandableListAdapter()).notifyDataSetChanged();
		}	
	}
	
}
