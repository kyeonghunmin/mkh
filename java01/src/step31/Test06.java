package step31;

import java.util.Scanner;

public class Test06 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    
    // String regex = "a*";  // a 문자가 0개 이상
    // String regex = "a+";  // a 문자가 1개 이상
    // String regex = "a?";  // a 문자가 1개 또는 0
    // String regex = "a{3}";  // a 문자가 3개
    // String regex = "a{3,}";  // a 문자가 3개 이상
    String regex = "a{3,6}";  // a 문자가 3 ~ 6개
    
    
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
