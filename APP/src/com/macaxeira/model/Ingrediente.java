package com.macaxeira.model;

public class Ingrediente {
	private String nome;
	private int codIngrediente;
	
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
