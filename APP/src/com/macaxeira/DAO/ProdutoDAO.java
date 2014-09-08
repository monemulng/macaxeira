package com.macaxeira.DAO;

import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.macaxeira.model.Categoria;
import com.macaxeira.model.Ingrediente;
import com.macaxeira.model.Produto;
import com.macaxeira.util.DatabaseHelper;
import com.macaxeira.util.MyApp;

public interface ProdutoDAO {
	
	public void createProduto(Produto prod);
	
	public List<Produto> readProduto();
	
	public void updateProduto(Produto prod);
	
	public void deleteProduto(Produto prod);
	
	public List<Produto> buscarProdutoPorCategoria(Categoria categ);
	
	public Produto buscarProdutoPorId(int id);

}
