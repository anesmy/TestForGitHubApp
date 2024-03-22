package org.example;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Date;


@Service
public class GitHubAuthService {

    @Value("${github.authentication.tokenExpirationPeriod}")
    private int expirationPeriod;

    @Value("${github.app.id}")
    private String appId;

    public String generateGitHubAppJwtToken() {
        return Jwts.builder()
                .issuer(appId)
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + expirationPeriod))
                .compact();
    }
}