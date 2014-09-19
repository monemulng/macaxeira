package com.macaxeira.model;

import java.io.Serializable;

public class Adicional implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
	private int id;
	private double preco;
	private boolean isChecked = false;
	public Adicional(){
		super();
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
}