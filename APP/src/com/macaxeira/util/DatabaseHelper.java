package com.macaxeira.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
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
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
