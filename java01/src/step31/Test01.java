package step31;

import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    // "문자/문자열" --> 지정된 문자/문자열과 일치할 때만 true 리턴
//    String regex = "a";
//    String regex = "abc";
    String regex = "a\\b\\c"; // -> a\b\c 가 리턴된다. (정규식 표현이 아님)
    
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
