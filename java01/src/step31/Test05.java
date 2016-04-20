package step31;

import java.util.Scanner;

public class Test05 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);


    // String regex = "^a\\d"; // 시작 문자가 a, 0 ~ 9까지 숫자
    // String regex = "^\\p{Alpha}\\w";  // 시작 문자가 알파벳, 알파벳 || 숫자
    String regex = "\\wx$"; // 시작 문자가 알파벳 || 숫자, 끝 문자가 x
    
    
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
