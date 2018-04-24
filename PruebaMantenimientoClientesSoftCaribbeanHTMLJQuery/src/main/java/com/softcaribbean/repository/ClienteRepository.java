package com.softcaribbean.repository;

import org.springframework.data.repository.CrudRepository;

import com.softcaribbean.entity.Cliente;


public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
