package com.example.oauthloginexample.entity;

import com.example.oauthloginexample.oauth2.CustomOAuth2User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class User {

    private Long id;
    private String email;
    private String nickname;

    public User() {}

    @Builder
    public User(Long id, String email, String nickname) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
    }

    public static User of(CustomOAuth2User oAuth2User) {
        User user = new User();
        user.email = oAuth2User.getEmail();
        user.nickname = oAuth2User.getNickname();
        return user;
    }

    public void update(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
}
