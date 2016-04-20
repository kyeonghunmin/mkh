package bitcamp.pms.controller;

import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.RequestMapping;

@Controller
@RequestMapping("task/")
public class TaskController {
//  private TaskDao taskDao;
//
//  public void setTaskDao(TaskDao taskDao) {
//    this.taskDao = taskDao;
//  }
//  
//  @RequestMapping("add.do")
//  public void add(Scanner keyScan) {
//    
//    Task task = new Task();
//
//    System.out.print("업무이메일? ");
//    task.setWorkerEmail(keyScan.nextLine());
//    System.out.print("업무명? ");
//    task.setTitle(keyScan.nextLine());
//    System.out.print("내용? ");
//    task.setContent(keyScan.nextLine());
//    System.out.print("시작일? ");
//    task.setStartDate(Date.valueOf(keyScan.nextLine()));
//    System.out.print("종료일? ");
//    task.setEndDate(Date.valueOf(keyScan.nextLine()));
//
//    if (CommandUtil.confirm(keyScan, "저장하시겠습니까?")) {
//      try {
//        taskDao.insert(task);
//        System.out.println("저장하였습니다.");
//      } catch (Exception e) {
//        System.out.println("데이터를 저장하는데 실패했습니다.");
//      }
//    } else {
//      System.out.println("저장을 취소하였습니다.");
//    }
//  }
//  
//  @RequestMapping("delete.do")
//  public void delete(Scanner keyScan) {
//    try {
//      
//      System.out.print("삭제할 프로젝트 번호? ");
//      int no = Integer.parseInt(keyScan.nextLine());
//  
//      if (CommandUtil.confirm(keyScan, "정말 삭제하시겠습니까?")) {
//        int count = taskDao.delete(no);
//        if (count > 0) {
//          System.out.println("삭제하였습니다.");          
//        } else {
//          System.out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
//        }
//      } else {
//        System.out.println("삭제를 취소하였습니다.");
//      }
//      
//    } catch (Exception e) {
//      System.out.println("데이터 처리에 실패했습니다.");
//    }
//  }
//  
//  @RequestMapping("list.do")
//  public void list() {
//    
//    try {
//      List<Task> tasks = taskDao.selectList();
//      
//      for (Task task : tasks) {
//        System.out.printf("%d, %s, %s, %s, %s, %s\n", task.getNo(), 
//                                                      task.getWorkerEmail(),
//                                                      task.getTitle(),
//                                                      task.getContent(),
//                                                      task.getStartDate(), 
//                                                      task.getEndDate());
//      }
//    } catch (Exception e) {
//      throw new RuntimeException("프로젝트 데이터 로딩 실패", e);
//    }
//  }
//  
//  @RequestMapping("update.do")
//  public void update(Scanner keyScan) {
//    
//    try {
//      System.out.print("변경할 프로젝트 번호? ");
//      int no = Integer.parseInt(keyScan.nextLine());
//  
//      Task task = taskDao.selectOne(no);
//  
//      System.out.printf("업무이메일(%s)? ", task.getWorkerEmail());
//      task.setWorkerEmail(keyScan.nextLine());
//      System.out.printf("업무명(%s)? ", task.getTitle());
//      task.setTitle(keyScan.nextLine());
//      System.out.printf("내용(%s)? ", task.getContent());
//      task.setContent(keyScan.nextLine());
//      System.out.printf("시작일(%s)? ", task.getStartDate());
//      task.setStartDate(Date.valueOf(keyScan.nextLine()));
//      System.out.printf("종료일(%s)? ", task.getEndDate());
//      task.setEndDate(Date.valueOf(keyScan.nextLine()));
//  
//      if (CommandUtil.confirm(keyScan, "변경하시겠습니까?")) {
//        int count = taskDao.update(task);
//        if (count > 0) {
//          System.out.println("변경하였습니다.");          
//        } else {
//          System.out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
//        }
//      } else {
//        System.out.println("변경을 취소하였습니다.");
//      }
//      
//    } catch (Exception e) {
//      System.out.println("데이터 처리에 실패했습니다.");
//      e.printStackTrace();
//    }
//  }
}
