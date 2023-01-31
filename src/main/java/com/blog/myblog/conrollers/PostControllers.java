package com.blog.myblog.conrollers;

import com.blog.myblog.models.Post;
import com.blog.myblog.reprository.PostReprository;
import com.blog.myblog.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
@AllArgsConstructor
public class PostControllers {

    private final PostService postService;
    private final PostReprository postReprository;

    @GetMapping("/add")
    public String addPostGet(){
        return "add-post";
    }

    @PostMapping("/add")
    public String addPost(@RequestParam String post,
                   @RequestParam String name,
                   @RequestParam String text) {
        Post posts = new Post(post, name, text);
        postService.createPost(posts);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/info")
    public String infoPost(@PathVariable(value = "id") Long id,
                           Model model){
        Optional<Post> posts = postReprository.findById(id);
        List<Post> post = new ArrayList<>();
        posts.ifPresent(post :: add);
        model.addAttribute("post", post);
        return "info-post";
    }

    @PostMapping("/{id}/delete")
    public String deletePost(@PathVariable(value = "id") Long id){
        Post post = postReprository.findById(id).orElseThrow();
        postService.deletePost(post);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String editPostGet(@PathVariable(value = "id") Long id, Model model){
        Optional<Post> posts = postReprository.findById(id);
        List<Post> post = new ArrayList<>();
        posts.ifPresent(post :: add);
        model.addAttribute("post", post);
        return "edit-post";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@PathVariable(value = "id") Long id,
                           @RequestParam String postEdit,
                           @RequestParam String nameEdit,
                           @RequestParam String textEdit){
        Post posts = postReprository.findById(id).orElseThrow();
        posts.setPost(postEdit);
        posts.setAuthor(nameEdit);
        posts.setText(textEdit);
        postService.createPost(posts);
        return "redirect:/blog";
    }
}
