package com.macaxeira.DAO;

import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.macaxeira.model.Ingrediente;
import com.macaxeira.model.Produto;
import com.macaxeira.util.DatabaseHelper;
import com.macaxeira.util.MyApp;

public class ProdutoDAOImpl implements ProdutoDAO {

	DatabaseHelper helper = new DatabaseHelper(MyApp.getAppContext());
	
	public void createProduto(String nome, int idCategoria) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("INSERT INTO produto (nome, categoria_id)" +
				   "VALUES ('" + nome + "', " + idCategoria + ")");
	}
	
	public List<Produto> readProduto() {
		List<Produto> listaProd = null;
		SQLiteDatabase db = helper.getReadableDatabase();
		
		Cursor cursor = db.rawQuery("SELECT * FROM produto", null);
		
		cursor.moveToFirst();
		
		for(int i = 0; i < cursor.getCount(); i++){
			int codProd = cursor.getInt(0);
			String nomeProd = cursor.getString(1);
			
			Produto p = new Produto();
			p.setCodProduto(codProd);
			p.setNome(nomeProd);
			
			listaProd.add(p);
			
			cursor.moveToNext();
		}
		
		cursor.close();
		
		return listaProd;
	}
	
	public void updateProduto(int id, String nomeAlt, int idCategoriaAlt) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("UPDATE produto " +
				   "SET nome='" + nomeAlt + "', categoria_id=" + idCategoriaAlt + " " +
				   "WHERE _id='" + id + "'");
	}

	public void deleteProduto(int id) {
		
	}
	
	public List<Produto> buscarProdutoPorCategoria(int id) {
		List<Produto> listaProd = null;
		SQLiteDatabase db = helper.getReadableDatabase();
		
		Cursor cursor = db.rawQuery("SELECT nomeProduto FROM produto WHERE categoria_id=" + id, null);
		
		cursor.moveToFirst();
		
		for(int i = 0; i < cursor.getCount(); i++){
			String nomeProd = cursor.getString(1);
			
			Produto p = new Produto();
			p.setNome(nomeProd);
			
			listaProd.add(p);
			
			cursor.moveToNext();
		}
		
		cursor.close();
		
		return listaProd;
	}
	
}
