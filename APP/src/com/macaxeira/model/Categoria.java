package com.macaxeira.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private int codCategoria;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Categoria(int cod, String nome){
		this.codCategoria = cod;
		this.nome = nome;
	}
	public Categoria(){
		super();
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public int getCodCategoria() {
		return codCategoria;
	}
	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return nome;
	}
}
