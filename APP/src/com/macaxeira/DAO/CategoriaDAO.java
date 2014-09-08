package com.macaxeira.DAO;

import java.util.List;

import com.macaxeira.model.Categoria;

public interface CategoriaDAO {

	public void createCategoria(Categoria categ);
	
	public List<Categoria> readCategoria();
	
	public void updateCategoria(Categoria categ);
	
	public void deleteCategoria(Categoria categ);
	
	public Categoria buscarCategoriaPorId (int id);

}
