package com.macaxeira.model;

import java.io.Serializable;
import java.util.List;


public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private List<Ingrediente> ingredientes;
	private List<Adicional> adicionals;
	
	private Produto produto;

	public ItemPedido() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public List<Adicional> getAdicionals() {
		return this.adicionals;
	}

	public void setAdicionals(List<Adicional> adicionals) {
		this.adicionals = adicionals;
	}
	public double getPreco(){
		double precoAdicionais = 0;
		for(Adicional a:adicionals){
			precoAdicionais+= a.getPreco();
		}
		return produto.getPreco()+precoAdicionais;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String toString() {
		return produto.toString();
	}

}