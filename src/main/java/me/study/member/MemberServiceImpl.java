package me.study.member;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService{

  private MemberDAO memberDAO;

  public MemberServiceImpl(MemberDAO memberDAO){
    this.memberDAO = memberDAO;
  }

  @Transactional(readOnly = true)
  public List<Member> selectMemberList(){
    return memberDAO.selectMemberList();
  }

  @Transactional
  public long insertMember(Member member){
    return memberDAO.insertMember(member);
  }

  @Transactional
  public void insertMembers(List<Member> members){
    members.forEach(member -> {
      memberDAO.insertMember(member);
    });
  }
}
