package com.Travelrithm.service;

import com.Travelrithm.domain.SocialType;
import com.Travelrithm.domain.UserInfo;
import com.Travelrithm.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void join() {
        //given
        UserInfo user2 = new UserInfo();
        UserInfo user3 = new UserInfo();
        UserInfo user4 = new UserInfo();
        UserInfo user5 = new UserInfo();
        UserInfo user6 = new UserInfo();
        UserInfo user7 = new UserInfo();
        UserInfo user8 = new UserInfo();

        user2.setName("Jack Doe");
        user2.setEmail("john.doe@example.com");
        user2.setPassword("securePassword123");
        user2.setNickname("johnny");
        user2.setSocial_type(SocialType.KAKAO);
        user2.setCreated_at(LocalDateTime.now());
        user2.setUpdated_at(LocalDateTime.now());
        user2.setNickname_updated_at(LocalDateTime.now().minusDays(10));

        user3.setName("Alice Smith");
        user3.setEmail("alice.smith@example.com");
        user3.setPassword("passwordAlice456");
        user3.setNickname("alicesmith");
        user3.setSocial_type(SocialType.KAKAO);
        user3.setCreated_at(LocalDateTime.now());
        user3.setUpdated_at(LocalDateTime.now());
        user3.setNickname_updated_at(LocalDateTime.now().minusDays(10));

        user4.setName("Bob Johnson");
        user4.setEmail("bob.johnson@example.com");
        user4.setPassword("bobPassword789");
        user4.setNickname("bobby");
        user4.setSocial_type(SocialType.KAKAO);
        user4.setCreated_at(LocalDateTime.now());
        user4.setUpdated_at(LocalDateTime.now());
        user4.setNickname_updated_at(LocalDateTime.now().minusDays(10));

        user5.setName("Eve White");
        user5.setEmail("eve.white@example.com");
        user5.setPassword("evePassword101112");
        user5.setNickname("evie");
        user5.setSocial_type(SocialType.NAVER);
        user5.setCreated_at(LocalDateTime.now());
        user5.setUpdated_at(LocalDateTime.now());
        user5.setNickname_updated_at(LocalDateTime.now().minusDays(10));

        user6.setName("Charlie Brown");
        user6.setEmail("charlie.brown@example.com");
        user6.setPassword("charliePass131415");
        user6.setNickname("charlie_b");
        user6.setSocial_type(SocialType.NAVER);
        user6.setCreated_at(LocalDateTime.now());
        user6.setUpdated_at(LocalDateTime.now());
        user6.setNickname_updated_at(LocalDateTime.now().minusDays(10));

        user7.setName("David Lee");
        user7.setEmail("david.lee@example.com");
        user7.setPassword("davidPass161718");
        user7.setNickname("dave");
        user7.setSocial_type(SocialType.NAVER);
        user7.setCreated_at(LocalDateTime.now());
        user7.setUpdated_at(LocalDateTime.now());
        user7.setNickname_updated_at(LocalDateTime.now().minusDays(10));

        user8.setName("Grace Green");
        user8.setEmail("grace.green@example.com");
        user8.setPassword("gracePass192021");
        user8.setNickname("gracie");
        user8.setSocial_type(SocialType.KAKAO);
        user8.setCreated_at(LocalDateTime.now());
        user8.setUpdated_at(LocalDateTime.now());
        user8.setNickname_updated_at(LocalDateTime.now().minusDays(10));

        //when
        userService.join(user2);
        userService.join(user3);
        userService.join(user4);
        userService.join(user5);
        userService.join(user6);
        userService.join(user7);
        userService.join(user8);

    }

    @Test
    void findAll() {
        List<UserInfo> users = userService.findAll();
        users.forEach(user ->
                System.out.println("사용자 정보: " +
                        "이름: " + user.getName() + ", " +
                        "패스워드: " + user.getPassword() + ", " +
                        "닉네임: " + user.getNickname() + ", " +
                        "만든 시간: " + user.getCreated_at())
        );
    }

}