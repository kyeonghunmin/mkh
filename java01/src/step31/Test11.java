package step31;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test11 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    // (?<이름>패턴)
    Pattern pattern = Pattern.compile(
        "\\b(?<year>\\d{4})-(?<month>\\d\\d?)-(?<day>\\d\\d?)\\b");
    
    Matcher matcher = null;
    
    String input = null;
    
    while (true) {
      System.out.print("입력: ");
      input = keyScan.nextLine();
      if (input.equals("quit"))
        break;
      matcher = pattern.matcher(input);
      while (matcher.find()) {
        System.out.printf("%s, %s, %s, %s\n",
            matcher.group(), matcher.group("year"),
            matcher.group("month"), matcher.group("day")); 
      }
    }
    
    keyScan.close();
  }

}
