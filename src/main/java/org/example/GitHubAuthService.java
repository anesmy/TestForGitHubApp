package org.example;

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
