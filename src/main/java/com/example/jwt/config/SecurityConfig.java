package com.example.jwt.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()                          //http요청에 대한 접근제한설정
                .antMatchers("/hello").permitAll() //hello API에 대한 모든 요청 접근을 허용
                .anyRequest().authenticated();                //나머지 요청들에 대해선 인증을 받음

    }
}
