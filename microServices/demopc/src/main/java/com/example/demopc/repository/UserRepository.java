package com.example.demopc.repository;

import com.example.demopc.domain.User;
import com.example.demopc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,String> {
    public User findByEmailAndPassword(String email, String password);
}
