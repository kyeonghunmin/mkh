package bitcamp.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.vo.Member;

@WebServlet("/member/list.do")
public class MemberListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 1) 스프링 IoC 컨테이너를 꺼낸다.
    //ServletContext servletContext = request.getServletContext();
    ServletContext servletContext = this.getServletContext(); // 두 가지 방법 가능
    ApplicationContext iocContainer = 
        (ApplicationContext)servletContext.getAttribute("iocContainer");
    
    // 2) IoC 컨테이너에서 BoardDao 객체를 꺼낸다.
    MemberDao memberDao = iocContainer.getBean(MemberDao.class);
    
    
    // 3) BoardDao 객체를 이용하여 게시물 목록을 가져온다.
    List<Member> list = memberDao.selectList();
    // 4) 게시물 목록을 클라이언트로 출력한다.
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head>");
    out.println("<title>회원</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원-목록</h1>");
    out.println("<p><a href='add.do'>새 회원</a></p>");
    out.println("<table border='1'>");
    out.println("<thead>");
    out.println("<tr>");
    out.println("  <th>번호</th>");
    out.println("  <th>이름</th>");
    out.println("  <th>이메일</th>");
    out.println("  <th>암호</th>");
    out.println("  <th>전화</th>");
    out.println("</tr>");
    out.println("</thead>");
    out.println("<tbody>");
    for (Member member : list) {
      out.printf("  <tr><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>\n", 
          member.getNo(), 
          member.getName(),
          member.getEmail(),
          member.getPassword(),
          member.getTel());
    }
    out.println("</tbody>");
    out.println("</table>");
    out.println("</body>");
    out.println("</html>");
  }
}






















