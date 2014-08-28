package com.macaxeira.DAO;

import java.util.List;

import com.macaxeira.model.Categoria;
import com.macaxeira.model.Produto;

public interface CategoriaDAO {

	public void createCategoria(String nome, int idCategoria);
	
	public List<Categoria> readCategoria();
	
	public void updateCategoria(int id, String nomeAlt, int idCategoriaAlt);
	
	public void deleteCategoria(int id);

}
