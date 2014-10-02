package com.macaxeira.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


public class Ingrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private Timestamp dataUpdate;

	private byte del;

	private String nome;

	private List<ItemPedido> itemPedidos;

	private List<Produto> produtos;

	public Ingrediente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDataUpdate() {
		return this.dataUpdate;
	}

	public void setDataUpdate(Timestamp dataUpdate) {
		this.dataUpdate = dataUpdate;
	}

	public byte getDel() {
		return this.del;
	}

	public void setDel(byte del) {
		this.del = del;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ItemPedido> getItemPedidos() {
		return this.itemPedidos;
	}

	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public String toString() {
		return nome;
	}

}