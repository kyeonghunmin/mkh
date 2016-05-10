package bitcamp.pms.controller;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.TeacherDao;
import bitcamp.pms.domain.Teacher;

@Controller
@RequestMapping("teacher/")
public class TeacherController {
  @Autowired
  private TeacherDao teacherDao;

  @RequestMapping("add.do")
  public void add(Map<String,String> paramMap, PrintStream out) {
    Teacher teacher = new Teacher();
    teacher.setName(paramMap.get("name"));
    teacher.setEmail(paramMap.get("email"));
    teacher.setTel(paramMap.get("tel"));

    try {
      teacherDao.insert(teacher);
      out.println("저장하였습니다.");
    } catch (Exception e) {
      out.println("데이터를 저장하는데 실패했습니다.");
    }
  }
  
  @RequestMapping("delete.do")
  public void delete(Map<String,String> paramMap, PrintStream out) {
    try {
      int no = Integer.parseInt(paramMap.get("no"));
      int count = teacherDao.delete(no);
      
      if (count > 0) {
        out.println("삭제하였습니다.");
      } else {
        out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
      }
      
    } catch (Exception e) {
      out.println("데이터 처리에 실패했습니다.");
    }
  }
  
  @RequestMapping("list.do")
  public void list(PrintStream out) {
    try {
      List<Teacher> teachers = teacherDao.selectList();
      
      for (Teacher teacher : teachers) {
        out.printf("%d, %s, %s, %s\n", teacher.getTno(),
            teacher.getName(), teacher.getEmail(), teacher.getTel());
      }
      
    } catch (Exception e) {
      throw new RuntimeException("회원 데이터 로딩 실패!", e);
    }
  }
  
  @RequestMapping("update.do")
  public void update(Map<String,String> paramMap, PrintStream out) {
    try {
      int no = Integer.parseInt(paramMap.get("no"));
  
      HashMap<String,Object> sqlParamMap = new HashMap<>();
      sqlParamMap.put("no", no);
      
      Teacher teacher = teacherDao.selectOne(sqlParamMap);
      if (teacher == null) {
        out.println("유효하지 않은 번호입니다.");
        return;
      }
      
      teacher = new Teacher();
      teacher.setTno(no);
      teacher.setName(paramMap.get("name"));
      teacher.setEmail(paramMap.get("email"));
      teacher.setTel(paramMap.get("tel"));
      
      int count = teacherDao.update(teacher);
      
      if (count > 0) {
        out.println("변경하였습니다.");
      } else {
        out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
      }
    } catch (Exception e) {
      out.println("데이터 처리에 실패했습니다.");
    }
  }
}









