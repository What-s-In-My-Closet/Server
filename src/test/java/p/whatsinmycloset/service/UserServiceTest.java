package p.whatsinmycloset.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import p.whatsinmycloset.domain.User;
import p.whatsinmycloset.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;


    @Test
    public void 회원가입() throws Exception {
        //given
        User user = new User();
        user.setEmail("thisemail@isnot.work");

        //when
        Long saveId = userService.join(user);

        //then
        Assertions.assertEquals(user, userRepository.findOne(saveId));
    }

    @Test
    public void 중복회원예외() throws Exception {
        //given
        User user1 = new User();
        user1.setEmail("thisemail@isnot.work");

        User user2 = new User();
        user2.setEmail("thisemail@isnot.work");

        //when
        userService.join(user1);

        //then
        assertThrows(IllegalStateException.class, () -> {
            userService.join(user2);    // 예외가 발생해야 한다.
        });

//        fail("예외가 발생해야 한다.");
    }

    @Test
    public void 전체회원조회() throws Exception {
        //given

        List<User> users = new ArrayList<>(3);

        User user1 = new User();    user1.setEmail("thisemail1@isnot.work");
        User user2 = new User();    user2.setEmail("thisemail2@isnot.work");
        User user3 = new User();    user3.setEmail("thisemail3@isnot.work");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        //when
        Long user1Id = userService.join(user1);
        Long user2Id = userService.join(user2);
        Long user3Id = userService.join(user3);

        //then
        Assertions.assertEquals(users, userService.findUsers());
    }
}