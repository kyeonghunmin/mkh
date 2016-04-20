// 주제 : Reflection API - 메서드 정보 추출하기

package step25;

import java.lang.reflect.Method;

public class Test04 {
  
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
  }
  
  public static void main(String[] args) throws Exception {
    Class<?> clazz = Class.forName("step25.Test04$Member");
    // <?> : 어떤 클래스라도 상관 없을 때 사용하는 제네릭
    
    // 메서드 정보 추출
    Method[] methods = clazz.getDeclaredMethods();
    // getDeclaredMethods() : 해당 클래스의 메서드만 추출
    for (Method m : methods) {
      System.out.println(m.getName());
    }
    System.out.println("-------------------");
    
    methods = clazz.getMethods();
    // getMetohds() : 상속받은 public 메서드도 포함하여 추출
    for (Method m : methods) {
      System.out.println(m.getName());
    }
    System.out.println("-------------------");
  }
    

}
