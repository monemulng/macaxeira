package com.macaxeira.model;

import java.io.Serializable;
import java.util.List;

public class ItemPedido implements Serializable{
	
	private Produto produto;
	private int idItemPedido;
	public int getIdItemPedido() {
		return idItemPedido;
	}
	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	private List<Ingrediente> ingredientesExcluidos;
	private List<Adicional> adicionaisItem;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto p) {
		this.produto = produto;
	}
	public List<Ingrediente> getIngredientesExcluidos() {
		return ingredientesExcluidos;
	}
	public void setIngredientesExcluidos(List<Ingrediente> ingredientesExcluidos) {
		this.ingredientesExcluidos = ingredientesExcluidos;
	}
	public List<Adicional> getAdicionaisItem() {
		return adicionaisItem;
	}
	public void setAdicionaisItem(List<Adicional> adicionaisItem) {
		this.adicionaisItem = adicionaisItem;
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