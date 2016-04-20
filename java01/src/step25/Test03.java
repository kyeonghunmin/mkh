// 주제 : 클래스 정보를 통해서 인스턴스 생성하기

package step25;

public class Test03 {
  
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
    // 1) 클래스 정보 얻기
    Class clazz = Class.forName("step25.Test03$Member");
    
    // 2) 인스턴스 생성하기
    Member m = (Member)clazz.newInstance();
  }
    

}
