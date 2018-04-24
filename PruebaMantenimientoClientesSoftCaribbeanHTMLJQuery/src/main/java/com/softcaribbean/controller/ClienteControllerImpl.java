package com.softcaribbean.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.softcaribbean.entity.Cliente;
import com.softcaribbean.service.ClienteService;

@CrossOrigin(origins = "http://localhost:8080/")
@Controller
@RequestMapping("WSCliente")
public class ClienteControllerImpl implements ClienteController {

	@Autowired
	ClienteService clienteService;
	
	private static Logger log = Logger.getLogger(ClienteControllerImpl.class);

	@Override
	@GetMapping("getAllClientes")
	public ResponseEntity<List<Cliente>> getAllClientes() {
		try {
			List<Cliente> listOfClientes = clienteService.getAllClientes();
			return new ResponseEntity<List<Cliente>>(listOfClientes, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	@GetMapping("getClienteById/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Integer id) {
		try {
			Cliente cliente = clienteService.getClienteById(id);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	@PostMapping("addCliente")
	public ResponseEntity<Void> addCliente(@RequestBody Cliente cliente, UriComponentsBuilder builder) {
		try {
			boolean flag = clienteService.addCliente(cliente);
			if (!flag) {
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	@PutMapping("updateCliente")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
		try {
			clienteService.updateCliente(cliente);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	@DeleteMapping("deleteCliente/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable("id") Integer id) {
		try {
			clienteService.deleteCliente(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}
}
