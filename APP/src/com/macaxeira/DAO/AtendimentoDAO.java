package com.macaxeira.DAO;

import java.util.List;

import com.macaxeira.model.Atendimento;

public interface AtendimentoDAO {
	
	public void createAtendimento(Atendimento atend);
	
	public List<Atendimento> readAtendimento();
	
	public void updateAtendimento(Atendimento atend);
	
	public void deleteAtendimento(Atendimento atend);
	
	public List<Atendimento> buscarAtendimentoPorMesa (int mesaId);

}
