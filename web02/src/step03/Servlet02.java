// 주제 : 웹 브라우저로 출력하기
// => servlet 3.0 규격부터 지원
// => web.xml에 서블릿 정보를 등록하는 대신 @WebServlet 애노테이션을 이용한다.
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/servlet02")
public class Servlet02 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    
    // 출력 도구를 준비한다.
    PrintWriter out = response.getWriter(); // 클라이언트에게 출력하는 도구를 리턴한다.
    out.println("Servlet02");
    out.println("Servlet02");
    out.println("한글");
    
  }
}

/*
# service() 메서드의 파라미터
1) ServletRequest
   => 클라이언트의 요청을 다루는 기능을 갖고 있다.
2) ServletResponse
   => 클라이언트에게 응답할 때 필요한 기능을 갖고 있다.

# Tomcat 기능
1. 웹 서버
2. 서블릿 컨테이너

### 배포 폴더에 .class가 없으면 remove 한 후 다시 만들 것(add).



*/