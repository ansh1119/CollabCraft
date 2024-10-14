package com.example.collabcraft.Controllers;


import com.example.collabcraft.Entities.Tweets;
import com.example.collabcraft.Entities.Users;
import com.example.collabcraft.Services.TweetService;
import com.example.collabcraft.Services.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
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
    public ResponseEntity<List<Tweets>> getAllTweetsOfUser(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        Users user= userService.findByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body(user.getUserTweets());
    }

    @PostMapping("/new-tweet")
    public ResponseEntity<String> createTweet(@RequestBody Tweets tweet){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        tweet.setAuthor(username);
        tweet.setTime(LocalDate.now());
        tweetService.createTweet(tweet,username);
        return ResponseEntity.status(HttpStatus.OK).body("tweet created successfully");
    }


    @GetMapping("/all-tweets")
    public ResponseEntity<List<Tweets>> getAllTweets(){
        return ResponseEntity.status(HttpStatus.OK).body(tweetService.getAllTweets());
    }

    @GetMapping("/{domain}")
    public ResponseEntity<List<Tweets>> getAllTweetsOfDomain(@PathVariable String domain){
        return ResponseEntity.status(HttpStatus.OK).body(tweetService.getTweetsByDomain(domain));
    }

    @PutMapping("/apply/{objectId}")
    public ResponseEntity<String> apply(@PathVariable ObjectId objectId){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        Tweets tweet= tweetService.getTweetById(objectId);
        if(tweet!=null){
               tweetService.createApplication(tweet,username);
           return ResponseEntity.status(HttpStatus.OK).body("application successful");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The Tweet Does Not Exist");
    }

    @GetMapping("/get-tweet-by-id")
    public Tweets getTweetById(@RequestBody ObjectId id){
        return tweetService.getTweetById(id);
    }
}
