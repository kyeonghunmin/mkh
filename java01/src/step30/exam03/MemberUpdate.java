// 주제 : SQL 맵퍼인 mybatis 적용하기 - MemberDao에 적용하기 - update

package step30.exam03;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberUpdate {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream(
                                  "step30/exam03/mybatis-config.xml");
    
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // MemberDao에 SqlSessionFactory를 주입한다.
    MemberDao memberDao = new MemberDao();
    memberDao.setSqlSessionFactory(sqlSessionFactory);
    
    Member member = new Member();
    member.setNo(21);
    member.setName("민경훈");
    member.setEmail("min@test.com");
    member.setTel("1111-8888");
    
    memberDao.update(member);
    System.out.println("변경 성공");
  }

}