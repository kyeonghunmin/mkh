package step35.exam02;

public class ATM extends Thread {
  Account account;
  
  public ATM(String name, Account account) {
    super(name);
    this.account = account;
  }
  
  @Override
  public void run() {
    long sum = 0;
    
    long money = 0;
    
    while ((money = account.withdraw(100)) > 0) {
      sum += money;
    }
    
    System.out.printf("%s: %7d\n", this.getName(), sum);
  }
}

// critical section (critical region)
// - 치명적인 코드블럭.
// - 여러 스레드가 동시에 진입했을 때 공유 객체의 값을 서로 덮어 쓸 수 있다.

// thread safe
// - 여러 스레드가 동시에 진입하여 실행해도 안전한 코드.
// - 보통 조회만 하는 코드인 경우 thread safe에 해당한다.

// 동기화 문제 해결책
// - critical section에 진입을 관리
//   => semaphore n : n개의 진입만 허용
//   => semaphore 1 (mutex[mutual exclusion]) : 1개의 진입만 허용; 상호배제
//      자바는 semaphore 1 만 지원하고 있다.






