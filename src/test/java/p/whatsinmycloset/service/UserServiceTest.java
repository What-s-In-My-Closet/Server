package p.whatsinmycloset.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import p.whatsinmycloset.domain.User;
import p.whatsinmycloset.repository.UserRepository;

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
    public void 중복_회원_예외() throws Exception {
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
}