// 1) PreparedStatement 적용
// 2) DB 연결정보를 외부로부터 받는다.
//    => DBMS 연결 정보가 바뀌더라도 코드를 변경할 필요가 없다.
// 3) 커넥션 한 개만 생성하여 공유하기 
//    => 메서드가 호출될 때마다 커넥션을 맺고 실행한 다음 커넥션을 끊으면,
//       실행 속도가 느려진다.
//    => 그래서 DAO를 생성할 때 미리 커넥션을 준비해 두었다가 사용하도록 한다.
//    => 즉, selectList(), insert(), update(), delete()는 커넥션을 공유한다.

package step29.exam04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
  Connection con;
  
  public MemberDao(String jdbcDriver, String jdbcUrl, String userName, 
                   String password) throws Exception {
    
    Class.forName(jdbcDriver);
    con = DriverManager.getConnection(jdbcUrl, userName, password);
    
  }

  public List<Member> selectList() throws Exception {
    ArrayList<Member> list = new ArrayList<>();
    
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
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
    }
  }
  
  public int insert(Member member) throws Exception {
    PreparedStatement stmt = null;
    
    try {
      stmt = con.prepareStatement("insert into MEMBERS(MNAME,EMAIL,PWD,TEL)"
          + " values(?,?,?,?)");
      
      stmt.setString(1,  member.getName());
      stmt.setString(2,  member.getEmail());
      stmt.setString(3,  member.getPassword());
      stmt.setString(4,  member.getTel());
      
      return stmt.executeUpdate();
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
    }
  }
  
  public int update(Member member) throws Exception {
    PreparedStatement stmt = null;
    
    try {    
      stmt = con.prepareStatement("update MEMBERS set MNAME=?, EMAIL=?, PWD=?, TEL=? where MNO=?");
      
      stmt.setString(1, member.getName());
      stmt.setString(2, member.getEmail());
      stmt.setString(3, member.getPassword());
      stmt.setString(4, member.getTel());
      stmt.setInt(5, member.getNo());
      
      return stmt.executeUpdate();
      
    } finally { // 자원해제는 역순으로 할 것.
      try {stmt.close();} catch (Exception e) {}
    }
  }
  
  public int delete(int no) throws Exception {

    PreparedStatement stmt = null;
    
    try {
      stmt = con.prepareStatement("delete from MEMBERS where MNO=?");
      stmt.setInt(1,  no);
      return stmt.executeUpdate();
      // insert된 개수를 리턴한다.
      // 지정된 규칙에 맞지 않으면 insert 오류가 발생한다. (무결성 보장)
      
    } finally { // 자원해제는 역순으로 할 것.
      try {stmt.close();} catch (Exception e) {}
    }
  }
    
  public void destroy() {
    try {con.close();} catch (Exception e) {}
  }
}
