package com.macaxeira.DAO;

import java.util.List;

import com.macaxeira.model.Pedido;

public interface PedidoDAO {
	
	public void createPedido(Pedido ped);
	
	public List<Pedido> readPedido();
	
	public void updatePedido(Pedido ped);
	
	public void deletePedido(Pedido ped);
	
	public void salvarPedido(Pedido ped);

}
