// 주제 : JVM의 기본 스레드들 조사

package step35.exam01;

public class Test01 {

  public static void main(String[] args) {
    // 1) main()을 실행하는 현재 스레드 알아내기 "main"
    Thread currThread = Thread.currentThread();
    System.out.printf("T(%s)\n", currThread.getName());
    
    // 2) "main" 스레드가 소속된 스레드 그룹을 알아내기 
    ThreadGroup mainTG = currThread.getThreadGroup();
    System.out.printf("TG:%s\n", mainTG.getName());
    
    // 3) "main" 스레드 그룹에 소속된 자식 스레드 알아내기
    Thread[] childThreads = new Thread[10];
    int count = mainTG.enumerate(childThreads);
    for (int i = 0; i < count; i++) {
      System.out.printf("main => T(%s)\n", childThreads[i].getName());
    }
    
    // 4) "main" 스레드 그룹에 소속된 자식 스레드 그룹들 알아내기
    ThreadGroup[] childTGs = new ThreadGroup[10];
    count = mainTG.enumerate(childTGs);
    for (int i = 0; i < count; i++) {
      System.out.printf("main => TG: %s\n", childTGs[i].getName());
    }
    
    // 5) "main" 스레드 그룹의 부모 스레드 그룹을 알아내기
    ThreadGroup systemTG = mainTG.getParent();
    System.out.printf("TG: %s\n", systemTG.getName());
    
    // 6) "system" 스레드 그룹의 자식 스레드 알아내기
    count = systemTG.enumerate(childThreads, false); // false : system의 자식만 출력; true : 밑에 모든 자식들까지 출력
    for (int i = 0; i < count; i++) {
      System.out.printf("system => T(%s)\n", childThreads[i].getName());
    }
    
    // 7) "system" 스레드 그룹의 자식 스레드 그룹 알아내기
    count = systemTG.enumerate(childTGs, false);
    for (int i = 0; i < count; i++) {
      System.out.printf("system => TG: %s\n", childTGs[i].getName());
    }
    
    // 8) "system" 스레드 그룹의 부모 스레드 그룹 알아내기
    ThreadGroup parentTG = systemTG.getParent();
    System.out.printf("TG: %s\n", parentTG.getName());
  }

}

/* 
# JVM 기본 스레드와 스레드 그룹
=> TG: system
    => T(Reference Handler) : 인스턴스의 레퍼런스를 관리
    => T(Finalizer)         : 가비지 수집 
    => T(Signal Dispatcher)
    => T(Attach Listener)
    => TG: main
        => T(main)          : main() 실행
*/