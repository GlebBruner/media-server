package ua.nure.mediaserver.configuration.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class JwtProvider {


    @Value("app.jwtSecret")
    private String secret;

    @Value("app.jwtExpirationInMs")
    private int jwtExpirationInMs;


    public String generateJwt() {

    }


}
