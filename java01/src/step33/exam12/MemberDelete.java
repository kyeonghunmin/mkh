// 주제 : SQL 맵퍼인 mybatis 적용하기 - MemberDao에 적용하기 - update

package step33.exam12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberDelete {

  public static void main(String[] args) throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step33/exam12/application-context.xml");
    
    MemberDao memberDao = (MemberDao)context.getBean("memberDao");
    
    memberDao.delete(7);
    
    System.out.println("삭제 성공");
  }

}