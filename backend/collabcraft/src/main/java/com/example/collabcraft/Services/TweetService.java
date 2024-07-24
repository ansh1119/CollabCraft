package com.example.collabcraft.Services;

import com.example.collabcraft.Entities.Tweets;
import com.example.collabcraft.Entities.Users;
import com.example.collabcraft.Repositories.TweetsRepository;
import com.example.collabcraft.Repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TweetService {

    @Autowired
    TweetsRepository tweetsRepository;

    @Autowired
    UserRepository userRepository;

    public Tweets getTweetById(ObjectId id){
        return tweetsRepository.findById(id).orElse(null);
    }

    public List<Tweets> getAllTweets(){
        return tweetsRepository.findAll();
    }

    public void createTweet(Tweets tweet, String username){
        Users user= userRepository.findByUsername(username);
        Tweets saved=tweetsRepository.save(tweet);
        user.getUserTweets().add(saved);
        userRepository.save(user);
    }

    public List<Tweets> getTweetsByDomain(String domain){
        return tweetsRepository.findByDomain(domain);
    }

    public void updateTweet(Tweets tweet){
        tweetsRepository.save(tweet);
    }
}
