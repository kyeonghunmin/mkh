package step33.exam11;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // DAO 처럼 데이터를 처리하는 객체에 붙인다.
public class MemberDao {
  @Autowired
  SqlSessionFactory sqlSessionFactory;

  @Override
  public String toString() {
    return "MemberDao [sqlSessionFactory=" + sqlSessionFactory + "]";
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
