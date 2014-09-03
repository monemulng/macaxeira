package com.macaxeira.model;

import java.util.List;

public class Produto {

	private String nome;
	private int codProduto;
	private int codCategoria;
	private List<Ingrediente> ingredientes;
	
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}
	public int getCodCategoria() {
		return codCategoria;
	}
	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome;
	}
	
	public String toString() {
		return nome;
	}
	
}
