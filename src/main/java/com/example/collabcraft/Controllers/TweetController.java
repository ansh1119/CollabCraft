package com.example.collabcraft.Controllers;


import com.example.collabcraft.Entities.Tweets;
import com.example.collabcraft.Entities.Users;
import com.example.collabcraft.Services.TweetService;
import com.example.collabcraft.Services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    TweetService tweetService;

    @Autowired
    UserService userService;

    @GetMapping
    public List<Tweets> getAllTweetsOfUser(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        Users user= userService.findByUsername(username);
        return user.getUserTweets();
    }

    @PostMapping("/new-tweet")
    public void createTweet(@RequestBody Tweets tweet){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        tweet.setTime(LocalDate.now());
        tweetService.createTweet(tweet,username);
    }

    @GetMapping("/all-tweets")
    public List<Tweets> getAllTweets(){
        return tweetService.getAllTweets();
    }

    @GetMapping("/{domain}")
    public List<Tweets> getAllTweetsOfDomain(@PathVariable String domain){
        return tweetService.getTweetsByDomain(domain);
    }

    @PutMapping("/apply/{objectId}")
    public void apply(@PathVariable ObjectId objectId){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        Users user=userService.findByUsername(username);
        Tweets tweet= tweetService.getTweetById(objectId);
        if(tweet!=null){
           tweet.getApplications().add(user);
           tweetService.updateTweet(tweet);
        }
    }
}
