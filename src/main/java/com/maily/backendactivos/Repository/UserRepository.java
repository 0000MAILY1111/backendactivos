package com.maily.backendactivos.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.maily.backendactivos.Model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    User findByEmail(String email);
    Boolean existsByEmail(String email);
}