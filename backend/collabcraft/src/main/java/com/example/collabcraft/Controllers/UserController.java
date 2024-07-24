package com.example.collabcraft.Controllers;


import com.example.collabcraft.Entities.Tweets;
import com.example.collabcraft.Entities.Users;
import com.example.collabcraft.Services.TweetService;
import com.example.collabcraft.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TweetService tweetService;

//    @GetMapping("/all")
//    public List<Users> getAllUsers(){
//        return userService.getAllUsers();
//    }

    @PutMapping("/update-user")
    public void updateUser(@RequestBody Users user){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        Users userInDb=userService.findByUsername(username);
            userInDb.setUsername(user.getUsername());
            userInDb.setPassword(user.getPassword());
            userService.newUser(userInDb);

    }

    @DeleteMapping("/delete-user")
    public void deleteUser(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        userService.deleteByUsername(username);
    }


}
