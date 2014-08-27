package com.macaxeira.DAO;

import java.util.List;

import com.macaxeira.model.Ingrediente;

public interface ProdutoDAO {
	public List<Ingrediente> buscarIngredientes(int codProduto);
}
