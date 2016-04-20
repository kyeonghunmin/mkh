// 주제 : 싱글톤 패턴 적용

package designpattern.singleton;

public class Test01 {

  public static void main(String[] args) {
    // 싱글톤 방식으로 객체 생성 (공장 여러개 생성)
    // 같은 주소를 같는 인스턴스가 생성된다.
    CarFactory factory = CarFactory.newInstance();
    CarFactory factory2 = CarFactory.newInstance();
    CarFactory factory3= CarFactory.newInstance();
    
    if (factory == factory2 && factory == factory3) {
      System.out.println("factory == factory2 == factory3, 같은 인스턴스");
    }
    
    Car c1 = factory.newCar("tico");

    Car c2 = factory.newCar("sonata");
  }

}

/*
# 싱글톤
- 객체를 오직 한 개만 생성할 경우 사용한다.
- 최근에는 싱글톤 패턴을 지양하는 추세이다.
  이유?  빈 컨테이너로 객체를 관리하기 때문.
*/

// dom tree : xml 전체를 읽어서 특정 부분을 수정할 때 사용
// sax tree : 순차적으로 읽어들여 수정할 때 사용 (지나간 부분은 다시 읽지 않음)