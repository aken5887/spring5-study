package me.study.member;

import java.util.List;

public interface MemberService {

  List<Member> selectMemberList();
  long insertMember(Member member);
  void insertMembers(List<Member> members);

}
