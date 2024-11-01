package com.example.collabcraft.Entities;


import com.example.collabcraft.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "tweets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tweets {

    @JsonSerialize(using = ObjectIdSerializer.class)
    @Id
    private ObjectId id;
    @NonNull
    private String content;
    private String author;
    private String domain;
    private LocalDate time;
    private List<String> applications=new ArrayList<>();



    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }


    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<String> getApplications() {
        return applications;
    }

    public void setApplications(List<String> applications) {
        this.applications = applications;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setContent(@NonNull String content) {
        this.content = content;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public ObjectId getId() {
        return id;
    }

    public @NonNull String getContent() {
        return content;
    }

    public LocalDate getTime() {
        return time;
    }
}
