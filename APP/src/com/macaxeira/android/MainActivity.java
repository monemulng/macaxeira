package com.macaxeira.android;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.macaxeira.DAO.ProdutoDAO;
import com.macaxeira.DAO.ProdutoDAOImpl;
import com.macaxeira.model.ItemPedido;
import com.macaxeira.model.Produto;
import com.macaxeira.util.MyApp;

public class MainActivity extends Activity {
	private ProdutoDAO prodDao = new ProdutoDAOImpl();
	private List<ItemPedido> itensDoPedido = new ArrayList<ItemPedido>();;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void onResume() {
		super.onResume();
		if (getIntent().getExtras() != null) {
			if (getIntent().getExtras().getSerializable("itens") != null) {
				ArrayList<ItemPedido> i = (ArrayList<ItemPedido>) getIntent()
						.getExtras().getSerializable("itens");
				itensDoPedido.addAll(i);
				Log.i("Testando", "Adicionou na lista principal");
			}
		}
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void escolheCategoria(View v) {
		Intent intent = new Intent(MainActivity.this, TelaProdutos.class);
		intent.putExtra("id", v.getContentDescription());
		startActivity(intent);
	}

	public void buscar(View v) {

		SearchView s = (SearchView) v;
		Produto p = prodDao.buscarProdutoPorId(Integer.parseInt(s.getQuery()
				.toString()));
		if (p == null) {
			Toast.makeText(MyApp.getAppContext(), "Id não encontrado!", 1000)
					.show();
		} else {
			Intent intent = new Intent(MainActivity.this, TelaSubProdutos.class);
			intent.putExtra("produto", p);
			startActivity(intent);
		}

	}
}
