package com.macaxeira.android;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.macaxeira.model.Adicional;
import com.macaxeira.model.Atendimento;
import com.macaxeira.model.Ingrediente;
import com.macaxeira.model.ItemPedido;
import com.macaxeira.model.Produto;
import com.macaxeira.util.AdapterChild;
import com.macaxeira.util.AdapterParent;
import com.macaxeira.util.ExpandableAdapter;

public class TelaSubProdutos extends Activity {
	
	
	private Atendimento a;
	private Produto p;
	private ItemPedido i;
	
	private ExpandableListView expListView;
	private TextView nome;
	private TextView preco;
	
	private ArrayList<AdapterParent> listas = new ArrayList<AdapterParent>();
	private ArrayList<ItemPedido> itens = new ArrayList<ItemPedido>();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_subprodutos);
		
		p = (Produto) getIntent().getExtras().getSerializable("produto");
		a = (Atendimento) getIntent().getExtras().getSerializable("atendimento");
		
		i = new ItemPedido();
		i.setProduto(p);

		expListView = (ExpandableListView) findViewById(R.id.lista);
		nome = (TextView) findViewById(R.id.produto);
		preco = (TextView) findViewById(R.id.preco);

		nome.setText(i.getProduto().getNome());
		preco.setText("R$: " + i.getProduto().getPreco());

		ArrayList<AdapterChild> childsIngredientes = converterIEmAdapter(i
				.getProduto().getIngredientes());
		ArrayList<AdapterChild> childsAdicionais = converterAEmAdapter(i
				.getProduto().getAdicionals());

		AdapterParent ingredientes = new AdapterParent("Ingredientes",
				childsIngredientes);
		AdapterParent adicionais = new AdapterParent("Adicionais",
				childsAdicionais);

		listas = new ArrayList<AdapterParent>();
		listas.add(ingredientes);
		listas.add(adicionais);

		carregarParentsNoAdapterDaLista(listas);
		
		
		
	}

	private ArrayList<AdapterChild> converterAEmAdapter(
			List<Adicional> adicionais) {
		ArrayList<AdapterChild> children = new ArrayList<AdapterChild>();
		for (Adicional a : adicionais) {
			children.add(new AdapterChild(a));
		}
		return children;
	}

	private ArrayList<AdapterChild> converterIEmAdapter(
			List<Ingrediente> ingredientes) {
		ArrayList<AdapterChild> children = new ArrayList<AdapterChild>();
		for (Ingrediente i : ingredientes) {
			children.add(new AdapterChild(i));
		}
		return children;

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_subprodutos, menu);
		return true;
	}

	private void carregarParentsNoAdapterDaLista(
			ArrayList<AdapterParent> newParents) {
		if (newParents == null) {
			return;
		}
		ExpandableAdapter mAdapter = new ExpandableAdapter(newParents, this);
		expListView.setAdapter(mAdapter);

	}

	public void mudarPreco() {
		double precoTotal = 0;
		for (AdapterChild a : listas.get(1).getChildren()) {
			if (a.isChecked()) {
				precoTotal += a.getAdicional().getPreco();
			}
		}

		preco.setText("R$: " + (i.getProduto().getPreco() + precoTotal));

	}

	public void adicionarNaLista(View v) {
		ItemPedido i = new ItemPedido();
		i.setProduto(p);
		i.setAdicionals(pegarAdicionaisMarcados());
		i.setIngredientes(pegarIngredientesNaoMarcados());

		itens.add(i);
		Log.i("Adicionou", "Adicionou saporra");
		if (v.getContentDescription().equals("+")) {
			Toast.makeText(this, "Produto Adicionado!", Toast.LENGTH_SHORT)
					.show();
			resetarLista();
		}
	}

	// private void marcarIeAPadroes() {
	// seta os ingredientes e adicionais marcados como o padrão do produto
	// que recebeu no parametro.

	// }

	private void resetarLista() {
		for (AdapterChild a : listas.get(0).getChildren()) {
			a.setChecked(true);
		}
		for (AdapterChild a : listas.get(1).getChildren()) {
			a.setChecked(false);
		}
		
		expListView.collapseGroup(0);
		expListView.collapseGroup(1);
		mudarPreco();

	}

	private List<Ingrediente> pegarIngredientesNaoMarcados() {
		List<Ingrediente> i = new ArrayList<Ingrediente>();
		for (AdapterChild a : listas.get(0).getChildren()) {
			if (!a.isChecked()) {
				i.add(a.getIngrediente());
			}
		}
		return i;
	}

	private List<Adicional> pegarAdicionaisMarcados() {
		List<Adicional> adic = new ArrayList<Adicional>();
		for (AdapterChild a : listas.get(1).getChildren()) {
			if (a.isChecked()) {
				adic.add(a.getAdicional());
			}
		}
		return adic;
	}

	public void finalizarSelecao(View v) {
		adicionarNaLista(v);

		Intent i = getIntent();
		i.setClass(TelaSubProdutos.this, TelaPedido.class);
		i.putExtra("atendimento", a);
		i.putExtra("itens", itens);
		startActivity(i);
	}
}