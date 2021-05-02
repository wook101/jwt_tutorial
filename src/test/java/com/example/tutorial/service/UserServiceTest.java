package com.example.tutorial.service;

import com.example.tutorial.dto.UserDto;
import com.example.tutorial.entity.User;
import com.example.tutorial.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("회원가입 username중복 체크")
    public void signUpDuplecatied(){
        //유저1 저장
        UserDto userDto1 = new UserDto("ehddnr1021","abcd","wook");
        User user = User.builder()
                .username("ehddnr1021")
                .nickname("wook")
                .password(passwordEncoder.encode(userDto1.getPassword()))
                .activated(true)
                .build();
        userRepository.save(user);

        //유저2 조회
        UserDto userDto2 = new UserDto("ehddnr1021","cdef","zzzz");
        User user2 = userRepository.findOneWithAuthoritiesByUsername(userDto2.getUsername()).get();
        assertThat(user.getUsername()).isEqualTo(user2.getUsername());
    }

}
