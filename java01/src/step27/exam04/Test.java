// 실행 중에 애노테이션 정보 추출하기

package step27.exam04;

import java.lang.annotation.Annotation;

public class Test {

  public static void main(String[] args) {
    
    Class<?> clazz = Member.class;
    
    Annotation[] annos = clazz.getAnnotations();
    
    for (Annotation anno : annos) {
      System.out.println(anno.toString());
    }
  }

}
