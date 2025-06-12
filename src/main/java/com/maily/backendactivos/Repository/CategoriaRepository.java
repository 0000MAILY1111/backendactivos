package com.maily.backendactivos.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.maily.backendactivos.Model.Categoria;

public interface CategoriaRepository  extends MongoRepository<Categoria, String>{
	Categoria findBy_id(String _id);
}