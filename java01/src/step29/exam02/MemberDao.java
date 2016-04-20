package step29.exam02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
  public List<Member> selectList() throws Exception {
    ArrayList<Member> list = new ArrayList<>();
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java80db", "java80", "1111");
      stmt = con.createStatement();
      rs = stmt.executeQuery("select * from MEMBERS");
      Member member = null;
      
      while (rs.next()) {
        member = new Member();
        member.setNo(rs.getInt("MNO"));
        member.setName(rs.getString("MNAME"));
        member.setEmail(rs.getString("EMAIL"));
        member.setPassword(rs.getString("PWD"));
        member.setTel(rs.getString("TEL"));
        list.add(member);
      }
      return list;
      
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
  
  public int insert(Member member) throws Exception {
    Connection con = null;
    Statement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java80db", "java80", "1111");
      stmt = con.createStatement();
      
      return stmt.executeUpdate("insert into MEMBERS(MNAME,EMAIL,PWD,TEL)"
                      + " values('" + member.getName()
                      + "','" + member.getEmail()
                      + "','" + member.getPassword()
                      + "','" + member.getTel()
                      + "')");
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
  
  public int delete(int no) throws Exception {
    Connection con = null;
    Statement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java80db", "java80", "1111");
      
      stmt = con.createStatement();
      
      return stmt.executeUpdate("delete from MEMBERS where mno in (" + no
          + ")");
      // insert된 개수를 리턴한다.
      // 지정된 규칙에 맞지 않으면 insert 오류가 발생한다. (무결성 보장)
      
    } finally { // 자원해제는 역순으로 할 것.
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
  
  public int update(Member member) throws Exception {
    Connection con = null;
    Statement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/java80db", "java80", "1111");
      
      stmt = con.createStatement();
      
      return stmt.executeUpdate("update MEMBERS set MNAME='" + member.getName()
          + "', EMAIL='" + member.getEmail()
          + "', PWD='" + member.getPassword()
          + "', TEL='" + member.getTel()
          + "' where mno=" + member.getNo());
      
    } finally { // 자원해제는 역순으로 할 것.
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}
