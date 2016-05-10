package designpattern.chainofresponsibility;

public class Test01 {

  public static void main(String[] args) throws Exception {
    PlusOperator op1 = new PlusOperator();
    MinusOperator op2 = new MinusOperator();
    MultipleOperator op3 = new MultipleOperator();
    DivideOperator op4 = new DivideOperator();
    RemainderOperator op5 = new RemainderOperator();
    
    // 각 객체를 체인처럼 연결한다.
    op1.setNext(op2);
    op2.setNext(op3);
    op3.setNext(op4);
    op4.setNext(op5);
    
    // (2 * 3 / 2 + 5 - 7) % 4 = 
    int result = op1.calculate("*", 2, 3);
    result = op1.calculate("/", result, 2);
    result = op1.calculate("+", result, 5);
    result = op1.calculate("-", result, 7);
    result = op1.calculate("%", result, 4);
    System.out.println(result);
  }

}
