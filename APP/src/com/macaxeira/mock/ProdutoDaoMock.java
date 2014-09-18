package com.macaxeira.mock;


import java.util.ArrayList;
import java.util.List;

import android.widget.Toast;

import com.macaxeira.DAO.ProdutoDAO;
import com.macaxeira.model.Adicional;
import com.macaxeira.model.Categoria;
import com.macaxeira.model.Ingrediente;
import com.macaxeira.model.Produto;
import com.macaxeira.util.MyApp;

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
		
			p1.setNome("X-Bacon");
			p1.setCodCategoria(1);
			p1.setCodProduto(1);

			p2.setNome("Bacon Duplo");
			p2.setCodCategoria(1);
			p2.setCodProduto(2);

			p3.setNome("X-Bacon Duplo");
			p3.setCodCategoria(1);
			p3.setCodProduto(3);

			p4.setNome("X-Infarto");
			p4.setCodCategoria(1);
			p4.setCodProduto(4);

		

			p5.setNome("Batata Pequena");
			p5.setCodCategoria(2);
			p5.setCodProduto(5);

			p6.setNome("Batata Média");
			p6.setCodCategoria(2);
			p6.setCodProduto(6);

			p7.setNome("Batata Grande");
			p7.setCodCategoria(2);
			p7.setCodProduto(7);

			p8.setNome("Balde de Batata");
			p8.setCodCategoria(2);
			p8.setCodProduto(8);

	
		

		List<Ingrediente> listIngrediente = new ArrayList<Ingrediente>();
		List<Adicional> listAdicional = new ArrayList<Adicional>();
		
		Ingrediente i = new Ingrediente();
		i.setNome("bacon");
		Ingrediente i2 = new Ingrediente();
		i2.setNome("pão");
		
		listIngrediente.add(i);
		listIngrediente.add(i);
		listIngrediente.add(i);
		listIngrediente.add(i);
		listIngrediente.add(i2);
		listIngrediente.add(i2);
		listIngrediente.add(i2);
		listIngrediente.add(i2);

		Adicional a = new Adicional();
		a.setNome("bacooon");
		a.setPreco(2.50);
		Adicional a2 = new Adicional();
		a2.setNome("bacooon x 2");
		a2.setPreco(5.0);
		Adicional a3 = new Adicional();
		a3.setNome("bacooon x 50");
		a3.setPreco(1000.0);
		
		listAdicional.add(a);
		listAdicional.add(a);
		listAdicional.add(a);
		listAdicional.add(a);
		listAdicional.add(a2);
		listAdicional.add(a2);
		listAdicional.add(a3);
		listAdicional.add(a3);
		listAdicional.add(a3);
		listAdicional.add(a3);

		p1.setAdicionais(listAdicional);
		p1.setIngredientes(listIngrediente);
		
		p2.setAdicionais(listAdicional);
		p2.setIngredientes(listIngrediente);
		
		p3.setAdicionais(listAdicional);
		p3.setIngredientes(listIngrediente);
		
		p4.setAdicionais(listAdicional);
		p4.setIngredientes(listIngrediente);
		
		p5.setAdicionais(listAdicional);
		p5.setIngredientes(listIngrediente);
		
		p6.setAdicionais(listAdicional);
		p6.setIngredientes(listIngrediente);
		
		p7.setAdicionais(listAdicional);
		p7.setIngredientes(listIngrediente);
		
		p8.setAdicionais(listAdicional);
		p8.setIngredientes(listIngrediente);
		
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
		produtos.add(p4);
		produtos.add(p5);
		produtos.add(p6);
		produtos.add(p7);
		produtos.add(p8);
		produtos.add(p8);
		produtos.add(p8);
		produtos.add(p8);

		return produtos;

	}

	@Override
	public Produto buscarProdutoPorId(int id) {
		if(id == 1){
		return null;
		}
		Produto p1 = new Produto();
		p1.setNome("X-Bacon");
		p1.setCodCategoria(1);
		p1.setCodProduto(1);
		List<Ingrediente> listIngrediente = new ArrayList<Ingrediente>();
		List<Adicional> listAdicional = new ArrayList<Adicional>();
		
		Ingrediente i = new Ingrediente();
		i.setNome("bacon");
		Ingrediente i2 = new Ingrediente();
		i2.setNome("pão");
		
		listIngrediente.add(i);
		listIngrediente.add(i);
		listIngrediente.add(i);
		listIngrediente.add(i);
		listIngrediente.add(i2);
		listIngrediente.add(i2);
		listIngrediente.add(i2);
		listIngrediente.add(i2);

		Adicional a = new Adicional();
		a.setNome("bacooon");
		a.setPreco(2.50);
		Adicional a2 = new Adicional();
		a2.setNome("bacooon x 2");
		a2.setPreco(5.0);
		Adicional a3 = new Adicional();
		a3.setNome("bacooon x 50");
		a3.setPreco(1000.0);
		
		listAdicional.add(a);
		listAdicional.add(a);
		listAdicional.add(a);
		listAdicional.add(a);
		listAdicional.add(a2);
		listAdicional.add(a2);
		listAdicional.add(a3);
		listAdicional.add(a3);
		listAdicional.add(a3);
		listAdicional.add(a3);

		p1.setAdicionais(listAdicional);
		p1.setIngredientes(listIngrediente);
		
		return p1;
		
	}

}
