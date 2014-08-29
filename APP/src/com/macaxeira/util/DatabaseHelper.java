package com.macaxeira.util;

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
		
		db.execSQL("CREATE TABLE categoria (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
											"nome TEXT NOT NULL)");
		db.execSQL("CREATE TABLE produto (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
										  "nome TEXT NOT NULL, " +
										  "categoria_id INTEGE NOT NULL, " +
										  "FOREIGN KEY(categoria_id) REFERENCES categoria(_id))");
		db.execSQL("INSERT INTO categoria (nome) " +
				   "VALUES ('Sanduiches') " +
				   "INSERT INTO categoria (nome) " +
				   "VALUES ('Batatas')");
		db.execSQL("INSERT INTO produto (nome, categoria_id) " +
				   "VALUES ('Hamburger', 1) " +
				   "INSERT INTO produto (nome, categoria_id) " +
				   "VALUES ('Frango', 1) " +
				   "INSERT INTO produto (nome, categoria_id) " +
				   "VALUES ('Picanha', 1) " +
				   "INSERT INTO produto (nome, categoria_id) " +
				   "VALUES ('Batata P', 2) " +
				   "INSERT INTO produto (nome, categoria_id) " +
				   "VALUES ('Batata M', 2) " +
				   "INSERT INTO produto (nome, categoria_id) " +
				   "VALUES ('Batata G', 2)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
