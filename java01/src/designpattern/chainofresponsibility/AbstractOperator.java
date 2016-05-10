package designpattern.chainofresponsibility;

public abstract class AbstractOperator {
  AbstractOperator nextOperator;
  
  public AbstractOperator setNext(AbstractOperator operator) {
    this.nextOperator = operator;
    return operator; // 다음 operator를 가리키면서 바로 리턴한다.
  }
  
  public int calculate(String op, int a, int b) throws Exception {
    if (nextOperator == null) {
      throw new Exception("지원하지 않는 연산자입니다.");
    }
    return nextOperator.calculate(op, a, b);
  }
}
