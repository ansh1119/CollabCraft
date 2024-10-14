package com.example.collabcraft.Services;

import com.example.collabcraft.Entities.Users;
import com.example.collabcraft.Repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JWTService service;

    private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public void newUser(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    public String verify(Users user){
        System.out.println("i am now here");
        Authentication authentication=
                authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
                );
        System.out.println("i am now here");
        if(authentication.isAuthenticated()) {
            System.out.println("success");
            return service.generateToken(user.getUsername());
        }
        else {
            System.out.println("failure");
            return "Failure";
        }
    }

    public List<Users> getAllUsers(){
        return userRepo.findAll();
    }

    public Users findByUsername(String username){
        return userRepo.findByUsername(username);
    }

    public void deleteByUsername(String username){
        Users user=userRepo.findByUsername(username);
        userRepo.deleteById(user.getId());
    }


    public Users getUserByUserId(ObjectId id){
        return userRepo.findById(id).orElse(null);
    }
}
