package com.macaxeira.model;

import java.io.Serializable;
import java.util.List;


public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String nomeCliente;

	private List<ItemPedido> itemPedidos;

	private Atendente atendente;

	private Atendimento atendimento;

	private Cozinheiro cozinheiro;

	private Situacao situacao;

	public Pedido() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return this.nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public List<ItemPedido> getItemPedidos() {
		return this.itemPedidos;
	}

	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	public ItemPedido addItemPedido(ItemPedido itemPedido) {
		getItemPedidos().add(itemPedido);

		return itemPedido;
	}

	public ItemPedido removeItemPedido(ItemPedido itemPedido) {
		getItemPedidos().remove(itemPedido);

		return itemPedido;
	}

	public Atendente getAtendente() {
		return this.atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public Atendimento getAtendimento() {
		return this.atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public Cozinheiro getCozinheiro() {
		return this.cozinheiro;
	}

	public void setCozinheiro(Cozinheiro cozinheiro) {
		this.cozinheiro = cozinheiro;
	}

	public Situacao getSituacao() {
		return this.situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	public String toString() {
		return "Pedido: " + id + ", Situação: " + situacao;
	}

}