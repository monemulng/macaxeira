package com.macaxeira.model;

import java.util.List;

public class ItemPedido extends Produto{
	private List<Produto> produtos;
	private List<Ingrediente> ingredientesExcluidos;
	private List<Adicional> adicionaisItem;
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Ingrediente> getingredientesExcluidos() {
		return ingredientesExcluidos;
	}
	public void setingredientesExcluidos(List<Ingrediente> ingredientesExcluidos) {
		this.ingredientesExcluidos = ingredientesExcluidos;
	}
	
	public List<Adicional> getadicionaisItem() {
		return adicionaisItem;
	}
	public void setadicionaisItem(List<Adicional> adicionaisItem) {
		this.adicionaisItem = adicionaisItem;
	}
}