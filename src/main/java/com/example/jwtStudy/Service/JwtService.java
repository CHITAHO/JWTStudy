package com.example.jwtStudy.Service;

import com.example.jwtStudy.util.JWTSecret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class JwtService {
    @Autowired
    JWTSecret jwtSecret;

    public String jwtTest(HashMap <String,String> map){
        return jwtSecret.makeJwtToken(map);
    }
}

