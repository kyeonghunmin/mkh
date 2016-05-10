package designpattern.chainofresponsibility;

public class Test02 {

  public static void main(String[] args) throws Exception {
    AbstractOperator operator = new PlusOperator();
               operator.setNext(new MinusOperator())
                       .setNext(new MultipleOperator())
                       .setNext(new DivideOperator())
                       .setNext(new RemainderOperator());

    // (2 * 3 / 2 + 5 - 7) % 4 = 
    int result = operator.calculate("*", 2, 3);
    result = operator.calculate("/", result, 2);
    result = operator.calculate("+", result, 5);
    result = operator.calculate("-", result, 7);
    result = operator.calculate("%", result, 4);
    System.out.println(result);
  }

}
