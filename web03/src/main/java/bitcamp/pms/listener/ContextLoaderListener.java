package bitcamp.pms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ContextLoaderListener implements ServletContextListener {
  
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 스프링 IoC 컨테이너 준비
    
    // 1) 스프링 설정 파일의 절대 경로 알아내기
    ServletContext servletContext = sce.getServletContext();
    // ServletContext을 알아내서
    // - 절대 경로를 찾고,
    // - 바구니를 만든다.
    String configPath = servletContext.getInitParameter("contextConfigLocation");
    // getInitParameter()가 ServletContext에 있기 때문에
    // sce를 통해서 SErvletContext를 얻고, getInitParameter()를 사용한다.
    // getInitParameter()를 사용하기 위해서 web.xml에서 경로를 지정해 두었다.
    
    
    // 2) 스프링 설정 파일의 경로를 가지고 IoC 컨테이너 객체를 준비한다.
    ApplicationContext applicationContext = 
        new FileSystemXmlApplicationContext(servletContext.getRealPath(configPath));
    // 스프링 객체를 만들려면 절대 경로가 필요한데,
    // 절대 경로를 알아내기 위해 configPath를 만든 것이다.
       
    
    // 3) 모든 서블릿이 스프링 IoC 컨테이너를 사용할 수 있도록 바구니에 저장한다.
    servletContext.setAttribute("iocContainer", applicationContext);
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    
  }
}
