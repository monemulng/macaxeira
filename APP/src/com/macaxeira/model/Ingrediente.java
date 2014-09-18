package com.macaxeira.model;

import java.io.Serializable;


public class Ingrediente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int codIngrediente;
	public Ingrediente(){
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
	
	public int getCodIngrediente() {
		return codIngrediente;
	}

	public void setCodIngrediente(int cod) {
		this.codIngrediente = cod;
	}

	public String toString() {
		return nome;
	}
}
