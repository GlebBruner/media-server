package ua.nure.mediaserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ua.nure.mediaserver.domain.PrincipalDetails;
import ua.nure.mediaserver.domain.User;
import ua.nure.mediaserver.domain.dto.UserDTO;
import ua.nure.mediaserver.domain.enums.UserAuthority;
import ua.nure.mediaserver.domain.exceptions.ExistingEmailOrPasswordException;
import ua.nure.mediaserver.repository.UserRepository;

@Component
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.readByEmail(username);
        if (user != null) {
            return new PrincipalDetails(user);
        } else {
            throw new UsernameNotFoundException("User with email exists");
        }
    }

    public User registerUser(UserDTO userDTO) throws ExistingEmailOrPasswordException {
        if (userRepository.readByEmail(userDTO.getEmail()) == null &&
                userRepository.readByPassword(userDTO.getPassword()) == null) {
            User userForSaveToDatabase = User.builder()
                    .setEmail(userDTO.getEmail())
                    .setName(userDTO.getName())
                    .setSurname(userDTO.getSurname())
                    .setCountry(userDTO.getCountry())
                    .setRating(0.0d)
                    .setPassword(passwordEncoder.encode(userDTO.getPassword()))
                    .build();
            userForSaveToDatabase.addAuthority(UserAuthority.USER_AUTHORITY);
            userRepository.create(userForSaveToDatabase);
            return userForSaveToDatabase;
        } else {
            throw new ExistingEmailOrPasswordException("Email or Password are exist");
        }
    }

    public void loginUser(UserDTO userDTO) {

    }




}
