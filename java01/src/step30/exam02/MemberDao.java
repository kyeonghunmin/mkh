package step30.exam02;

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
  
  public int insert(Member member) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    // true로 설정하면 insert 수행시 바로 commit 된다.
    // true로 설정하지 않으면, 자동 commit이 되지 않기 때문에 
    // Temp 테이블에만 남아있고, 실제 테이블에 적용되지 않는다.
    try {
      return sqlSession.insert("MemberDao.insert", member);
      //                       "namespace.id", member
    } finally {
      sqlSession.close();
    }
  }
  
  public int update(Member member) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count =  sqlSession.update("MemberDao.update", member);
      sqlSession.commit();
      return count;
    } finally {
      sqlSession.close();
    }
  }
  
  public int delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      int count = sqlSession.delete("MemberDao.delete", no);
      sqlSession.commit();
      return count;
    } finally {
      sqlSession.close();
    }
  }
}
