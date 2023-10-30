package com.example.project.membermanager.controller;

import com.example.project.membermanager.controller.dto.MemberForm;
import com.example.project.membermanager.domain.Member;
import com.example.project.membermanager.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "membermanager/createMemberForm";
    }

    // 회원가입
    @PostMapping(value = "/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    // 회원목록(전체)
    @GetMapping
    public String List(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);

        return "membermanager/memberList";
    }


}
