package com.example.demopc.service;


import com.example.demopc.domain.User;
import com.example.demopc.exception.UserNotFoundException;

public interface UserService {
    public User addUser(User user);
    public User findByEmailAndPassword(String email, String password) throws UserNotFoundException;


}
