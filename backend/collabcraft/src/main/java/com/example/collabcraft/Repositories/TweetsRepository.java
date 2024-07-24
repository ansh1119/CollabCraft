package com.example.collabcraft.Repositories;

import com.example.collabcraft.Entities.Tweets;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetsRepository extends MongoRepository<Tweets, ObjectId> {
    List<Tweets> findByDomain(String domain);
}
