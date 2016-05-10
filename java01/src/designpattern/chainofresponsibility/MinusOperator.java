package designpattern.chainofresponsibility;

public class MinusOperator extends AbstractOperator {
  @Override
  public int calculate(String op, int a, int b) throws Exception {
    if (op.equals("-")) {
      return a - b;
    }
    // super : 재정의하기 전에 상속받은 메서드 호출을 뜻함.
    return super.calculate(op, a, b); 
  }
}
