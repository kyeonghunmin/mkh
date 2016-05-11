// 주제 : GET 요청과 POST 요청 (getpost.html)

package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet15")
public class Servlet15 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.printf("요청 method => %s\n", request.getMethod());
  }
}

/*
웹 브라우저는 WEB-INF에 있는 자원을 요구할 수 없다.
=> Webcontent에 html 파일을 만들어야 하는 이유 







*/