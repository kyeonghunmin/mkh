package bitcamp.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.pms.domain.Teacher;

public interface TeacherDao {

  List<Teacher> selectList();

  Teacher selectOne(Map<String, Object> paramMap);

  int insert(Teacher member);

  int update(Teacher member);

  int delete(int no);

  int isMember(Map<String, Object> paramMap);

}