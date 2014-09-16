package com.macaxeira.DAO;


import java.util.List;

import com.macaxeira.model.Categoria;
import com.macaxeira.model.Produto;

public interface ProdutoDAO {
	
	public void createProduto(Produto prod);
	
	public List<Produto> readProduto();
	
	public void updateProduto(Produto prod);
	
	public void deleteProduto(Produto prod);
	
	public Produto buscarProdutoPorId(int id);
	
	public List<Produto> buscarProdutoPorCategoria(Categoria categ);

}
