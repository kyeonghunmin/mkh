// 주제 : 요청을 다른 서블릿에게 위임하기 - include

package step04.servlet21;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet21")
public class CalculatorServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    // 서블릿을 만들 때 마다 다음과 같이 요청 데이터의 문자 집합을
    // 지정하는 것은 매우 번거롭고 귀찮은 일이다.
    // 해결책?
    // 필터를 이용하여 문자집합을 설정한다.
    // request.setCharacterEncoding("UTF-8");
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
        
    out.println("******************************");
    
    // 1) 요청을 다른 서블릿에게 전달할 배달자 준비
    // 재요청하는 것이 아니기 때문에 요청 URL은 그대로 /step04/servlet20 이다.
    // include에 경우는 위임해도 다시 돌아갈 수 있다. 
    RequestDispatcher rd = null; // (RequestDispatcher : 요청 배달자)
    switch (request.getParameter("op")) {
    case "더하기":
      // plusServlet의 애노테이션을 정확히 주어야 한다.
      rd = request.getRequestDispatcher("/step04/calculator2/plus");
      break;
    case "빼기":
      rd = request.getRequestDispatcher("/step04/calculator2/minus");
      break;
    case "곱하기":
      rd = request.getRequestDispatcher("/step04/calculator2/multiple");
      break;
    case "나누기":
      rd = request.getRequestDispatcher("/step04/calculator2/divide");
      break;
    default:
      out.println("지원하지 않는 연산자입니다.");
      return;
    }
    
    // 2) 요청 배달자를 통해 다른 서블릿으로 요청을 전달한다.
    rd.include(request, response);
    
    out.println("******************************");
  }
}

/*
# include 실행 위임 방식
- 한 작업을 여러 서블릿이 협력하여 수행할 때 사용하는 방식.
- 메인 서블릿에서 기본 작업을 수행하고, 다른 서블릿이 부분 작업을 수행한다.














*/