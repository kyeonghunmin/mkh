package bitcamp.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.pms.domain.Lecture;

// MemberMapper.xml에 선언된 SQL에 맞추어 메서드를 변경한다.
// => SQL id와 메서드 이름을 갖게 한다.
// => SQL parameterType과 메서드의 파라미터 타입을 같게 한다.
// => SQL resultType과 메서드의 리턴 타입을 같게 한다.
public interface LectureDao {
  List<Lecture> selectList() throws Exception;  
  Lecture selectOne(Map<String,Object> paramMap) throws Exception;    
  int insert(Lecture lecture) throws Exception;  
  int update(Lecture lecture) throws Exception;  
  int delete(int no) throws Exception;
}
