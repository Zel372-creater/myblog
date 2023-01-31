package com.blog.myblog.reprository;

import com.blog.myblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostReprository extends JpaRepository<Post, Long> {
}
