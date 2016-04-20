// 주제 : 일반적인 객체 생성 방법 - new 연산자 사용

package designpattern.factorymethod.exam01;

public class Test01 {

  public static void main(String[] args) {
    Car c1 = new Car();
    c1.model = "티코";
    c1.cc = 800;
    
    Car c2 = new Car();
    c2.model = "소나타";
    c2.cc = 1997;

  }

}
