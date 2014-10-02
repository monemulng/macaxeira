package com.macaxeira.model;

import java.io.Serializable;
import java.util.List;


public class Atendimento implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Mesa mesa;
	private Situacao situacao;
	private List<Pedido> pedidos;
	private Pedido pedidoAtual;

	public Atendimento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mesa getMesa() {
		return this.mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Situacao getSituacao() {
		return this.situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setAtendimento(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setAtendimento(null);

		return pedido;
	}
	
	public String toString() {
		return "Mesa " + mesa.getId() + ", Situação :" + situacao;
	}

	public Pedido getPedidoAtual() {
		return pedidoAtual;
	}

	public void setPedidoAtual(Pedido pedidoAtual) {
		this.pedidoAtual = pedidoAtual;
	}

}