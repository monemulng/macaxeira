package com.macaxeira.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Mesa implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private List<Atendimento> atendimentos = new ArrayList<Atendimento>();

	public Mesa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Atendimento> getAtendimentos() {
		return this.atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Atendimento addAtendimento(Atendimento atendimento) {
		getAtendimentos().add(atendimento);
		atendimento.setMesa(this);

		return atendimento;
	}

	public Atendimento removeAtendimento(Atendimento atendimento) {
		getAtendimentos().remove(atendimento);
		atendimento.setMesa(null);

		return atendimento;
	}

	public String toString() {
		return "Mesa " + id;
	}
}