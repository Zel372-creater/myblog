package com.blog.myblog.conrollers;

import com.blog.myblog.models.Post;
import com.blog.myblog.reprository.PostReprository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {

    @Autowired
    private final PostReprository postReprository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/blog")
    public String blog(Model model){
        Iterable<Post> posts = postReprository.findAll();
        model.addAttribute("posts", posts);
        return "blog";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
