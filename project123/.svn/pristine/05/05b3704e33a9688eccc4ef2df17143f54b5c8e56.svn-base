package bitcamp.pms.controller;

import java.io.PrintStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.LectureDao;
import bitcamp.pms.domain.Lecture;

@Controller
@RequestMapping("lecture/")
public class LectureController {
  @Autowired
  private LectureDao lectureDao;

  @RequestMapping("add.do")
  public void add(Map<String,String> paramMap, PrintStream out) {    
    Lecture lecture = new Lecture();
    lecture.setRno(paramMap.get("rno"));
    lecture.setTitle(paramMap.get("title"));
    lecture.setDesc(paramMap.get("desc"));
    lecture.setStartDate(Date.valueOf(paramMap.get("startDate")));
    lecture.setEndDate(Date.valueOf(paramMap.get("endDate")));
    lecture.setDayHr(Integer.parseInt(paramMap.get("dayHr")));
    lecture.setTotalHr(Integer.parseInt(paramMap.get("totalHr")));
    lecture.setFinalDate(Date.valueOf(paramMap.get("finalDate")));
    
      try {
        lectureDao.insert(lecture);
        out.println("저장하였습니다.");
      } catch (Exception e) {
        out.println("데이터를 저장하는데 실패했습니다.");
      }   
  }
  
  @RequestMapping("delete.do")
  public void delete(Map<String,String> paramMap, PrintStream out) {
    try {
      System.out.print("삭제할 강의 번호는? ");
      int no = Integer.parseInt(paramMap.get("lno"));
        int count = lectureDao.delete(no);
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
  public void list(PrintStream out ) {
    try {
      List<Lecture> lectures = lectureDao.selectList();
      
      for (Lecture lecture : lectures) {
        out.printf("%d, %s, %s, %s, %s, %s, %s\n", lecture.getLno(), lecture.getRno(), lecture.getTitle(),
            lecture.getDesc(), lecture.getStartDate(), lecture.getEndDate(), lecture.getFinalDate());
      }
    } catch (Exception e) {
      throw new RuntimeException("강의 데이터 로딩 실패!", e);
    }
  }
  
  @RequestMapping("update.do")
  public void update(Map<String,String> paramMap, PrintStream out) {
    try {
      int no = Integer.parseInt(paramMap.get("lno"));
  
      HashMap<String,Object> sqlParamMap = new HashMap<>();
      sqlParamMap.put("lno", no);
      Lecture lecture = lectureDao.selectOne(sqlParamMap);
      if (lecture == null) {
        out.println("유효하지 않은 번호입니다.");
        return;
      }
      lecture = new Lecture();
      lecture.setLno(no);
      lecture.setTitle(paramMap.get("title"));
      lecture.setDesc(paramMap.get("desc"));
      lecture.setStartDate(Date.valueOf(paramMap.get("startDate")));
      lecture.setEndDate(Date.valueOf(paramMap.get("endDate")));
      lecture.setDayHr(Integer.parseInt(paramMap.get("dayHr")));
      lecture.setTotalHr(Integer.parseInt(paramMap.get("totalHr")));
      lecture.setFinalDate(Date.valueOf(paramMap.get("finalDate")));
  
      int count = lectureDao.update(lecture);
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









