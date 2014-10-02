package com.macaxeira.DAO;


import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.macaxeira.model.Categoria;
import com.macaxeira.model.Produto;
import com.macaxeira.util.DatabaseHelper;
import com.macaxeira.util.MyApp;

public class ProdutoDAOImpl implements ProdutoDAO {

	DatabaseHelper helper = new DatabaseHelper(MyApp.getAppContext());
	private IngredienteDAOImpl ingDao = new IngredienteDAOImpl();
	private AdicionalDAOImpl adcDao = new AdicionalDAOImpl();
	
	public void createProduto(Produto prod) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		ContentValues value = new ContentValues();
		value.put("nome", prod.getNome());
		value.put("categoria_id", prod.getId());
		db.insert("produto", null, value);
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
			p.setId(codProd);
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
				   "SET nome='" + prod.getNome() + "', categoria_id=" + prod.getId() + " " +
				   "WHERE _id=" + prod.getId() + ";");
	}

	public void deleteProduto(Produto prod) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("DELETE FROM produto " +
				   "WHERE _id=" + prod.getId() + ";");
	}
	
	@Override
	public Produto buscarProdutoPorId(int id) {
		SQLiteDatabase db = helper.getReadableDatabase();
		
		Produto p = new Produto();		
		
		p.setId(id);
		
		Cursor cursor = db.rawQuery("SELECT * FROM produto WHERE _id=" + id + ";" , null);
		
		cursor.moveToFirst();
		
		String nomeProduto = cursor.getString(1);
		
		p.setNome(nomeProduto);
		
		p.setIngredientes(ingDao.buscarIngredientePorProduto(p));
		
		cursor.close();
		
		return p;
	}
	
	public List<Produto> buscarProdutoPorCategoria(Categoria categ) {
		SQLiteDatabase db = helper.getReadableDatabase();
		
		List<Produto> listaProd = new ArrayList<Produto>();
		
		Cursor cursor = db.rawQuery("SELECT * FROM produto WHERE categoria_id=" + categ.getId() + ";" , null);
		
		cursor.moveToFirst();
		
		for(int i = 1; i <= cursor.getCount(); i++){
			int idProd = cursor.getInt(0);
			String nomeProd = cursor.getString(1);
			double precoProd = cursor.getDouble(2);
			
			Produto p = new Produto();
			p.setId(idProd);
			p.setNome(nomeProd);
			p.setPreco(precoProd);
			p.setIngredientes(ingDao.buscarIngredientePorProduto(p));
			p.setAdicionals(adcDao.buscarAdicionalPorProduto(p));
			
			listaProd.add(p);
			
			cursor.moveToNext();
		}
		
		cursor.close();
		
		return listaProd;
	}
	
}
