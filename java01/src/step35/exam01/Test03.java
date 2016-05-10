// 주제 : 스레드를 정의하는 방법1 => 스레드 상속하기

package step35.exam01;

public class Test03 {
  
  // Thread를 상속받아 run()을 재정의한다.
  static class MyThread extends Thread {
    @Override
    public void run() {
      for (int i = 0; i < 10000; i++) {
        Math.random();
        System.out.println("==>" + i);
        Math.asin(0.5);
      }
    }
  }

  public static void main(String[] args) {
    MyThread t = new MyThread();
    t.start();
    
    for (int i = 0; i < 10000; i++) {
      Math.random();
      System.out.println(i);
      Math.asin(0.5);
    }
  }

}