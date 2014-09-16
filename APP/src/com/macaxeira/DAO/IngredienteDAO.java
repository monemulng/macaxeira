package com.macaxeira.DAO;

import java.util.List;

import com.macaxeira.model.Ingrediente;
import com.macaxeira.model.Produto;


public interface IngredienteDAO {
	
	public void createIngrediente(Ingrediente ingr);
	
	public List<Ingrediente> readIngrediente();
	
	public void updateIngrediente(Ingrediente ingr);
	
	public void deleteIngrediente(Ingrediente ingr);
	
	public List<Ingrediente> buscarIngredientePorProduto(Produto prod);

}
