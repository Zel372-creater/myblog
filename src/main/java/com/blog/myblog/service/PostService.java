package com.blog.myblog.service;

import com.blog.myblog.models.Post;
import com.blog.myblog.reprository.PostReprository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostService {
    private final PostReprository postReprository;

    public void createPost(Post post){
        postReprository.save(post);
    }

    public void deletePost(Post post){
        Post posts = postReprository.findById(post.getId()).orElseThrow();
        postReprository.delete(posts);
    }

}
