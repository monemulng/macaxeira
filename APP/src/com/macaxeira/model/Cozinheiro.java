package com.macaxeira.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


public class Cozinheiro implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private Timestamp dataUpdate;

	private byte del;

	private String nome;

	private Usuario usuario;

	private List<Pedido> pedidos;

	public Cozinheiro() {
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setCozinheiro(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setCozinheiro(null);

		return pedido;
	}
	
	public String toString() {
		return nome;
	}

}