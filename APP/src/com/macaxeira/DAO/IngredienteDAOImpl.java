package com.macaxeira.DAO;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.macaxeira.model.Ingrediente;
import com.macaxeira.model.Produto;
import com.macaxeira.util.DatabaseHelper;
import com.macaxeira.util.MyApp;

public class IngredienteDAOImpl implements IngredienteDAO {

	DatabaseHelper helper = new DatabaseHelper(MyApp.getAppContext());

	public void createIngrediente(Ingrediente ingr) {

	}

	@Override
	public List<Ingrediente> readIngrediente() {
		// L
		return null;
	}

	@Override
	public void updateIngrediente(Ingrediente ingr) {
		// L

	}

	@Override
	public void deleteIngrediente(Ingrediente ingr) {
		// L

	}

	@Override
	public List<Ingrediente> buscarIngredientePorProduto(Produto prod) {
		SQLiteDatabase db = helper.getReadableDatabase();

		List<Ingrediente> listaIngred = new ArrayList<Ingrediente>();

		Cursor cursor = db.rawQuery(
				"SELECT * FROM ingrediente WHERE produto_id="
						+ prod.getCodProduto() + ";", null);

		cursor.moveToFirst();

		for (int i = 1; i <= cursor.getCount(); i++) {
			String nomeIngred = cursor.getString(1);

			Ingrediente ing = new Ingrediente();
			ing.setNome(nomeIngred);

			listaIngred.add(ing);

			cursor.moveToNext();
		}

		cursor.close();

		return listaIngred;
	}

}
