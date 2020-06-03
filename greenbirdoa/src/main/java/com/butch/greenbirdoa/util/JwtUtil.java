package com.butch.greenbirdoa.util;

import java.util.Base64;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/**
 * JWT工具类，创建私钥，加密解密等。
 */
@Component
public class JwtUtil {
    /**
     * 自定义密钥
     */
    private final static String SECRET_KEY_STR="bsIqMgs58mXxf+9/I+LV8Pji+/tVjaHDwwa7ytCd+iU=";
    /**
     * 把密钥编码
     */
    private final static SecretKey SECRET_KEY=Keys.hmacShaKeyFor(SECRET_KEY_STR.getBytes());

    /**
     * 获取一个随机生成的hs256密钥
     * @return 密钥字符串
     * 
     */
    public String getSecretKey_Str(){
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String encodeToString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        return encodeToString;
    }

    public String getJwtToken(){
        
        return Jwts.builder().setSubject("pan").signWith(SECRET_KEY).compact();
    }
}