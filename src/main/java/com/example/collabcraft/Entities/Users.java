package com.example.collabcraft.Entities;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Users {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String username;
    @NonNull
    private String name;
    @NonNull
    private String password;
    @Indexed(unique = true)
    private String collegeMail;
    private String branch;
    private int year;
    private String domain1;
    private String domain2;
    @DBRef
    private List<Tweets> userTweets=new ArrayList<>();

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public void setDomain2(String domain2) {
        this.domain2 = domain2;
    }

    public void setDomain1(String domain1) {
        this.domain1 = domain1;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setCollegeMail(String collegeMail) {
        this.collegeMail = collegeMail;
    }

    public void setUserTweets(List<Tweets> userTweets) {
        this.userTweets = userTweets;
    }

    public ObjectId getId() {
        return id;
    }

    public @NonNull String getUsername() {
        return username;
    }

    public @NonNull String getName() {
        return name;
    }

    public @NonNull String getPassword() {
        return password;
    }

    public String getCollegeMail() {
        return collegeMail;
    }

    public String getBranch() {
        return branch;
    }

    public int getYear() {
        return year;
    }

    public String getDomain1() {
        return domain1;
    }

    public List<Tweets> getUserTweets() {
        return userTweets;
    }

    public String getDomain2() {
        return domain2;
    }
}
