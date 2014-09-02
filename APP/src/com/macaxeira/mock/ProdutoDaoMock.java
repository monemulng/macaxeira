package com.macaxeira.mock;

import java.util.ArrayList;
import java.util.List;

import com.macaxeira.DAO.ProdutoDAO;
import com.macaxeira.model.Categoria;
import com.macaxeira.model.Produto;

public class ProdutoDaoMock implements ProdutoDAO {
	
	

	@Override
	public void createProduto(Produto prod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produto> readProduto() {
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		Produto p1 = new Produto();
		Produto p2 = new Produto();
		
		
		p1.setNome("Hamburguer");
		p1.setCodCategoria(1);
		p1.setCodProduto(1);		
		produtos.add(p1);
		
		p2.setNome("Batata P");
		p2.setCodCategoria(2);
		p2.setCodProduto(5);
		System.out.println(produtos);
		return produtos;
		
	}

	@Override
	public void updateProduto(Produto prod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduto(Produto prod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produto> buscarProdutoPorCategoria(Categoria categ) {
		// TODO Auto-generated method stub
		return null;
	}

}
