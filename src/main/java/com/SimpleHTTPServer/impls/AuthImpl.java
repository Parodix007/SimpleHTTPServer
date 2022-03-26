package com.SimpleHTTPServer.impls;

import com.SimpleHTTPServer.interfaces.Auth;


public class AuthImpl implements Auth {
    private static AuthImpl instance;

    private AuthImpl(){}

    public static AuthImpl getInstance() {
        if (instance != null) return instance;
        instance = new AuthImpl();
        return instance;
    }

    @Override
    public boolean doAuth(String token) {
        String s = token.split(" ")[1];
        return s != null && s.equals("xyz");
    }
}
