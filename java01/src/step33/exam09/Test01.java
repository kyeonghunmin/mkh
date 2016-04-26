// 주제: @Autowired 애노테이션을 이용한 의존 객체 주입을 설정하기
package step33.exam09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "step33/exam09/application-context.xml");

    printAllObjects(context);
    System.out.println("-----------------------");    
    
    System.out.println(context.getBean("c1"));
    System.out.println(context.getBean("e1"));
  }

  private static void printAllObjects(ApplicationContext ctx) {
    String[] names = ctx.getBeanDefinitionNames();
    for (String name : names) {
      System.out.printf("%s : %s\n",
          name, ctx.getBean(name).getClass().getName());
    }
  }
}