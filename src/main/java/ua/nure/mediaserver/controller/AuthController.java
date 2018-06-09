package ua.nure.mediaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.mediaserver.configuration.security.JwtProvider;
import ua.nure.mediaserver.domain.ApiResponse;
import ua.nure.mediaserver.domain.JwtAuthenticationResposne;
import ua.nure.mediaserver.domain.dto.UserDTO;
import ua.nure.mediaserver.domain.exceptions.ExistingEmailOrPasswordException;
import ua.nure.mediaserver.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    public void setMongoUserDetailsService(UserService mongoUserDetailsService) {
        this.userService = mongoUserDetailsService;
    }



    @PostMapping("/signup")
    public ResponseEntity register(@RequestBody UserDTO userDTO) {
        //todo check for valid

        try {
            userService.registerUser(userDTO);

            //todo create URI

            return new ResponseEntity(new ApiResponse(true, "registered!"),HttpStatus.OK); // todo return smth real. /api/users/{id} for example
        } catch (ExistingEmailOrPasswordException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDTO.getEmail(),
                        userDTO.getPassword()
                ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwt(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResposne(jwt));
    }


}
