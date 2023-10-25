package membermanager.repository;

import com.example.project.membermanager.domain.Member;
import com.example.project.membermanager.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    // 저장 테스트
    public void save(){
        Member member = new Member();
        //given
        member.setName("test");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    // 찾기(이름) 테스트
    public void findByName(){

        //given
        Member member1 = new Member();
        member1.setName("test1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        repository.save(member2);

        // when
        Member result = repository.findByName("test2").get();

        // then
        assertThat(result).isEqualTo(member2);
        System.out.println(result.getId());
    }

    @Test
    // 찾기(아이디) 테스트
    public void findById(){
        //given
        Member member1 = new Member();
        member1.setName("test1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        repository.save(member2);

        // when
        Long i = Long.valueOf(2);
        Member result = repository.findById(i).get();

        // then
        assertThat(result).isEqualTo(member2);
        System.out.println(result.getName());
    }

    @Test
    // 찾기(전체) 테스트
    public void findAll(){
        //given
        Member member1 = new Member();
        member1.setName("test1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        repository.save(member2);

        Member member3 = new Member();
        member2.setName("test3");
        repository.save(member3);

        //when
        List<Member> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(3);
        System.out.println(result.size());
    }

}
