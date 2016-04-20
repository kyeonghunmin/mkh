package step31;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test12 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    // (?=패턴)
    // Pattern pattern = Pattern.compile("(?=abc)abcok");
    // abc를 찾고, 그 중 abcok를 찾아 리턴한다.
    
    // Pattern pattern = Pattern.compile("(?=\\d)"); // 숫자 한 개를 찾는다.
                                    // 찾은 후 값을 캡쳐(보관)하지는 않는다.
    
    // Pattern pattern = Pattern.compile("(?=\\d)\\d"); // 값을 캡쳐한다.
    
    
    // (?=검색패턴)대상패턴
    //Pattern pattern = Pattern.compile("(?=abc)abcok");
    //=> 숫자 1개를 찾아라. 단 값을 캡쳐하지는 말아라!
    //Pattern pattern = Pattern.compile("(?=\\d)");
    //=> 숫자 1개를 찾아라. 값을 캡쳐하라!
    //Pattern pattern = Pattern.compile("(?=\\d)\\d");
    //=> 숫자 1개 포함, 대소문자 1개 포함, 특수문자(!@?) 1개 포함
    //   단 숫자,대소문자,!@? 문자만 사용할 수 있다. 
    //Pattern pattern = Pattern.compile(
    //    "(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@?])[0-9a-zA-Z!@?]{개수}");
    
    
    Matcher matcher = null;
    Pattern pattern = null;
    
    String input = null;
    String regex = null;
    while (true) {
      System.out.print("입력: ");
      input = keyScan.nextLine();
      
      if (input.equals("quit"))
        break;
      
      regex = String.format(
      "(?=.*\\d)(?=.*\\p{Alpha})(?=.*[!@?])[a-zA-Z0-9!@?]{%d}", input.length()); 
      pattern = Pattern.compile(regex);
      
      matcher = pattern.matcher(input);
      if (matcher.find()) {
        System.out.println(matcher.group());
            // 시작인덱스, 끝인덱스
            // 4~5 : 4이상 5미만을 의미
      }
    }
    
    keyScan.close();
  }

}

// http://www.getproxy.jp/kr/korea
// 아이피, 포트번호 복사
// window --> preference --> general --> network connections --> manual
// --> http 에 아이피, 포트번호 붙여넣기
// help --> eclipse marketplace에서 regex 설치