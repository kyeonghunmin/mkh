package bitcamp.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.pms.domain.Member;

public interface MemberDao {
  List<Member> selectList();
  
  Member selectOne(Map<String,Object> paramMap);
  
  int insert(Member member);
  
  int update(Member member);
  
  int delete(int no);

  int isMember(Map<String,Object> paramMap);
}











