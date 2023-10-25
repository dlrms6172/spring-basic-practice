package com.example.project.membermanager.service;

import com.example.project.membermanager.domain.Member;
import com.example.project.membermanager.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member){

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 멤버 이름 중복 검사 함수
     * @param member
     */
    public void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

    }

    /**
     * 회원 조회(전체)
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * 회원 조회(아이디)
     */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    /**
     * 회원 조회(이름)
     */
    public Optional<Member> findOne(String memberName){
        return memberRepository.findByName(memberName);
    }




}
