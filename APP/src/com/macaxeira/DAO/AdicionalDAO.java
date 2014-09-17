package com.macaxeira.DAO;

import java.util.List;

import com.macaxeira.model.Adicional;
import com.macaxeira.model.Produto;

public interface AdicionalDAO {
	
	public void createAdicional(Adicional adic);
	
	public List<Adicional> readAdicional();
	
	public void updateAdicional(Adicional adic);
	
	public void deleteAdicional(Adicional adic);
	
	public List<Adicional> buscarAdicionalPorProduto(Produto prod);

}
