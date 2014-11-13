package com.macaxeira.android;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.macaxeira.DAO.ProdutoDAO;
import com.macaxeira.DAO.ProdutoDAOImpl;
import com.macaxeira.model.Atendimento;
import com.macaxeira.model.ItemPedido;
import com.macaxeira.model.Mesa;
import com.macaxeira.model.Pedido;
import com.macaxeira.model.Produto;
import com.macaxeira.util.MyApp;

public class MainActivity extends Activity {

	private Mesa m;
	private SearchView s;
	private EditText numeroMesa;
	private Atendimento a;

	private ProdutoDAO prodDao = new ProdutoDAOImpl();
	private List<ItemPedido> itensDoPedido = new ArrayList<ItemPedido>();;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		numeroMesa = (EditText) findViewById(R.id.mesaNumero);

		criandoAtendimento();

	}

	private void criandoAtendimento() {
		if (getIntent().getExtras() != null) {
			if (getIntent().getExtras().getSerializable("atendimento") != null) {
				a = (Atendimento) getIntent().getExtras().getSerializable(
						"atendimento");
				numeroMesa.setEnabled(false);
				m = a.getMesa();
				numeroMesa.setText("" + m.getId());

			}
		} else {
			numeroMesa.setEnabled(true);
			a = new Atendimento();
			m = new Mesa();
			m.setId(0);
			a.setMesa(m);
			m.addAtendimento(a);
		}
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void escolheCategoria(View v) {
		
		if (m.getId() == 0) {
			if (numeroMesa.getText().toString().equals("")) {	
				Toast.makeText(this, "Digite o numero da mesa!",
						Toast.LENGTH_SHORT).show();
			} else {
				m.setId(Integer.parseInt(numeroMesa.getText().toString()));
				Intent intent = new Intent(MainActivity.this,
						TelaProdutos.class);
				intent.putExtra("atendimento", a);
				intent.putExtra("id", v.getContentDescription());
				startActivity(intent);
			}
		}else{
			Intent intent = new Intent(MainActivity.this,
					TelaProdutos.class);
			intent.putExtra("atendimento", a);
			intent.putExtra("id", v.getContentDescription());
			startActivity(intent);
		}

	}

	public void buscar(View v) {
		s = (SearchView) v;
		Produto p = prodDao.buscarProdutoPorId(Integer.parseInt(s.getQuery()
				.toString()));
		if (p == null) {
			Toast.makeText(MyApp.getAppContext(), "Id não encontrado!", 1000)
					.show();
		} else {
			Intent intent = new Intent(MainActivity.this, TelaSubProdutos.class);
			intent.putExtra("atendimento", a);
			intent.putExtra("produto", p);
			startActivity(intent);
		}

	}
}
