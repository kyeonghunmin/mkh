package step32.exam01;

public abstract class CarFactory {
  
  // 추상클래스 안에 스태틱 메서드
  // instance를 저장하는 역할을 담당한다.
  public static CarFactory newInstance() throws Exception {
    String className = System.getProperty("CarFactory");
    Class<?> clazz = Class.forName(className); // 클래스 로딩
    return (CarFactory)clazz.newInstance(); // 인스턴스 생성 후 리턴
  }
  
  public abstract Car newCar(String name);
}
