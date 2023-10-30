package com.example.project.membermanager.configuration;

import com.example.project.membermanager.repository.MemberRepository;
import com.example.project.membermanager.repository.MemoryMemberRepository;
import com.example.project.membermanager.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfiguration {

    private final DataSource dataSource;


    public SpringConfiguration(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
