package com.maily.backendactivos.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.maily.backendactivos.Model.Alquiler;

public interface AlquilerRepository  extends MongoRepository<Alquiler, Long>{
	Alquiler findByAlquilerId(Long alquilerId);
}