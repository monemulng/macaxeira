package com.macaxeira.DAO;

import java.util.List;

import com.macaxeira.model.Categoria;
import com.macaxeira.model.Produto;

public interface CategoriaDAO {

	public void createCategoria(Categoria categ);
	
	public List<Categoria> readCategoria();
	
	public void updateCategoria(Categoria oldCateg, Categoria newCateg);
	
	public void deleteCategoria(Categoria categ);

}
