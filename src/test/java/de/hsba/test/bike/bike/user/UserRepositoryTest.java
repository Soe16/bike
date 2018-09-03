package de.hsba.test.bike.bike.user;

import de.hsba.test.bike.bike.user.User;
import de.hsba.test.bike.bike.user.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;


    @Before
    public void setUp(){
        userRepository.deleteAll();
        userRepository.flush();

    }

    @Test
    public void findByName(){
        //given
        User bob = new User("bob", "pass", "bob@mail.com", "Customer");
        User john = new User("john", "pass", "john@yahoo.com", "Deliverer");
        userRepository.save(bob);
        userRepository.save(john);

        //then
        assertEquals(bob, userRepository.findByName("bob"));
        assertEquals(john, userRepository.findByName("john"));
        assertNull(userRepository.findByName("clara"));
    }

    @Test
    public void findAllUsers(){
        //given
        User bob = new User("bob", "pass", "bob@mail.com", "Customer");
        User john = new User("john", "pass", "john@yahoo.com", "Deliverer");
        userRepository.save(bob);
        userRepository.save(john);

        //when
        List<User> users = userRepository.findUsers();


        //then
        assertEquals(Arrays.asList(bob,john),users);

    }
}
