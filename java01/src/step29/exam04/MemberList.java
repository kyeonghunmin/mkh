// 주제 : 질의하기 - SELECT 문 보내기

package step29.exam04;

import java.util.List;

public class MemberList {

  public static void main(String[] args) throws Exception {
    try {
      MemberDao memberDao = new MemberDao(
          "com.mysql.jdbc.Driver",
          "jdbc:mysql://localhost:3306/java80db",
          "java80",
          "1111"
          );
      List<Member> list = memberDao.selectList();
      
      for (Member member : list) {
        System.out.printf("%d, %s, %s, %s\n", 
                                              member.getNo(), 
                                              member.getName(), 
                                              member.getEmail(), 
                                              member.getPassword());
      }
      
      memberDao.destroy();
      
    } catch (Exception e) {
      System.out.println("데이터 가져오는데 실패했습니다.");
    } 
  }
}