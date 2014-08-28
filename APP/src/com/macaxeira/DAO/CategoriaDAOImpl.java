package com.macaxeira.DAO;

import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.macaxeira.model.Categoria;
import com.macaxeira.model.Produto;
import com.macaxeira.util.DatabaseHelper;
import com.macaxeira.util.MyApp;

public class CategoriaDAOImpl implements CategoriaDAO {
	
	DatabaseHelper helper = new DatabaseHelper(MyApp.getAppContext());

	public void createCategoria(String nome, int idCategoria) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("INSERT INTO categoria (nome) " +
				   "VALUES ('" + nome + "')");
	}

	public List<Categoria> readCategoria() {
		List<Categoria> listaCat = null;
		SQLiteDatabase db = helper.getReadableDatabase();
		
		Cursor cursor = db.rawQuery("SELECT * FROM categoria", null);
		
		cursor.moveToFirst();
		
		for(int i = 0; i < cursor.getCount(); i++){
			int codCat = cursor.getInt(0);
			String nomeCat = cursor.getString(1);
			
			Categoria c = new Categoria();
			c.setCodCategoria(codCat);
			c.setNome(nomeCat);
			
			listaCat.add(c);
			
			cursor.moveToNext();
		}
		
		cursor.close();
		
		return listaCat;
	}

	public void updateCategoria(int id, String nomeAlt, int idCategoriaAlt) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("UPDATE categoria " +
				   "SET nome='" + nomeAlt + " " +
				   "WHERE _id=" + id );
		
	}

	public void deleteCategoria(int id) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("DELETE FROM categoria " +
				   "WHERE _id=" + id);
	}
	
}
