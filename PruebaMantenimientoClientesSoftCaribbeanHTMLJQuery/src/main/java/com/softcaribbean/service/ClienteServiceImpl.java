package com.softcaribbean.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softcaribbean.dao.ClienteDAO;
import com.softcaribbean.entity.Cliente;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteDAO clienteDAO;
	
	private static Logger log = Logger.getLogger(ClienteServiceImpl.class);

	@Override
	@Transactional
	public List<Cliente> getAllClientes() {
		return clienteDAO.getAllClientes();
	}

	@SuppressWarnings("null")
	@Override
	@Transactional
	public Cliente getClienteById(Integer id) {
		if ((id != null) || (id <= 0)) {
			return clienteDAO.getClienteById(id);
		}
		log.warn("El parámetro del método getClienteById no puede ser null.");
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public boolean addCliente(Cliente cliente) {
		if ((cliente != null) && (cliente.getFechaRegistro() != null)
				&& (cliente.getFechaBaja() != null) && (!cliente.getUsuario().equals(""))
				&&(cliente.getFechaRegistro().before(cliente.getFechaBaja()))) {
			cliente.getFechaRegistro().setDate(cliente.getFechaRegistro().getDate() + 1);
			cliente.getFechaBaja().setDate(cliente.getFechaBaja().getDate() + 1);
			return clienteDAO.addCliente(cliente);
		}
		log.warn("El cliente a agregar no cumple con los requisitos para ser guardado.");
		return false;
	}

	@Override
	@Transactional
	public boolean deleteCliente(int id) {
		if ((id > 0) && (clienteDAO.getClienteById(id) != null)) {
			clienteDAO.deleteCliente(id);
			return true;
		}
		log.warn("El parámetro del método deleteCliente no puede ser null.");
		return false;
	}

	@Override
	public boolean updateCliente(Cliente cliente) {
		if ((cliente != null) && (cliente.getId() > 0) && (cliente.getFechaRegistro() != null)
				&& (cliente.getFechaBaja() != null) && (!cliente.getUsuario().equals(""))) {
			return clienteDAO.updateCliente(cliente);
		}
		log.warn("El cliente a modificar no cumple con los requisitos para ser guardado.");
		return false;
	}

}
