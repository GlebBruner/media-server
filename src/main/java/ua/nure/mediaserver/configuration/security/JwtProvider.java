package ua.nure.mediaserver.configuration.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ua.nure.mediaserver.domain.PrincipalDetails;

import java.security.Key;
import java.util.Date;


@Component
public class JwtProvider {


    @Value("${app.jwtSecret}")
    private String secretKey;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;


    public String generateJwt(Authentication authentication) {
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        Date now = new Date();

        return Jwts.builder()
                .setSubject(principalDetails.getUser().getEmail())
                .setExpiration(new Date(now.getTime() + jwtExpirationInMs))
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String getUserEmailFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateJwt(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex) {
            //do smth
        } catch (MalformedJwtException ex) {
            //do smth
        } catch (ExpiredJwtException ex) {
            //do smth
        } catch (UnsupportedJwtException ex) {
            //do smth
        } catch (IllegalArgumentException ex) {
            //do smth
        }
        return false;
    }


}
