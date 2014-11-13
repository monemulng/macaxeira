package com.macaxeira.DAO;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.macaxeira.model.Atendimento;
import com.macaxeira.util.DatabaseHelper;
import com.macaxeira.util.MyApp;

public class AtendimentoDAOImpl implements AtendimentoDAO {

	DatabaseHelper helper = new DatabaseHelper(MyApp.getAppContext());
	
	@Override
	public void createAtendimento(Atendimento atend) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		ContentValues value = new ContentValues();
		db.insert("atendimento", null, value);
	}

	@Override
	public List<Atendimento> readAtendimento() {
		List<Atendimento> listaAtend = new ArrayList<Atendimento>();
		SQLiteDatabase db = helper.getReadableDatabase();
		
		Cursor cursor = db.rawQuery("SELECT * FROM atendimento;", null);
		
		cursor.moveToFirst();
		
		for(int i = 0; i < cursor.getCount(); i++){
			int codAtend = cursor.getInt(0);
			String nomeAtend = cursor.getString(1);
			
			Atendimento atend = new Atendimento();
			atend.setId(codAtend);
			
			listaAtend.add(atend);
			
			cursor.moveToNext();
		}
		
		return listaAtend;
	}

	@Override
	public void updateAtendimento(Atendimento atend) {
		
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("UPDATE atendimento " +
				   "WHERE _id=" + atend.getId() + ";");
		
	}

	@Override
	public void deleteAtendimento(Atendimento atend) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("DELETE FROM atendimento " +
				   "WHERE _id=" + atend.getId() + ";");

	}

	@Override
	public List<Atendimento> buscarAtendimentoPorMesa(int mesaId) {
		SQLiteDatabase db = helper.getReadableDatabase();

		List<Atendimento> listaAtend = new ArrayList<Atendimento>();
		
		Cursor cursor = db.rawQuery(
				"SELECT * FROM Atendimento WHERE mesa_id="
						+ mesaId + ";", null);

		cursor.moveToFirst();

		for (int i = 1; i <= cursor.getCount(); i++) {
			int atendId = cursor.getInt(1);
			int mesId = cursor.getInt(2);

			Atendimento atend = new Atendimento();
			
			atend.setId(atendId);
			//atend.setMesa(mesa)
			listaAtend.add(atend);
			cursor.moveToNext();
		}
		
		cursor.close();
		
		return listaAtend;
	}

}
