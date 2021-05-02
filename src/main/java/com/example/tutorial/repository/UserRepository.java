package com.example.tutorial.repository;

import com.example.tutorial.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = "authorities")//쿼리 수행시 Eager조회로 authorities정보를 같이 가져옴
    Optional<User> findOneWithAuthoritiesByUsername(String username);
}
