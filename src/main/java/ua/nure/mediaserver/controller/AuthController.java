package ua.nure.mediaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.mediaserver.domain.dto.UserDTO;
import ua.nure.mediaserver.domain.exceptions.ExistingEmailOrPasswordException;
import ua.nure.mediaserver.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private UserService userService;

    @Autowired
    public void setMongoUserDetailsService(UserService mongoUserDetailsService) {
        this.userService = mongoUserDetailsService;
    }

    @PostMapping("/registration")
    public ResponseEntity registerUser(@RequestBody UserDTO userDTO) {
        //todo check for valid
        try {
            userService.registerUser(userDTO);
            return new ResponseEntity(HttpStatus.OK); // todo return smth real. /api/users/{id} for example
        } catch (ExistingEmailOrPasswordException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO) {

    }


}
