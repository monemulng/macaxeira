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
		
		db.execSQL("CREATE TABLE categoria ( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
											"nome TEXT NOT NULL);");
		db.execSQL("CREATE TABLE produto ( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
										  "nome TEXT NOT NULL, " +
										  "categoria_id INTEGER, " +
										  "FOREIGN KEY(categoria_id) REFERENCES categoria(_id));");
		// V
		ContentValues value = new ContentValues();
		value.put("nome", "Sanduíches");
		db.insert("categoria", null, value);
		value.clear();
		value.put("nome", "Batatas");
		db.insert("categoria", null, value);
		value.clear();
		value.put("nome", "Hamburger");
		value.put("categoria_id", 1);
		db.insert("produto", null, value);
		value.clear();
		value.put("nome", "Frango");
		value.put("categoria_id", 1);
		db.insert("produto", null, value);         
		value.clear();
		value.put("nome", "Picanha");
		value.put("categoria_id", 1);
		db.insert("produto", null, value);
		value.clear();
		value.put("nome", "Batata P");
		value.put("categoria_id", 2);
		db.insert("produto", null, value);
		value.clear();
		value.put("nome", "Batata M");
		value.put("categoria_id", 2);
		db.insert("produto", null, value);
		value.clear();
		value.put("nome", "Batata G");
		value.put("categoria_id", 2);
		db.insert("produto", null, value);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
