package com.macaxeira.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{
	
	private static final String BANCO_DADOS = "MacaxeiraDB";
	private static int VERSAO = 1;

	public DatabaseHelper(Context context) {
		super(context, BANCO_DADOS, null, VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("TESTE DE BANCO", "Entrou");
		
		db.execSQL("CREATE TABLE categoria ("
				+ "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "nome TEXT NOT NULL);");
		
		db.execSQL("CREATE TABLE produto ("
				+ "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "nome TEXT NOT NULL, "
				+ "preco DOUBLE NOT NULL, "
				+ "categoria_id INTEGER NOT NULL, "
				+ "FOREIGN KEY (categoria_id) "
				+ "REFERENCES categoria (_id));");
		
		db.execSQL("CREATE TABLE ingrediente ("
				+ "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "nome TEXT NOT NULL);");
		
		db.execSQL("CREATE TABLE produto_has_Ingrediente ("
				+ "produto_id INTEGER NOT NULL, "
				+ "ingrediente_id INTEGER NOT NULL, "
				+ "PRIMARY KEY (produto_id, ingrediente_id), "
				+ "FOREIGN KEY (produto_id) "
				+ "REFERENCES produto (_id), "
				+ "FOREIGN KEY (ingrediente_id) "
				+ "REFERENCES ingrediente (_id));");
		
		db.execSQL("CREATE TABLE adicional ("
				+ "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "nome TEXT NOT NULL, "
				+ "preco DOUBLE NOT NULL);");
		
		db.execSQL("CREATE TABLE produto_has_Adicional ("
				+ "produto_id INTEGER NOT NULL, "
				+ "adicional_id INTEGER NOT NULL, "
				+ "PRIMARY KEY (produto_id, adicional_id), "
				+ "FOREIGN KEY (produto_id) "
				+ "REFERENCES produto (_id), "
				+ "FOREIGN KEY (adicional_id) "
				+ "REFERENCES adicional (_id));");
		
		db.execSQL("CREATE TABLE pedido ("
				+ "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "preco DOUBLE NOT NULL);");
		
		db.execSQL("CREATE TABLE item_Pedido ("
				+ "item_Pedido_id INTEGER NOT NULL, "
				+ "pedido_id INTEGER NOT NULL, "
				+ "produto_id INTEGER NOT NULL, "
				+ "preco DOUBLE NULL, "
				+ "PRIMARY KEY (item_Pedido_id, pedido_id, produto_id), "
				+ "FOREIGN KEY (pedido_id) "
				+ "REFERENCES Pedido (_id), "
				+ "FOREIGN KEY (produto_id) "
				+ "REFERENCES produto (_id));");
		
		db.execSQL("DROP TABLE IF EXISTS ingrediente_Excluido ;"
				+ "CREATE TABLE IF NOT EXISTS ingrediente_Excluido ("
				+ "item_Pedido_id INTEGER NOT NULL, "
				+ "ingrediente_id INTEGER NOT NULL, "
				+ "PRIMARY KEY (item_Pedido_id, ingrediente_id), "
				+ "FOREIGN KEY (item_Pedido_id) "
				+ "REFERENCES item_Pedido (item_Pedido_id), "
				+ "FOREIGN KEY (ingrediente_id) "
				+ "REFERENCES ingrediente (_id);");
		
		db.execSQL("DROP TABLE IF EXISTS item_Pedido_has_Adicional ;"
				+ "CREATE TABLE IF NOT EXISTS item_Pedido_has_Adicional ("
				+ "item_Pedido_id INTEGER NOT NULL, "
				+ "adicional_id INTEGER NOT NULL, "
				+ "PRIMARY KEY (item_Pedido_id, adicional_id), "
				+ "FOREIGN KEY (item_Pedido_id) "
				+ "REFERENCES item_Pedido (item_Pedido_id), "
				+ "FOREIGN KEY (adicional_id) "
				+ "REFERENCES adicional (_id));");
		
		ContentValues values = new ContentValues();
		
		values.put("nome", "Sanduíches");
		db.insert("categoria", null, values);
		values.clear();
		values.put("nome", "Batatas");
		db.insert("categoria", null, values);
		values.clear();
		
		values.put("nome", "Hamburger");
		values.put("preco", 9.99);
		values.put("categoria_id", 1);
		db.insert("produto", null, values);
		values.clear();
		values.put("nome", "Frango");
		values.put("preco", 7.95);
		values.put("categoria_id", 1);
		db.insert("produto", null, values);         
		values.clear();
		values.put("nome", "Picanha");
		values.put("preco", 18.90);
		values.put("categoria_id", 1);
		db.insert("produto", null, values);
		values.clear();
		values.put("nome", "Batata P");
		values.put("preco", 3.75);
		values.put("categoria_id", 2);
		db.insert("produto", null, values);
		values.clear();
		values.put("nome", "Batata M");
		values.put("preco", 4.75);
		values.put("categoria_id", 2);
		db.insert("produto", null, values);
		values.clear();
		values.put("nome", "Batata G");
		values.put("preco", 6.50);
		values.put("categoria_id", 2);
		db.insert("produto", null, values);
		values.clear();
		
		values.put("nome", "Pao");
		db.insert("ingrediente", null, values);
		values.clear();
		values.put("nome", "Hamburguer bovino");
		db.insert("ingrediente", null, values);
		values.clear();
		values.put("nome", "Hamburguer de frango");
		db.insert("ingrediente", null, values);
		values.clear();
		values.put("nome", "Alface");
		db.insert("ingrediente", null, values);
		values.clear();
		values.put("nome", "Tomate");
		db.insert("ingrediente", null, values);
		values.clear();
		values.put("nome", "Picles");
		db.insert("ingrediente", null, values);
		values.clear();
		values.put("nome", "Ovo");
		db.insert("ingrediente", null, values);
		values.clear();
		values.put("nome", "Batata");
		db.insert("ingrediente", null, values);
		values.clear();		
		
		values.put("nome", "Bacon" );
		values.put("preco", 1.75);
		db.insert("adicional", null, values);
		values.clear();
		values.put("nome", "Chedar" );
		values.put("preco", 0.99);
		db.insert("adicional", null, values);
		values.clear();		
		values.put("nome", "Catupiry" );
		values.put("preco", 2.00);
		db.insert("adicional", null, values);
		values.clear();		
		values.put("nome", "Molho barbecue" );
		values.put("preco", 1.50);
		db.insert("adicional", null, values);
		values.clear();
		
		values.put("produto_id", 1);
		values.put("ingrediente_id", 1);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		values.put("produto_id", 1);
		values.put("ingrediente_id", 2);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		values.put("produto_id", 1);
		values.put("ingrediente_id", 4);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		values.put("produto_id", 1);
		values.put("ingrediente_id", 5);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		values.put("produto_id", 1);
		values.put("ingrediente_id", 6);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		
		values.put("produto_id", 2);
		values.put("ingrediente_id", 1);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		values.put("produto_id", 2);
		values.put("ingrediente_id", 3);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		values.put("produto_id", 2);
		values.put("ingrediente_id", 4);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		values.put("produto_id", 2);
		values.put("ingrediente_id", 5);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		values.put("produto_id", 2);
		values.put("ingrediente_id", 6);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		
		values.put("produto_id", 3);
		values.put("ingrediente_id", 1);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		values.put("produto_id", 3);
		values.put("ingrediente_id", 2);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		values.put("produto_id", 3);
		values.put("ingrediente_id", 6);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		values.put("produto_id", 3);
		values.put("ingrediente_id", 7);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		
		values.put("produto_id", 4);
		values.put("ingrediente_id", 8);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		values.put("produto_id", 5);
		values.put("ingrediente_id", 8);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		values.put("produto_id", 6);
		values.put("ingrediente_id", 8);
		db.insert("produto_has_Ingrediente", null, values);
		values.clear();
		
		values.put("produto_id", 1);
		values.put("adicional_id", 1);
		db.insert("produto_has_Adicional", null, values);
		values.clear();
		values.put("produto_id", 1);
		values.put("adicional_id", 2);
		db.insert("produto_has_Adicional", null, values);
		values.clear();
		values.put("produto_id", 1);
		values.put("adicional_id", 3);
		db.insert("produto_has_Adicional", null, values);
		values.clear();
		values.put("produto_id", 1);
		values.put("adicional_id", 4);
		db.insert("produto_has_Adicional", null, values);
		values.clear();
		
		values.put("produto_id", 2);
		values.put("adicional_id", 1);
		db.insert("produto_has_Adicional", null, values);
		values.clear();
		values.put("produto_id", 2);
		values.put("adicional_id", 2);
		db.insert("produto_has_Adicional", null, values);
		values.clear();
		values.put("produto_id", 2);
		values.put("adicional_id", 3);
		db.insert("produto_has_Adicional", null, values);
		values.clear();
		values.put("produto_id", 2);
		values.put("adicional_id", 4);
		db.insert("produto_has_Adicional", null, values);
		values.clear();
		
		values.put("produto_id", 3);
		values.put("adicional_id", 1);
		db.insert("produto_has_Adicional", null, values);
		values.clear();
		values.put("produto_id", 3);
		values.put("adicional_id", 2);
		db.insert("produto_has_Adicional", null, values);
		values.clear();
		values.put("produto_id", 3);
		values.put("adicional_id", 3);
		db.insert("produto_has_Adicional", null, values);
		values.clear();
		values.put("produto_id", 3);
		values.put("adicional_id", 4);
		db.insert("produto_has_Adicional", null, values);
		values.clear();
		
		values.put("produto_id", 4);
		values.put("adicional_id", 2);
		db.insert("produto_has_Adicional", null, values);
		values.clear();
		values.put("produto_id", 5);
		values.put("adicional_id", 2);
		db.insert("produto_has_Adicional", null, values);
		values.clear();
		values.put("produto_id", 6);
		values.put("adicional_id", 2);
		db.insert("produto_has_Adicional", null, values);
		values.clear();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
