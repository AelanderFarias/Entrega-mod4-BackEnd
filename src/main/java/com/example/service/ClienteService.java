package com.example.service;

import java.util.List;

import com.example.model.Cliente;


public interface ClienteService {
	Cliente saveCliente(Cliente cliente);
	List<Cliente> getAllClientes();
	Cliente getClienteById(long id);
	Cliente updateCliente(Cliente cliente, long id);
	void deleteCliente(long id);
}
