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
		return null;
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

		ArrayList<Produto> produtos = new ArrayList<Produto>();

		// prdutos disponíveis no banco

		// sanduiches
		Produto p1 = new Produto();
		Produto p2 = new Produto();
		Produto p3 = new Produto();
		Produto p4 = new Produto();

		// batatas
		Produto p5 = new Produto();
		Produto p6 = new Produto();
		Produto p7 = new Produto();
		Produto p8 = new Produto();

		if (categ.getNome() == "Sanduiche") {

			p1.setNome("X-Bacon");
			p1.setCodCategoria(1);
			p1.setCodProduto(1);
			produtos.add(p1);

			p2.setNome("Bacon Duplo");
			p2.setCodCategoria(1);
			p2.setCodProduto(2);
			produtos.add(p2);

			p3.setNome("X-Bacon Duplo");
			p3.setCodCategoria(1);
			p3.setCodProduto(3);
			produtos.add(p3);

			p4.setNome("X-Infarto");
			p4.setCodCategoria(1);
			p4.setCodProduto(4);
			produtos.add(p4);

		} else {

			p5.setNome("Batata Pequena");
			p5.setCodCategoria(2);
			p5.setCodProduto(5);
			produtos.add(p5);

			p6.setNome("Batata Média");
			p6.setCodCategoria(2);
			p6.setCodProduto(6);
			produtos.add(p6);

			p7.setNome("Batata Grande");
			p7.setCodCategoria(2);
			p7.setCodProduto(7);
			produtos.add(p7);

			p8.setNome("Balde de Batata");
			p8.setCodCategoria(2);
			p8.setCodProduto(8);
			produtos.add(p8);
			produtos.add(p8);
			produtos.add(p8);
			produtos.add(p8);

		}

		return produtos;

	}

	@Override
	public Produto buscarProdutoPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
