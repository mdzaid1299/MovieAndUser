package com.example.demopc.service;

import com.example.demopc.domain.User;
import com.example.demopc.domain.User;

import java.util.Map;

public interface SecurityTokenGenerate {
    Map<String,String> generateToken(User user);


}
