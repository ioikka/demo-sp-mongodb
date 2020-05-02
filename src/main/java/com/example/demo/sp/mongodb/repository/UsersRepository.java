package com.example.demo.sp.mongodb.repository;

import com.example.demo.sp.mongodb.model.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, String> {
}
