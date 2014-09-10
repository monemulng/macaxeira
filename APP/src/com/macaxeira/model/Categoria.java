package com.macaxeira.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categoria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Categoria(int cod, String nome){
		this.id = cod;
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
	
	public int getId() {
		return id;
	}
	public void setId(int codCategoria) {
		this.id = codCategoria;
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
