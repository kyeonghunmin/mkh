package bitcamp.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.pms.dao.ProjectDao;
import bitcamp.pms.vo.Project;

@WebServlet("/project/add.do")
public class ProjectAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head>");
    out.println("<title>프로젝트</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시판-새 프로젝트</h1>");
    out.println("<form action='add.do' method='post'>");
    out.println("제목: <input type='text' name='title'><br>");
    out.println("시작일: <input type='date' name='startDate'><br>");
    out.println("종료일: <input type='date' name='endDate'><br>");
    out.println("설명: <textarea name='content' rows='5' cols='60'></textarea><br>");
    out.println("<button>등록</button>");
    out.println("<button type='reset'>초기화</button>");
    out.println("</form>");
    
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletContext servletContext = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext)servletContext.getAttribute("iocContainer");
    
    ProjectDao projectDao = iocContainer.getBean(ProjectDao.class);
    
    Project project = new Project();
    project.setTitle(request.getParameter("title"));
    project.setStartDate(Date.valueOf(request.getParameter("startDate")));
    project.setEndDate(Date.valueOf(request.getParameter("endDate")));
    project.setDescription(request.getParameter("description"));
    
    projectDao.insert(project);
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head>");
    out.println("<title>프로젝트</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>프로젝트-등록 결과</h1>");
    out.println("<p>등록 성공입니다.</p>");
    out.println("<a href='list.do'>목록</a>");
    out.println("</body>");
    out.println("</html>");
  }
}






















