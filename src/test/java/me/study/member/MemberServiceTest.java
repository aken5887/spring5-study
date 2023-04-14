package me.study.member;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import me.config.Spring5Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Spring5Test
class MemberServiceTest {

  @Autowired
  MemberService memberService;

  @Test
  void testMemberService(){
    List<Member> members = memberService.selectMemberList();
    System.out.println(this.memberService);
    Assertions.assertThat(members).isNotNull();
  }

  @Test
  void insertNewMember(){
    System.out.println(this.memberService);
    int count = memberService.selectMemberList().size();
    String randomNum = String.valueOf(Math.round(Math.random()*10000));
    Member newMember = new Member("y"+randomNum+"@test.com","1111","yongMinu");
    long newNumber = memberService.insertMember(newMember);
    Assertions.assertThat(newNumber).isGreaterThan(count);
  }

  @Test
  void insertMembers(){
    System.out.println(this.memberService);
    List<Member> members = new ArrayList<>();
    for(int i=0; i<5; i++){
      String randomNum = String.valueOf(Math.round(Math.random()*10000));
      Member newMember = new Member("y"+randomNum+"@test.com","1111","yongMinu");
      members.add(newMember);
    }
    members.add(members.get(0));
    assertThrows(RuntimeException.class, ()->{
      memberService.insertMembers(members);
    });
  }
}