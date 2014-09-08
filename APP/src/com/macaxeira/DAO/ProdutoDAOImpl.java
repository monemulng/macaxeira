package com.macaxeira.DAO;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.macaxeira.model.Categoria;
import com.macaxeira.model.Produto;
import com.macaxeira.util.DatabaseHelper;
import com.macaxeira.util.MyApp;

public class ProdutoDAOImpl implements ProdutoDAO {

	DatabaseHelper helper = new DatabaseHelper(MyApp.getAppContext());
	
	public void createProduto(Produto prod) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("INSERT INTO produto (nome, categoria_id) " +
				   "VALUES ('" + prod.getNome() + "', " + prod.getCodCategoria() + ");");
	}
	
	public List<Produto> readProduto() {
		List<Produto> listaProd = new ArrayList<Produto>();
		SQLiteDatabase db = helper.getReadableDatabase();
		
		Cursor cursor = db.rawQuery("SELECT * FROM produto;", null);
		
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
	
	public void updateProduto(Produto prod) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("UPDATE produto " +
				   "SET nome='" + prod.getNome() + "', categoria_id=" + prod.getCodCategoria() + " " +
				   "WHERE _id=" + prod.getCodProduto() + ";");
	}

	public void deleteProduto(Produto prod) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("DELETE FROM produto " +
				   "WHERE _id=" + prod.getCodProduto() + ";");
	}
	
	@Override
	public Produto buscarProdutoPorId(int id) {
		// C
		return null;
	}
	
	public List<Produto> buscarProdutoPorCategoria(Categoria categ) {
		SQLiteDatabase db = helper.getReadableDatabase();
		
		List<Produto> listaProd = new ArrayList<Produto>();
		
		Cursor cursor = db.rawQuery("SELECT * FROM produto WHERE categoria_id=" + categ.getCodCategoria() + ";" , null);
		
		cursor.moveToFirst();
		
		for(int i = 1; i <= cursor.getCount(); i++){
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
