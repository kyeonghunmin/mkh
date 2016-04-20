// 주제 : Builder 패턴 적용 후
// => 복잡한 복합 객체를 준비할 때 사용하는 패턴이다.
//    (복잡한 복합 객체 : 여러 객체를 조립하여 하나의 객체를 준비한다는 의미)
// => 복잡한 단순 객체는 "Factory Method" 패턴을 사용한다.

package designpattern.builder.exam02;

public class Test01 {

  public static void main(String[] args) {
    //1) 자동자 공장을 만들어주는 건설사 객체를 준비한다.
    //CarFactoryBuilder builder = new CarFactoryBuilder();
   
    //2) 설계도를 바탕으로 자동차 공장을 준비
    CarFactory factory = new CarFactoryBuilder().build(
        "tico,티코2,900;sonata,소나타2,1999;equs,에쿠스골드,3500");
    
    
    Car c1 = factory.createCar("tico");
    System.out.println(c1);
 
    Car c2 = factory.createCar("sonata");
    System.out.println(c2);
    
    Car c3 = factory.createCar("equs");
    System.out.println(c3);
  }

}