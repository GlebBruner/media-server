package ua.nure.mediaserver.repository;

import ua.nure.mediaserver.domain.User;

import java.util.List;

public interface UserRepository {
    void create (User user);
    User readByEmail (String email);
    User readByPassword (String password);
    List<User> readAll ();
    User update (User user);
    void delete (String nickname); //todo USER
}
