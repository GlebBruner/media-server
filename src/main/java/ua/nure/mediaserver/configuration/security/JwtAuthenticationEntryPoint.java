package ua.nure.mediaserver.configuration.security;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //response.setContentType(MediaType.APPLICATION_JSON_VALUE); //todo maybe do some good response JSON
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Sorry, You're not authorized to access this resource." );
    }



}
