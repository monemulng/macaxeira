package com.macaxeira.android;


import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.macaxeira.model.Adicional;
import com.macaxeira.model.Ingrediente;
import com.macaxeira.model.ItemPedido;
import com.macaxeira.model.Produto;
import com.macaxeira.util.AdapterChild;
import com.macaxeira.util.AdapterParent;
import com.macaxeira.util.ExpandableAdapter;

public class TelaSubProdutos extends Activity {
	private Produto p;
	private ItemPedido i ;
	private ExpandableListView expListView;
	
	private TextView nome;
	private TextView preco;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_subprodutos);
		p = (Produto) getIntent().getExtras().getSerializable("produto");
		
		i = new ItemPedido();
		i.setProduto(p);
	
		expListView = (ExpandableListView) findViewById(R.id.lista);
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

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_subprodutos, menu);
		return true;
	}
	
	private void loadHosts(final ArrayList<AdapterParent> newParents){
		if (newParents == null)
			return;
		if (expListView.getExpandableListAdapter() == null)
		{
			final ExpandableAdapter mAdapter = new ExpandableAdapter(newParents, this);
			expListView.setAdapter(mAdapter);
		}
		else
		{
			 // Refresh ExpandableListView data 
			((ExpandableAdapter)expListView.getExpandableListAdapter()).notifyDataSetChanged();
		}	
	}

	public void mudarPreco() {
		//Pegar o preço de todos os adicionais que estiver com isChecked true e botar no preco;
		adisdasidasisdajiasdij;
		
	}

}
