
// 출처: codefights.com
// 한 줄에 버그가 있다. 고쳐라!
/*
Pick-out the largest even number from an array of integers
Example
maximalEven([4, 3, 6, 8, 2, 4]) = 8
[input] array.integer inputArray
an array of positive integers, it's guaranteed
that inputArray contains at least one even integer
[output] integer
maximal even element of inputArray
*/
package quiz;

public class Test17 {
  static int maximalEven(int[] inputArray) {

    int answer = 0;   // inputArray[0] ---> 0
    for (int i = 0; i < inputArray.length; i++) {
      if (inputArray[i] % 2 == 0 && inputArray[i] > answer) {
        answer = inputArray[i];
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(maximalEven(new int[]{21, 4, 3, 6, 8, 20, 2, 4}));
    //expected output
    //2

  }

}
