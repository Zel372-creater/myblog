package com.blog.myblog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "post")
    private String post;

    @Column(name = "author")
    private String author;

    @Column(name = "text", columnDefinition = "text")
    private String text;

    public Post() {
    }

    public Post(String post, String author, String text) {
        this.post = post;
        this.author = author;
        this.text = text;
    }
}
