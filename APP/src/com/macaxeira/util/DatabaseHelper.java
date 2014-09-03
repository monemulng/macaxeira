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
		
		ContentValues values1 = new ContentValues();
		values1.put("nome", "Sanduíches");
		db.insert("categoria", null, values1);
		ContentValues values2 = new ContentValues();
		values2.put("nome", "Batatas");
		db.insert("categoria", null, values2);
		ContentValues values3 = new ContentValues();
		values3.put("nome", "Hamburger");
		values3.put("categoria_id", 1);
		db.insert("produto", null, values3);
		ContentValues values4 = new ContentValues();
		values4.put("nome", "Frango");
		values4.put("categoria_id", 1);
		db.insert("produto", null, values4);
		ContentValues values5 = new ContentValues();
		values5.put("nome", "Picanha");
		values5.put("categoria_id", 1);
		db.insert("produto", null, values5);
		ContentValues values6 = new ContentValues();
		values6.put("nome", "Batata P");
		values6.put("categoria_id", 2);
		db.insert("produto", null, values6);
		ContentValues values7 = new ContentValues();
		values7.put("nome", "Batata M");
		values7.put("categoria_id", 2);
		db.insert("produto", null, values7);
		ContentValues values8 = new ContentValues();
		values8.put("nome", "Batata G");
		values8.put("categoria_id", 2);
		db.insert("produto", null, values8);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
