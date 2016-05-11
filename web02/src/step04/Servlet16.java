// 주제 : GET 요청과 POST 요청의 차이점 (getpost2.html)

package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet16")
public class Servlet16 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.printf("요청 method => %s\n", request.getMethod());
    
    // GET 요청, POST 요청에 상관없이 파라미터 값을 꺼내는 방법은 같다.
    out.printf("요청 name => %s\n", request.getParameter("name"));
    out.printf("요청 email => %s\n", request.getParameter("email"));
    out.printf("요청 tel => %s\n", request.getParameter("tel"));
  }
}

/*
# GET 요청의 파라미터
=> GET 요청은 Request-URI에 파라미터 값을 붙여 보낸다.
=> 예)
   GET /web02/step04/servlet16?name=aaa&email=bbb&tel=ccc HTTP/1.1
=> HTTP 요청 프로토콜 (관련 프로그램 : Fiddler, charles)
GET /web02/step04/servlet16?name=aaa&email=bbb&tel=ccc HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,...
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36
Referer: http://localhost:8080/web02/step04/getpost2.html
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
=> 특징
   1) 대용량의 데이터를 보낼 수 없다. 
      => Request-Line(헤더 포함)의 크기는 보통 8KB로 제한되어 있다.
         (웹 서버마다 제한 크기가 약간씩 다름 ; 무제한은 허용하지 않음)
         (Apache : 8KB, IIS : 16KB)
      => 게시판의 글을 GET 방식으로 보내는 것은 바람직하지 않다.
   2) 바이너리 데이터를 보내기 어렵다.
      => URL에 바이너리 데이터를 직접 포함할 수 없다.
      => 바이너리를 텍스트 형식으로 변환(예: Base64로 인코딩)한 후
         URL에 포함하여 보낼 수는 있다. (번거롭다)
   3) 즐겨찾기에 등록하거나 현재 페이지를 다른 사람에게 보낼 때 적합하다.
      => URL에 파라미터 값이 포함되어 있기 때문에
         URL을 이용하여 바로 해당 페이지로 이동할 수 있다.
         예) 특정 게시물을 가리킬 때
      => 조회 결과를 출력하는 요청에 적합하다.
   4) 보안에 취약하다.
      => URL에 파라미터 값이 포함되어 있기 때문에 화면에 그대로 노출된다.
      => 로그인, 결제 정보를 보낼 때는 적절하지 않다.


# POST 요청의 파라미터
=> POST 요청은 message-body에 파라미터 값을 붙여 보낸다.
=> HTTP 요청 프로토콜
POST /web02/step04/servlet16 HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 26
Cache-Control: max-age=0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,...
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36
Content-Type: application/x-www-form-urlencoded
Referer: http://localhost:8080/web02/step04/getpost2.html
Accept-Encoding: gzip, deflate
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
(CRLF)
name=aaa&email=bbb&tel=ccc
=> 특징
   1) 대용량 데이터를 보낼 수 있다.
      => message-body에 붙여 보내기 때문에 서버가 허용하는 한에는 
         무제한으로 데이터를 보낼 수 있다.
   2) 바이너리 데이터를 보내기 쉽다.
      => 멀티파트 형식으로 바이너리 데이터를 보낸다.
   3) 즐겨찾기에 URL을 저장해도 소용없다.
      => URL에 파라미터 값이 포함되어 있지 않기 때문이다.
      => 조회 결과를 출력하는 요청에 적합하지 않다.
   4) 보안 정보를 보낼 때 GET 방식보다 유리하다.
      => URL에 노출되지 않기 때문이다.


*/