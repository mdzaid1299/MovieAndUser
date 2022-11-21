package com.example.demopc.controller;

import com.example.demopc.domain.User;
import com.example.demopc.exception.UserNotFoundException;
import com.example.demopc.service.UserService;
import com.example.demopc.service.SecurityTokenGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
    private  UserService userService;
    private SecurityTokenGenerate securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerate securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFoundException {
        Map<String, String> map = null;

        try {
            User user1 = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
            if (user1.getEmail().equals(user.getEmail())) {
                map = securityTokenGenerator.generateToken(user);

            }

            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        } catch (Exception se) {
            se.printStackTrace();
            return new ResponseEntity<>("Other exception", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        User usercreate = userService.addUser(user);
        return new ResponseEntity(usercreate, HttpStatus.CREATED);
    }
}
