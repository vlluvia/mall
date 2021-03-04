package com.demo.mall.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.demo.mall.entities.User;
import com.demo.mall.mapper.UserDao;
import com.demo.mall.service.TokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TokenServiceImpl implements TokenService {

    @Resource
    public UserDao userDao;

    @Override
    public String getToken(String account, String pwd) {
        String token = "";
        token = JWT.create()
                .withClaim("account", account)
                .withClaim("time", System.currentTimeMillis())
                .withClaim("exptime", 1000 * 1 * 60 * 60)
                .sign(Algorithm.HMAC256(pwd));
        return token;
    }

    @Override
    public User explainToken(String token) {
        String account = JWT.decode(token).getClaim("account").asString();
        User user = userDao.findUserByAccount(account);
        if (user != null) {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            try{
                jwtVerifier.verify(token);
                return user;
            }catch (Exception e){
                return null;
            }
        } else {
            return null;
        }

    }
}
