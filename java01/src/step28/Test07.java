// 주제 : JDBC 드라이버를 로딩하는 다른 방법

package step28;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test07 {

  public static void main(String[] args) throws Exception {
    // 방법1) 직접 java.sql.Driver 구현체의 인스턴스를 생성하여 등록하기
    // DriverManager.registerDriver(new Driver());
    
    // 방법2) java.sql.Driver 클래스를 로딩하기 (가장 많이 사용)
    Class.forName("com.mysql.jdbc.Driver");
    
    // 방법3) java.sql.Driver 구현체의 인스턴스 만들기
    // Class.forName("com.mysql.jdbc.Driver").newInstance();
    
    try(Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/java80db", "java80", "1111")) {

      
      System.out.println("연결 성공!");
      
    }
    
  }
    
}