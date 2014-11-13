package com.macaxeira.android;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.macaxeira.http.HttpClientListener;
import com.macaxeira.http.InternetCheck;
import com.macaxeira.http.PostHttpClientTask;
import com.macaxeira.model.Atendimento;
import com.macaxeira.model.Ingrediente;
import com.macaxeira.model.ItemPedido;
import com.macaxeira.model.Pedido;

public class TelaPedido extends Activity implements OnItemClickListener, HttpClientListener {

	private Pedido p;
	private Atendimento a;
	private TextView preco;
	private TextView mesa;
	private TextView numPedido;
	private ListView listaPedidos;
	private ArrayList<ItemPedido> itens;
	private Gson gson = new Gson();
	
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
		
		preco.setText("Preço total: "+pegarPrecoTotal());
		mesa.setText("Mesa :"+a.getMesa().getId());
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

	public void adicionarMaisProdutos(View v){
		Intent i = new Intent(this, MainActivity.class);
		a.setPedidoAtual(p);
		i.putExtra("atendimento", a);
		startActivity(i);
		
	}
	
	
	public void enviar(View v){
		
		Ingrediente i = new Ingrediente();
		i.setNome("ovo");
		
		String json = gson.toJson(i);
		
		if(InternetCheck.isConnected(this)){
			PostHttpClientTask task = new PostHttpClientTask();
		
			NameValuePair values = new BasicNameValuePair("json",json);
			task.addNameValuePair(values);
		
		
			task.addHttpClientListener(this);
			task.execute("http://localhost:8080/macaxeiraServer/json.php");
		
		}else{
			Toast.makeText(this, "Sua conexão está desabilitada", Toast.LENGTH_LONG).show();
		}
		
		
		
	}
	
	
	@Override
	public void updateHttpClientListener(String json) {
		
		
		Ingrediente i = gson.fromJson(json, Ingrediente.class);
		
		i.getId();
		
		 
	}
	
	
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}




}
