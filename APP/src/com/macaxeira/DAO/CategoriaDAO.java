package com.macaxeira.DAO;

import java.util.List;

import com.macaxeira.model.Produto;

public interface CategoriaDAO {

	public List<Produto> buscarPorCategoria(int id);

}
