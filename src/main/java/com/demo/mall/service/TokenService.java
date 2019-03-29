package com.demo.mall.service;

import com.demo.mall.entities.User;

public interface TokenService {

    public String getToken(String account,String pwd);

    public User explainToken(String token);

}
