// 주제: 맵 의존 객체 주입
package step33.exam06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "step33/exam06/application-context.xml");

    System.out.println(context.getBean("c1"));
  }

}





