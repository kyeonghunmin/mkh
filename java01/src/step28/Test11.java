// 주제 : 데이터 변경하기 - update문 보내기

package step28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test11 {

  public static void main(String[] args) throws Exception {
    Connection con = null;
    Statement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java80db", "java80", "1111");
      
      stmt = con.createStatement();
      
      int count = stmt.executeUpdate("update MEMBERS set MNAME='OKOK', "
          + "EMAIL='okok@test.com' where mno=5");
      // insert된 개수를 리턴한다.
      // 지정된 규칙에 맞지 않으면 insert 오류가 발생한다. (무결성 보장)
      
      System.out.printf("변경 개수 : %d\n", count);
      
    } finally { // 자원해제는 역순으로 할 것.
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
    
  }
    
}