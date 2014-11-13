package com.macaxeira.DAO;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.macaxeira.model.Pedido;
import com.macaxeira.util.DatabaseHelper;
import com.macaxeira.util.MyApp;

public class PedidoDAOImpl implements PedidoDAO {

	DatabaseHelper helper = new DatabaseHelper(MyApp.getAppContext());
	
	@Override
	public void createPedido(Pedido ped) {
	SQLiteDatabase db = helper.getWritableDatabase();
		
		ContentValues value = new ContentValues();
		value.put("nome", ped.getNomeCliente());
		db.insert("pedido", null, value);
		
	}

	@Override
	public List<Pedido> readPedido() {
		List<Pedido> listaPedido = new ArrayList<Pedido>();
		SQLiteDatabase db = helper.getReadableDatabase();
		
		Cursor cursor = db.rawQuery("SELECT * FROM pedido;", null);
		
		cursor.moveToFirst();
		
		for(int i = 0; i < cursor.getCount(); i++){
			int codPed = cursor.getInt(0);
			String nomePed = cursor.getString(1);
			
			Pedido ped = new Pedido();
			ped.setId(codPed);
			ped.setNomeCliente(nomePed);
			
			listaPedido.add(ped);
			
			cursor.moveToNext();
		}
		
		cursor.close();
		
		return listaPedido;
	}

	@Override
	public void updatePedido(Pedido ped) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("UPDATE pedido " +
				   "SET nome='" + ped.getNomeCliente() + " " +
				   "WHERE _id=" + ped.getId() + ";");

	
	}

	@Override
	public void deletePedido(Pedido ped) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("DELETE FROM pedido " +
				   "WHERE _id=" + ped.getId() + ";");
		
	}

	@Override
	public void salvarPedido(Pedido ped) {
		// TODO Auto-generated method stub
		
	}

}
