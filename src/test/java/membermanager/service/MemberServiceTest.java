package membermanager.service;

import com.example.project.membermanager.domain.Member;
import com.example.project.membermanager.repository.MemoryMemberRepository;
import com.example.project.membermanager.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService();
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    // 회원가입 테스트
    public void join() throws Exception{
        //given
        Member member = new Member();
        member.setName("test1");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
        System.out.println(member.getName());
    }

    @Test
    // 중복회원 예외
    public void duplicateMember() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("test1");

        Member member2 = new Member();
        member2.setName("test1");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,() -> memberService.join(member2));

        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        System.out.println(e);
    }

    @Test
    // 회원조회(이름)
    public void findByName(){
        //given
        Member member1 = new Member();
        member1.setName("test1");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("test2");
        memberService.join(member2);

        //when
        Long i = Long.valueOf(2);
        Member findMember = memberRepository.findById(i).get();
        assertEquals(member2.getName(),findMember.getName());

        System.out.println(findMember.getName());
    }

    @Test
    // 회원조회(아이디)
    public void findById(){
        //given
        Member member1 = new Member();
        member1.setName("test1");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("test2");
        memberService.join(member2);

        Member findMember = memberRepository.findByName("test2").get();
        assertEquals(member2.getId(),findMember.getId());

        System.out.println(findMember.getId());
    }

}
