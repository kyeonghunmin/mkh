package step30.exam01;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDao {
  SqlSessionFactory sqlSessionFactory;
  
  public MemberDao() {}
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
    
  }

  public List<Member> selectList() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      return sqlSession.selectList("MemberDao.selectList");
    } finally {
      sqlSession.close();
    }
  }
  
//  public int insert(Member member) throws Exception {
//    Connection con = null;
//    PreparedStatement stmt = null;
//    try {
//      con = dataSource.getConnection();
//      stmt = con.prepareStatement("insert into MEMBERS(MNAME,EMAIL,PWD,TEL)"
//          + " values(?,?,?,?)");
//      
//      stmt.setString(1,  member.getName());
//      stmt.setString(2,  member.getEmail());
//      stmt.setString(3,  member.getPassword());
//      stmt.setString(4,  member.getTel());
//      
//      return stmt.executeUpdate();
//      
//    } finally {
//      try {stmt.close();} catch (Exception e) {}
//      dataSource.returnConnection(con);
//    }
//  }
//  
//  public int update(Member member) throws Exception {
//    Connection con = null;
//    PreparedStatement stmt = null;
//    
//    try {
//      con = dataSource.getConnection();
//      stmt = con.prepareStatement("update MEMBERS set MNAME=?, EMAIL=?, PWD=?, TEL=? where MNO=?");
//      
//      stmt.setString(1, member.getName());
//      stmt.setString(2, member.getEmail());
//      stmt.setString(3, member.getPassword());
//      stmt.setString(4, member.getTel());
//      stmt.setInt(5, member.getNo());
//      
//      return stmt.executeUpdate();
//      
//    } finally { // 자원해제는 역순으로 할 것.
//      try {stmt.close();} catch (Exception e) {}
//      dataSource.returnConnection(con);
//    }
//  }
//  
//  public int delete(int no) throws Exception {
//    Connection con = null;
//    PreparedStatement stmt = null;
//    
//    try {
//      con = dataSource.getConnection();
//      stmt = con.prepareStatement("delete from MEMBERS where MNO=?");
//      stmt.setInt(1,  no);
//      return stmt.executeUpdate();
//      // insert된 개수를 리턴한다.
//      // 지정된 규칙에 맞지 않으면 insert 오류가 발생한다. (무결성 보장)
//      
//    } finally { // 자원해제는 역순으로 할 것.
//      try {stmt.close();} catch (Exception e) {}
//      dataSource.returnConnection(con);
//    }
//  }

  
}
