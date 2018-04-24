package com.softcaribbean.dao;

import java.util.List;

import com.softcaribbean.entity.Cliente;

public interface ClienteDAO {

	public List<Cliente> getAllClientes();

	public Cliente getClienteById(Integer id);

	public boolean addCliente(Cliente cliente);

	public void deleteCliente(int id);

	public boolean updateCliente(Cliente cliente);
}
