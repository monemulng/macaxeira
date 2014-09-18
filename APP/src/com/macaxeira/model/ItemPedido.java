package com.macaxeira.model;

import java.io.Serializable;
import java.util.List;

public class ItemPedido implements Serializable{
	
	private Produto produto;
	private int idItemPedido;
	private List<Ingrediente> ingredientesExcluidos;
	private List<Adicional> adicionaisItem;
	
	public int getIdItemPedido() {
		return idItemPedido;
	}
	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto p) {
		this.produto = p;
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
}