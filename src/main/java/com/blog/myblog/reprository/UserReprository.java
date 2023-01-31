package com.blog.myblog.reprository;

import com.blog.myblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReprository extends JpaRepository<User, Long> {
}
