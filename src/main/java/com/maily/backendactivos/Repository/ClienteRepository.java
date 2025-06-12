package com.maily.backendactivos.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.maily.backendactivos.Model.Cliente;


public interface ClienteRepository  extends MongoRepository<Cliente, Long>{
	public Cliente findByClienteId(Long clienteId);
	Boolean existsByClienteId(Long clienteId);
}