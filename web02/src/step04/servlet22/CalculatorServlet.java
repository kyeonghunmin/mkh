// 주제 : 서블릿 끼리 값을 주고 받기 - getAttribute() / setAttribute()

package step04.servlet22;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet22")
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
        
    
    // 1) 요청을 다른 서블릿에게 전달할 배달자 준비
    // 재요청하는 것이 아니기 때문에 요청 URL은 그대로 /step04/servlet20 이다.
    // include에 경우는 위임해도 다시 돌아갈 수 있다. 
    RequestDispatcher rd = null; // (RequestDispatcher : 요청 배달자)
    
    // 2) 헤더를 출력할 서블릿을 실행한다.
    rd = request.getRequestDispatcher("/step04/calculator3/header");
    rd.include(request, response); // HeaderServlet을 실행한 후 되돌아 온다.
    
    switch (request.getParameter("op")) {
    case "더하기":
      // plusServlet의 애노테이션을 정확히 주어야 한다.
      rd = request.getRequestDispatcher("/step04/calculator3/plus");
      break;
    case "빼기":
      rd = request.getRequestDispatcher("/step04/calculator3/minus");
      break;
    case "곱하기":
      rd = request.getRequestDispatcher("/step04/calculator3/multiple");
      break;
    case "나누기":
      rd = request.getRequestDispatcher("/step04/calculator3/divide");
      break;
    default:
      out.println("지원하지 않는 연산자입니다.");
      return;
    }
    
    // 3) 계산을 수행하는 서블릿을 실행한다.
    rd.include(request, response); // 계산을 수행한 후 되돌아 온다.
    
    // 4) 계산 결과를 출력한다.
    // => 다른 서블릿에서 수행한 작업 결과를 받기
    // => ServletRequest 바구니에 담겨있는 값을 꺼낸다.
    int result = (int)request.getAttribute("result");
    out.printf("%s %s %s = %d\n", 
        request.getParameter("a"),
        request.getParameter("op"),
        request.getParameter("b"),
        result);
    
    
    
    // 5) 꼬리말을 출력할 서블릿을 실행한다.
    rd = request.getRequestDispatcher("/step04/calculator3/tailer");
    rd.include(request, response); // 꼬리말을 출력한 후 되돌아 온다.
    
    
    
  }
}

/*
# ServletRequest 보관소
- ServletRequest는 요청 정보를 다루는 것 외에 보관소의 역할도 겸하고 있다.
- forward나 include에 묶여 있는 서블릿끼리 데이터를 주고 받을 때 사용한다.


# 서블릿 기술에서 제공하는 다양한 보관소
1) ServletContext
- 웹 애플리케이션의 정보를 다루는 것 외에 보관소의 역할도 겸하고 있다.
- 사용 범위
  => 사용 범위를 이해하려면, 이 객체가 언제 생성되고 언제 제거되는지 이해해야 한다.
  => 웹 애플리케이션이 시작될 때 생성됨.
  => 웹 애플리케이션 당 한 개만 생성됨.
  => 웹 애플리케이션이 멈출 때 제거됨.
- (서블릿들이 공통으로 사용하는 값이나 객체)

2) HttpSession (브라우저 단위로 처리; 예) 크롬3개가 떠있으면 1개로 간주함)
- 세션을 다루는 것 외에 보관소의 역할도 겸하고 있다.
- 사용 범위
  => 세션이 없을 때 생성됨.
  => 타임 아웃되거나 세션을 무효화할 때 제거됨.
- (로그인 사용자가 사용할 값이나 객체)

3) ServletRequest
- 요청을 다루는 것 외에 보관소의 역할도 겸하고 있다.
- 사용 범위
  => 요청이 들어올 때 생성됨.
  => 응답을 하면 제거됨.
- (forward와 include의 경우, servletRequest 보관소를 공유)

* 추가로 4번째... (총 보관소는 4개 ; 1, 2, 3번 확실히 알아둘 것)
- JSP 페이지와 Tag Handler 사이에 공유하는 보관소 : PageContext








*/