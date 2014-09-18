package com.macaxeira.DAO;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.macaxeira.model.Ingrediente;
import com.macaxeira.model.Produto;
import com.macaxeira.util.DatabaseHelper;
import com.macaxeira.util.MyApp;

public class IngredienteDAOImpl implements IngredienteDAO {

	DatabaseHelper helper = new DatabaseHelper(MyApp.getAppContext());

	public void createIngrediente(Ingrediente ingr) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		ContentValues value = new ContentValues();
		value.put("nome", ingr.getNome());
		db.insert("ingrediente", null, value);
	}

	@Override
	public List<Ingrediente> readIngrediente() {
		List<Ingrediente> listaIngred = new ArrayList<Ingrediente>();
		SQLiteDatabase db = helper.getReadableDatabase();
		
		Cursor cursor = db.rawQuery("SELECT * FROM ingrediente;", null);
		
		cursor.moveToFirst();
		
		for(int i = 0; i < cursor.getCount(); i++){
			int codIngr = cursor.getInt(0);
			String nomeIngr = cursor.getString(1);
			
			Ingrediente ingr = new Ingrediente();
			ingr.setCodIngrediente(codIngr);
			ingr.setNome(nomeIngr);
			
			listaIngred.add(ingr);
			
			cursor.moveToNext();
		}
		
		cursor.close();
		
		return listaIngred;
	}

	@Override
	public void updateIngrediente(Ingrediente ingr) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("UPDATE ingrediente " +
				   "SET nome='" + ingr.getNome() + " " +
				   "WHERE _id=" + ingr.getCodIngrediente() + ";");

	}

	@Override
	public void deleteIngrediente(Ingrediente ingr) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("DELETE FROM ingrediente " +
				   "WHERE _id=" + ingr.getCodIngrediente() + ";");

	}

	@Override
	public List<Ingrediente> buscarIngredientePorProduto(Produto prod) {
		SQLiteDatabase db = helper.getReadableDatabase();

		List<Ingrediente> listaIngred = new ArrayList<Ingrediente>();
		List<Integer> listaId = new ArrayList<Integer>();

		Cursor cursor = db.rawQuery(
				"SELECT * FROM produto_has_Ingrediente WHERE produto_id="
						+ prod.getCodProduto() + ";", null);

		cursor.moveToFirst();

		for (int i = 1; i <= cursor.getCount(); i++) {
			int idIngred = cursor.getInt(1);

			listaId.add(idIngred);

			cursor.moveToNext();
		}
		
		cursor.close();
		
		for (int i = 0; i < listaId.size(); i++){
			
			cursor = db.rawQuery("SELECT * FROM ingrediente WHERE _id=" +
							 listaId.get(i) + ";", null);
			
			cursor.moveToFirst();
			
			String nomeIngr = cursor.getString(1);
			
			Ingrediente ingr = new Ingrediente();
			ingr.setCodIngrediente(listaId.get(i));
			ingr.setNome(nomeIngr);
			
			listaIngred.add(ingr);
		}
		
		cursor.close();

		return listaIngred;
	}

}
