package com.twh.door.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.twh.door.entity.POJO.DoorUser;

import java.util.Date;

public class TokenUtils {
    private static final String SECRET_KEY="twh";
    private static final Long EXPIRE_TIME=(((3600)*24)*30)*1000L;
    //生成Token
    public static String generateToken(DoorUser userBean){
        String token=null;
        try {
            Date expireAt=new Date(System.currentTimeMillis()+EXPIRE_TIME);

            token= JWT.create()
                    .withIssuer("auth0")
                    .withClaim("account",userBean.getId())
                    .withClaim("password",userBean.getPassWord())
                    .withClaim("code",userBean.getUserName())
                    .withExpiresAt(expireAt)
                    .sign(Algorithm.HMAC256(SECRET_KEY));
        }catch (IllegalArgumentException | JWTCreationException e){
            e.printStackTrace();
        }
        return token;
    }
    //验证token
    public static Boolean verify(String token){
        try {
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(SECRET_KEY)).withIssuer("auth0").build();
            DecodedJWT decodedJWT= jwtVerifier.verify(token);
        }catch (IllegalArgumentException | JWTVerificationException e){
            return false;
        }
        return true;
    }
    //从token中获取用户标识
    public static String getUserCode(String token){
        try {
            DecodedJWT jwt=JWT.decode(token);
            return jwt.getClaim("code").asString();
        }catch (JWTDecodeException e){
            return null;
        }
    }

}
