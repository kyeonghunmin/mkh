package bitcamp.pms.controller;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.TeacherAssignDao;
import bitcamp.pms.domain.TeacherAssign;
import bitcamp.pms.domain.TeacherAssignTech;



@Controller
@RequestMapping("/assign/") // 매핑 정보 일부를 선언한다.
public class TeacherAssignController {
  @Autowired
  private TeacherAssignDao teacherAssignDao;
  
  @RequestMapping("add.do") // 매핑 정보 나머지를 선언한다.
  public void add(Map<String, String> paramMap, PrintWriter out) {
    //System.out.println("사용법 : 교육과정 번호,강사 번호 를 입력하세요!");
    TeacherAssign teacherAssign = new TeacherAssign();
    // db auto increments 안해서 임시로 입력함!
    
    teacherAssign.setLno(Integer.parseInt(paramMap.get("lno")));
    teacherAssign.setTno(Integer.parseInt(paramMap.get("tno")));
    try {
      teacherAssignDao.insert(teacherAssign);
      out.println("강사관리 내용을 저장하였습니다.");
    } catch (Exception e) {
      e.printStackTrace();
      out.println("데이터를 저장할 수 없습니다.");
    }
  }

  @RequestMapping("delete.do")
  public void delete(Map<String, String> paramMap, PrintWriter out) {

    try {
      int no = Integer.parseInt(paramMap.get("tano"));
      int count = teacherAssignDao.delete(no);
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
  public void list(PrintWriter out) {
    try {
      List<TeacherAssignTech> teacherAssigns = teacherAssignDao.selectList();
      for(int i = 0 ; i < teacherAssigns.size(); i++){
        TeacherAssignTech vo = teacherAssigns.get(i);
        if(i ==0 ){
          //이거 한번만 출력하려구 넣었어요
          out.println("강사배치번호 | 강의명 | 강사명 | 강의시작일 | 강의종료일 | 강의내용");
        }
        
        out.print(vo.getTano());
        // 줄맞춰 넣으려했는데 안됨 ㅠㅠ 이건 맞춰야할듯
        out.print("    ");
        out.print(vo.getTitle());
        out.print("    ");
        out.print(vo.getTname());
        out.print("    ");
        out.print(vo.getStartDate());
        out.print("    ");
        out.print(vo.getEndDate());
        out.print("    ");
        out.print(vo.getDescription());
        out.println();
      }
    } catch (Exception e) {
      throw new RuntimeException("게시물 데이터 로딩 실패!", e);
    }
  }
  
  
  @RequestMapping("update.do")
  public void update(Map<String, String> paramMap, PrintWriter out) {
    try {
      int no = Integer.parseInt(paramMap.get("tano"));

      TeacherAssign teacherAssign = teacherAssignDao.selectOne(no);
      if (teacherAssign == null) {
        out.println("유효하지 않은 번호입니다.");
        return;
      }
      teacherAssign.setTano(no);
      teacherAssign.setStartDate(Date.valueOf(paramMap.get("startDate")));
      teacherAssign.setEndDate(Date.valueOf(paramMap.get("endDate")));
      teacherAssign.setDescription(paramMap.get("description"));
      teacherAssign.setHr(Integer.parseInt(paramMap.get("hr")));
      

      int count = teacherAssignDao.update(teacherAssign);
      if (count > 0) {
        out.println("변경하였습니다.");
      } else {
        out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
      }

    } catch (Exception e) {
      e.printStackTrace();
      out.println("데이터 처리에 실패했습니다.");
    }
  }

}
