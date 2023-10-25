package com.example.project.membermanager.repository;

import com.example.project.membermanager.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    // 멤버 저장
    Member save(Member member);

    // 멤버 찾기(id)
    Optional<Member> findById(Long id);

    // 멤버 찾기(이름)
    Optional<Member> findByName(String name);

    // 멤버 찾기(전체)
    List<Member> findAll();

    // 멤버 삭제(전체)
    void clearStore();

}
