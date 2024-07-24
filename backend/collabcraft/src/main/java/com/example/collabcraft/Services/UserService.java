package com.example.collabcraft.Services;

import com.example.collabcraft.Entities.Users;
import com.example.collabcraft.Repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public void newUser(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
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
}
