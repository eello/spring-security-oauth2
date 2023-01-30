package com.example.oauthloginexample.service;

import com.example.oauthloginexample.entity.User;
import com.example.oauthloginexample.jwt.JwtProvider;
import com.example.oauthloginexample.oauth2.CustomOAuth2User;
import com.example.oauthloginexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;


    public String reissueAccessToken(String oldAccessToken, String refreshToken) {
        if (!jwtProvider.validateToken(refreshToken)) {
            throw new RuntimeException("invalid refresh token");
        }

        Authentication authentication = jwtProvider.getAuthentication(oldAccessToken);
        String email = ((CustomOAuth2User) authentication.getPrincipal()).getEmail();

        log.info("access token reissue 대상: {}", email);

        User findUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Not found user"));

        if (!refreshToken.equals(findUser.getRefreshToken())) {
            throw new RuntimeException("invalid refresh token");
        }

        return jwtProvider.createAccessToken(authentication);
    }
}
