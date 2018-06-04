package ua.nure.mediaserver.repositoryTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.nure.mediaserver.domain.User;
import ua.nure.mediaserver.repository.UserRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @Before
    public void setup() {
        user = User.builder()
                .setEmail("test")
                .setName("test")
                .setSurname("test")
                .setPassword("passwd")
                .setRating(0.0)
                .build();
    }

    @Test
    public void createAndReadAllTest(){
        userRepository.create(user);
        assertEquals(1, userRepository.readAll().size());
    }

    @Test
    public void readByEmailTest() {
        userRepository.create(user);
        assertNotNull(userRepository.readByEmail("test"));
    }

}

