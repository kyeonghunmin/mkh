
// 출처: codefights.com
// 한 줄에 버그가 있다. 고쳐라!
/*
Given a string, find the number of different characters in it.
for "cabca" output should be 3
[input] string s
a string of lowercase latin letters
[output] integer
*/
package quiz;

public class Test11 {
  static int differentSymbolsNaive(String s) {

    int result = 0;

    for (int i = 1; i <= 26; i++) {
      boolean found = false;
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == 'a' + (i - 1)) { // i  ===> (i-1)
          found = true;
          break;
        }
      }
      if (found) {
        result++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(differentSymbolsNaive("cabca"));

  }

}
