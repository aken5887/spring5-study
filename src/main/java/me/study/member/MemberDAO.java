package me.study.member;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

  private SqlSessionTemplate sqlSession;

  public MemberDAO(SqlSessionTemplate sqlSession){
    this.sqlSession = sqlSession;
  }

  public List<Member> selectMemberList(){
    return sqlSession.selectList("MemberDAO.selectMemberList");
  }

  public long insertMember(Member member){
    sqlSession.insert("MemberDAO.inertMember", member);
    return member.getId();
  }
}
