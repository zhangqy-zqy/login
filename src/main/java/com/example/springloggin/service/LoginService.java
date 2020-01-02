package com.example.springloggin.service;

import com.example.springloggin.common.LoginInfoCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {
    @Resource
    public LoginInfoCache loginInfoCache;

    public void putSystemMap(){
        loginInfoCache.updateSubSystemMap("login","/root/login");
    }

}
