package step31;

import java.util.Scanner;

public class Test03 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    // 문자 집합
    // String regex = "[abc]"; // a || b || c
    // String regex = "[^abc]"; // a, b, c를 제외한 문자
    // String regex = "[a-z]"; // a에서 z까지의 문자 한 개
    // String regex = "[a-zA-Z]"; // a에서 z, A에서 Z까지의 문자 한 개
    // String regex = "[a-d[x-z]]"; // a에서 d까지, x에서 z까지의 문자 한 개
    // String regex = "[a-dx-z]"; // (위와 동일)
    String regex = "[a-f&&[d-m]]"; // 교집합 (공통된 부분만 true; d, e, f 중 한 개)
    String input = null;
    
    while (true) {
      System.out.print("입력: ");
      input = keyScan.nextLine();
      if (input.equals("quit"))
        break;
      System.out.println(input.matches(regex));
    }
    
    keyScan.close();
  }

}
