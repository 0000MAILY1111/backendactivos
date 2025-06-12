package com.maily.backendactivos.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.maily.backendactivos.Model.Activo;

public interface ActivoRepository  extends MongoRepository<Activo, String>{
	Activo findBy_id(String activoId);
}