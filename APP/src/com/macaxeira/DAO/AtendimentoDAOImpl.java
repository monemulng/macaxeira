package com.macaxeira.DAO;

import java.util.List;

import com.macaxeira.model.Atendimento;

public class AtendimentoDAOImpl implements AtendimentoDAO {

	DatabaseHelper helper = new DatabaseHelper(MyApp.getAppContext());
	@Override
	public void createAtendimento(Atendimento atend) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		ContentValues value = new ContentValues();
		value.put("nome", atend.getNome());
		db.insert("ingrediente", null, value);
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
			atend.setNome(nomeAtend);
			
			listaAtend.add(atend);
			
			cursor.moveToNext();
	}

	@Override
	public void updateAtendimento(Atendimento atend) {
		
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("UPDATE atendimento " +
				   "SET nome='" + atend.getNome() + " " +
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
		// TODO Auto-generated method stub
		return null;
	}

}
