package com.example.loginStudy.util;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

@Component
public class JWTSceret {
    private static final int MINUTES = 24*60*60*1000;
    PrivateKey privateKey;
    PublicKey publicKey;

    public JWTSceret() throws NoSuchAlgorithmException {
        KeyPair keyPair = KeyPairGenerator.getInstance(SignatureAlgorithm.RS256.getFamilyName()).generateKeyPair();
        privateKey = keyPair.getPrivate();
        publicKey = keyPair.getPublic();
    }
    public String makeJwtToken(HashMap <String,String> map){
        System.out.println(map);
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + MINUTES);

        JwtBuilder builder = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // (1)
                .setIssuer("") // (2)
                .setIssuedAt(now) // (3)
                .setExpiration(expireDate); // (4)
//        HashMap<String, String> map = new HashMap<>();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = String.valueOf(iterator.next());
            builder.claim(key, map.get(key));
        }
        return builder.signWith(privateKey,SignatureAlgorithm.RS256)
                .compact();
    }
}
