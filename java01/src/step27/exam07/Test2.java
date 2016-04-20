package step27.exam07;

public class Test2 {

  public static void main(String[] args) {
    Class<?> clazz = Member.class;
    
    Component anno = clazz.getAnnotation(Component.class);
    
    String[] list = anno.value();
    
    for (String s : list) {
      System.out.println(s);
    }
    
  }

}
