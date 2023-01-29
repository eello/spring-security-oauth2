package com.example.oauthloginexample.oauth2;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public abstract class CustomOAuth2User implements OAuth2User {

    private Map<String, Object> attributes;
    private Collection<? extends GrantedAuthority> authorities;
    private String name;

    public CustomOAuth2User(Map<String, Object> attributes, Collection<? extends GrantedAuthority> authorities, String name) {
        this.attributes = attributes;
        this.authorities = authorities;
        this.name = name;
    }

    public abstract String getEmail();
    public abstract String getNickname();

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return getEmail();
    }
}
