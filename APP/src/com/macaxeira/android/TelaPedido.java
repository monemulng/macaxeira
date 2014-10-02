package com.macaxeira.android;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Text;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.macaxeira.model.Atendimento;
import com.macaxeira.model.ItemPedido;
import com.macaxeira.model.Pedido;
import com.macaxeira.model.Produto;

public class TelaPedido extends Activity implements OnItemClickListener {

	private Pedido p;
	private Atendimento a;
	private TextView preco;
	private TextView mesa;
	private TextView numPedido;
	private ListView listaPedidos;
	private ArrayList<ItemPedido> itens;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_pedido);
		a = (Atendimento) getIntent().getExtras().getSerializable("atendimento");
		itens = (ArrayList<ItemPedido>) getIntent().getExtras().getSerializable("itens");
		
		criarPedido();

		preco = (TextView) findViewById(R.id.preco1);
		mesa = (TextView) findViewById(R.id.numMesa);
		numPedido = (TextView) findViewById(R.id.numPedido);
		listaPedidos = (ListView) findViewById(R.id.listaPedido);
		
		preco.setText(""+pegarPrecoTotal());
		mesa.setText(""+a.getMesa().getId());
		numPedido.setText("Pedido: "+ a.getPedidoAtual().getId());
		
		ArrayAdapter <ItemPedido> filelist = null;
		filelist = new ArrayAdapter<ItemPedido>(this, android.R.layout.simple_list_item_1, a.getPedidoAtual().getItemPedidos());
		listaPedidos.setAdapter(filelist);
		
		listaPedidos.setOnItemClickListener(this);
	}


	private String pegarPrecoTotal() {
		double precoTotal =0;
		for(ItemPedido i :a.getPedidoAtual().getItemPedidos()){
			precoTotal += i.getPreco();
		}
		return ""+precoTotal;
	}


	private void criarPedido() {
		if(a.getPedidoAtual() == null){
			p = new Pedido();
			p.setId(1);
			//Setar o id pelo ultimo adicionado no banco;
			p.setItemPedidos(itens);
			a.setPedidoAtual(p);
			a.addPedido(p);
			
		}else{
			p = a.getPedidoAtual();
			p.getItemPedidos().addAll(itens);
		}
	}


	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_pedido, menu);
		return true;
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

}
