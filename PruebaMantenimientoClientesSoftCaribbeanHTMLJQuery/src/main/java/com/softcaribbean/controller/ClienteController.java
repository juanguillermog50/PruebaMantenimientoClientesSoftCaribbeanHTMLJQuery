package com.softcaribbean.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.softcaribbean.entity.Cliente;

public interface ClienteController {

	public ResponseEntity<List<Cliente>> getAllClientes();

	public ResponseEntity<Cliente> getClienteById(Integer id);

	public ResponseEntity<Void> addCliente(Cliente cliente, UriComponentsBuilder builder);

	public ResponseEntity<Cliente> updateCliente(Cliente cliente);

	public ResponseEntity<Void> deleteCliente(Integer id);

}
