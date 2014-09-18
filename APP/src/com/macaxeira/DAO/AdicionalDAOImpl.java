package com.macaxeira.DAO;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.macaxeira.model.Adicional;
import com.macaxeira.model.Produto;
import com.macaxeira.util.DatabaseHelper;
import com.macaxeira.util.MyApp;

public class AdicionalDAOImpl implements AdicionalDAO {

	DatabaseHelper helper = new DatabaseHelper(MyApp.getAppContext());
	
	@Override
	public void createAdicional(Adicional adc) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		ContentValues value = new ContentValues();
		value.put("nome", adc.getNome());
		db.insert("adicional", null, value);

	}

	@Override
	public List<Adicional> readAdicional() {
		List<Adicional> listaAdic = new ArrayList<Adicional>();
		SQLiteDatabase db = helper.getReadableDatabase();
		
		Cursor cursor = db.rawQuery("SELECT * FROM adicional;", null);
		
		cursor.moveToFirst();
		
		for(int i = 0; i < cursor.getCount(); i++){
			int codAdc = cursor.getInt(0);
			String nomeAdc = cursor.getString(1);
			
			Adicional adc = new Adicional();
			adc.setId(codAdc);
			adc.setNome(nomeAdc);
			
			listaAdic.add(adc);
			
			cursor.moveToNext();
		}
		
		cursor.close();
		
		return listaAdic;
		
	}

	@Override
	public void updateAdicional(Adicional adc) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("UPDATE adicional " +
				   "SET nome='" + adc.getNome() + " " +
				   "WHERE _id=" + adc.getId() + ";");


	}

	@Override
	public void deleteAdicional(Adicional adc) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("DELETE FROM adicional " +
				   "WHERE _id=" + adc.getId() + ";");

	}

	@Override
	public List<Adicional> buscarAdicionalPorProduto(Produto prod) {
		SQLiteDatabase db = helper.getReadableDatabase();

		List<Adicional> listaAdic = new ArrayList<Adicional>();
		List<Integer> listaId = new ArrayList<Integer>();

		Cursor cursor = db.rawQuery(
				"SELECT * FROM produto_has_Adicional WHERE produto_id="
						+ prod.getCodProduto() + ";", null);

		cursor.moveToFirst();

		for (int i = 1; i <= cursor.getCount(); i++) {
			int idAdc = cursor.getInt(1);

			listaId.add(idAdc);

			cursor.moveToNext();
		}
		
		cursor.close();
		
		for (int i = 0; i < listaId.size(); i++){
			
			cursor = db.rawQuery("SELECT * FROM adicional WHERE _id=" +
							 listaId.get(i) + ";", null);
			
			cursor.moveToFirst();
			
			String nomeAdic = cursor.getString(1);
			
			Adicional adc = new Adicional();
			adc.setId(listaId.get(i));
			adc.setNome(nomeAdic);
			
			listaAdic.add(adc);
		}
		
		cursor.close();

		return listaAdic;
	}

}
