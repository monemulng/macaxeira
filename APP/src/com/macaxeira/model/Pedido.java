package com.macaxeira.model;

import java.util.List;

public class Pedido {
	private String numMesa;
	private List<ItemPedido> itensPedido;
	
	public List<ItemPedido> getitensPedido() {
		return itensPedido;
	}
	public void setitensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public String toString() {
		return numMesa;
	}
}
