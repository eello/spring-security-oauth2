package com.example.oauthloginexample.oauth2;

import java.util.Map;

public abstract class CustomOAuth2User {

    private Map<String, Object> attributes;

    public CustomOAuth2User(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public abstract String getEmail();
    public abstract String getNickname();
}
