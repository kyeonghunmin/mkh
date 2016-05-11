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

import bitcamp.pms.dao.ProjectDao;
import bitcamp.pms.vo.Project;

@WebServlet("/project/list.do")
public class ProjectListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 1) 스프링 IoC 컨테이너를 꺼낸다.
    //ServletContext servletContext = request.getServletContext();
    ServletContext servletContext = this.getServletContext(); // 두 가지 방법 가능
    ApplicationContext iocContainer = 
        (ApplicationContext)servletContext.getAttribute("iocContainer");
    
    // 2) IoC 컨테이너에서 BoardDao 객체를 꺼낸다.
    ProjectDao projectDao = iocContainer.getBean(ProjectDao.class);
    
    // 3) BoardDao 객체를 이용하여 게시물 목록을 가져온다.
    List<Project> list = projectDao.selectList();
    
    // 4) 게시물 목록을 클라이언트로 출력한다.
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head>");
    out.println("<title>프로젝트</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>프로젝트-목록</h1>");
    out.println("<p><a href='add.do'>새 프로젝트</a></p>");
    out.println("<table border='1'>");
    out.println("<thead>");
    out.println("<tr>");
    out.println("  <th>번호</th>");
    out.println("  <th>제목</th>");
    out.println("  <th>시작일</th>");
    out.println("  <th>종료일</th>");
    out.println("  <th>설명</th>");
    out.println("  <th>상태</th>");
    out.println("</tr>");
    out.println("</thead>");
    out.println("<tbody>");
    for (Project project : list) {
      out.printf("  <tr><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%d</td></tr>\n", 
          project.getNo(),
          project.getTitle(),
          project.getStartDate(),
          project.getEndDate(),
          project.getDescription(),
          project.getState());
    }
    out.println("</tbody>");
    out.println("</table>");
    out.println("</body>");
    out.println("</html>");
  }
}






















