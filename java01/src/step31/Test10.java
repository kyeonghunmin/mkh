package step31;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test10 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    // \b : 스페이스로 구분
    // Pattern pattern = Pattern.compile("\\babc\\b");
    // \b : 스페이스 뒤에 abc가 오는 경우를 찾는다.
    //      abc 뒤에 붙을 경우 abc 뒤에 스페이스가 오는 경우를 찾는다.
    
    Pattern pattern = Pattern.compile("\\b\\d{4}-\\d\\d?-\\d\\d?\\b");
    
    Matcher matcher = null;
    
    String input = null;
    
    while (true) {
      System.out.print("입력: ");
      input = keyScan.nextLine();
      if (input.equals("quit"))
        break;
      matcher = pattern.matcher(input);
      while (matcher.find()) {
        System.out.println(matcher.group());  // 찾은 값을 리턴
      }
    }
    
    keyScan.close();
  }

}
