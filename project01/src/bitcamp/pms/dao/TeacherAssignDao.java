package bitcamp.pms.dao;

import java.util.List;

import bitcamp.pms.domain.TeacherAssign;
import bitcamp.pms.domain.TeacherAssignTech;

public interface TeacherAssignDao {
  List<TeacherAssignTech> selectList(); 
  TeacherAssign selectOne(int no); 
  int insert(TeacherAssign teacherAssign); 
  int update(TeacherAssign teacherAssign); 
  int delete(int no); 
}