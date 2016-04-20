package step31;

import java.util.Scanner;

public class Test04 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    // 미리 정의된 문자 집
    // String regex = "[0-9]"; // 0부터 9까지의 한 개 문자
    // String regex = "\\d"; // 0에서 9까지 문자 집합을 의미
    // String regex = "[a-zA-Z_0-9]";
    // String regex = "\\w";
    // String regex = "."; // 어떤 문자
    String regex = "\\."; // '.' 문자 한 개
    
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
