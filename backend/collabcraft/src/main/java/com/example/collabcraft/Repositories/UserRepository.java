package com.example.collabcraft.Repositories;

import com.example.collabcraft.Entities.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends MongoRepository<Users, ObjectId> {
    Users findByUsername(String username);
}
