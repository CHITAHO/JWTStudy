package com.example.loginStudy.Controller;

import com.example.loginStudy.Service.JwtService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class JwtController {
    @Autowired
    JwtService jwtService;

    @ResponseBody
    @GetMapping("/")
    public String hi(){
        return "hi";
    }

    @ResponseBody
    @PostMapping("/jwtTest")
    public String jwtTest(@RequestBody HashMap<String,String> map){

        return jwtService.jwtTest(map);
    }

}
