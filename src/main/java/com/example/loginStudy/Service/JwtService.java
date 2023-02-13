package com.example.loginStudy.Service;

import com.example.loginStudy.util.JWTSceret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class JwtService {
    @Autowired
    JWTSceret jwtSceret;

    public String jwtTest(HashMap <String,String> map){
        return jwtSceret.makeJwtToken(map);
    }
}

