package com.softcaribbean.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softcaribbean.entity.Cliente;
import com.softcaribbean.repository.ClienteRepository;

@Repository
public class ClienteDAOImpl implements ClienteDAO {
	@Autowired
	ClienteRepository clienteRepository;
	
	private static Logger log = Logger.getLogger(ClienteDAOImpl.class);

	@Override
	@Transactional
	public List<Cliente> getAllClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Iterable<Cliente> clientesIterable = clienteRepository.findAll();
		Iterator<Cliente> clientesIterator = clientesIterable.iterator();
		while (clientesIterator.hasNext()) {
			clientes.add(clientesIterator.next());
		}
		return clientes;
	}

	@Override
	@Transactional
	public Cliente getClienteById(Integer id) {
		return clienteRepository.findById(id).get();
	}

	@Override
	@Transactional
	public synchronized boolean addCliente(Cliente cliente) {
		if (clienteRepository.save(cliente) != null) {
			return true;
		}
		log.warn("No se pudo guardar el cliente.");
		return false;
	}

	@Override
	@Transactional
	public void deleteCliente(int id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public boolean updateCliente(Cliente cliente) {
		if (clienteRepository.save(cliente) != null) {
			return true;
		}
		log.warn("No se pudo guardar el cliente.");
		return false;
	}

}