package com.example.project.membermanager.configuration;

import com.example.project.membermanager.repository.MemberRepository;
import com.example.project.membermanager.repository.MemoryMemberRepository;
import com.example.project.membermanager.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
