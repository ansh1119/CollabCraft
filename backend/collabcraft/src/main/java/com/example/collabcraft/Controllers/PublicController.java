package com.example.collabcraft.Controllers;


import com.example.collabcraft.Entities.Users;
import com.example.collabcraft.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    UserService userService;

    @PostMapping("/create-user")
    public void createUser(@RequestBody Users user){
        userService.newUser(user);
    }
}
