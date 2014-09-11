package com.macaxeira.model;

import java.io.Serializable;
import java.util.List;

public class Produto implements Serializable {

	private String nome;
	private int codProduto;
	private int codCategoria;
	private double preco;
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	private List<Ingrediente> ingredientes;
	private List<Adicional> adicionais;
	
	public List<Adicional> getAdicionais() {
		return adicionais;
	}
	public void setAdicionais(List<Adicional> adicionais) {
		this.adicionais = adicionais;
	}
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
	
}
