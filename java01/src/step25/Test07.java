// 주제 : Reflection API - 특정 메서드만 알아내기

package step25;

import java.lang.reflect.Method;

public class Test07 {
  
  static class Member {
    public static int count;
    
    String name;
    
    public Member() {
      System.out.println("Member()");
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
    
    public void setName(String firstName, String middleName, String lastName) {
      this.name = firstName + " " + middleName + " " + lastName;
    }
  }
  
  public static void main(String[] args) throws Exception {
    Class<?> clazz = Class.forName("step25.Test07$Member");
    
    // 1) "".getClass()
    // 2) String.class
    // 3) Class.forName("java.lang.String"));
    // 메서드의 이름과 그 메서드의 파라미터 타입 정보를 주면
    // 클래스에서 해당 메서드 정보를 찾아서 리턴한다.
    Method m1 = clazz.getDeclaredMethod("setName", String.class);
    // --> void setName(String name) {} 을 가리킨다.
    
    Method m2 = clazz.getDeclaredMethod("setName", String.class, String.class, String.class);
    // --> void setName(String firstName, String middleName, String lastName) {}
    //     을 가리킨다.
    
    //Method m3 = clazz.getDeclaredMethod("setName", int.class);
    // --> void setName(int value) {} 를 가리키는데, 존재하지 않기 때문에 실행오류
  }
    

}
