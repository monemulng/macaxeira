package com.macaxeira.DAO;

import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.macaxeira.model.Ingrediente;
import com.macaxeira.model.Produto;
import com.macaxeira.util.DatabaseHelper;
import com.macaxeira.util.MyApp;

public interface ProdutoDAO {
	
	public void createProduto(String nome, int idCategoria);
	
	public List<Produto> readProduto();
	
	public void updateProduto(int id, String nomeAlt, int idCategoriaAlt);
	
	public void deleteProduto(int id);
	
	public List<Produto> buscarProdutoPorCategoria(int id);

}
