package com.macaxeira.mock;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.macaxeira.DAO.CategoriaDAO;
import com.macaxeira.model.Categoria;

public class CategoriaDaoMock implements CategoriaDAO {	
	
	
	@Override
	public void createCategoria(Categoria categ) {		
				
	}

	@Override
	public List<Categoria> readCategoria() {
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		
		Categoria categ = new Categoria();
		Categoria categ2 = new Categoria();
		
		
		categ.setCodCategoria(1);
		categ.setNome("Sanduiches");	
		categorias.add(categ);
		
		categ2.setCodCategoria(2);
		categ2.setNome("Batatas");
		categorias.add(categ2);
		System.out.println(categorias);
		return categorias; 
	}

	@Override
	public void updateCategoria(Categoria categ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategoria(Categoria categ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categoria buscarCategoriaPorId(int id) {
		
		Categoria categ = new Categoria();
		
		categ.setCodCategoria(id);
		
		categ.setNome("Categoria Teste");
		ProdutoDaoMock prodDao = new ProdutoDaoMock();
		categ.setProdutos(prodDao.buscarProdutoPorCategoria(categ));
		
		return categ;
	}
	

}
