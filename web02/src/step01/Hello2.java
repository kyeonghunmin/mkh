// 서블릿 만들기2 - GenericServlet 추상클래스 상속하기

package step01;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// GenericServlet : serializable, servlet 인터페이스를 구현함.
// serializable 인터페이스를 구현했기 때문에 Hello2 클래스는 다른 Tomcat등으로 복제될 수 있다.
// (serializable 인터페이스를 구현하면 serialize를 수행할 수 있고, 결국 복제가 가능하다)
// GenericServlet이 5개의 메서드를 다 구현했기 때문에 service부분만 신경쓰면 된다.
public class Hello2 extends GenericServlet { 
  
  // serializable을 구현했다면 버전정보를 포함하는 것이 좋다.
  private static final long serialVersionUID = 1L; // 버전은 직접 지정한다.

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("Hello2 service()");
  }
}

/*
# GenericServlet 추상 클래스
- Servlet 인터페이스를 미리 구현한 클래스.
- Servlet 인터페이스를 구현하는 번거로움을 줄이는 용도.
  즉 개발자가 직접 Servlet 인터페이스를 구현하는 것 보다
  GenericServlet을 상속하여 service()를 구현하는 것이 더 편리하다.
 
# GenericServlet 추상 클래스와 Serializable 인터페이스
- GenericServlet 클래스는 기본으로 Serializable을 구현했기 때문에,
  이 클래스를 상속하는 서브 클래스는 가능한 데이터의 시리얼 버전을 지정하라!
  => static final long serialVersionUID 변수의 값을 지정하라!
  이유?
  deserialize 하는 쪽에서 데이터의 버전을 확인하여 인스턴스 객체로 만들 때
  참고할 수 있도록 하기 위함이다.
- serializable 을 구현하는 클래스는 가능한 시리얼 버전serialVersionUID을 지정하라!


**
Member 객체 ---(App; serialize -> byte 배열로 변환)---> File ---(App; deserialize -> byte 배열로 변환)---> Member 객체
               (버전정보도 포함)                                (버전정보도 포함)
               
* 서블릿과 시리얼라이즈
Tomcat을 하나 이상 실행하는 경우,
서블릿을 복사하여 다른 Tomcat 서버로 옮길 때 : serialize
받는 Tomcat은 deserialize

한 서블릿 컨테이너에서 문제가 발생하면,
다른 서블릿 컨테이너로 현재 실행중인 서블릿을 옮겨야 한다.
=> serialize -> deserialize
그래서 서블릿은 기본으로 serializable 구현체로 만든다.
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
                       
                       
*/