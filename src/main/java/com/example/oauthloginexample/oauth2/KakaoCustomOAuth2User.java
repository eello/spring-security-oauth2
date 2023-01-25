package com.example.oauthloginexample.oauth2;

import lombok.Getter;

import java.util.Map;

@Getter
public class KakaoCustomOAuth2User extends CustomOAuth2User {

    private Map<String, Object> account;
    private Map<String, Object> profile;

    public KakaoCustomOAuth2User(Map<String, Object> attributes) {
        super(attributes);
        this.account = (Map<String, Object>) attributes.get("kakao_account");
        this.profile = (Map<String, Object>) account.get("profile");
    }

    @Override
    public String getEmail() {
        return (String) account.get("email");
    }

    @Override
    public String getNickname() {
        return (String) profile.get("nickname");
    }
}
