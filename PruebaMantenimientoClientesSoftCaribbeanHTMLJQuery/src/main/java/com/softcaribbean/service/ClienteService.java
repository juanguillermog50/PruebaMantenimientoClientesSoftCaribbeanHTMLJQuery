package com.softcaribbean.service;

import java.util.List;

import com.softcaribbean.entity.Cliente;


public interface ClienteService {

	public List<Cliente> getAllClientes();

	public Cliente getClienteById(Integer id);

	public boolean addCliente(Cliente cliente);

	public boolean deleteCliente(int id);

	public boolean updateCliente(Cliente cliente);

}
