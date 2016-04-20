package step27.exam06;

public class Test2 {

  public static void main(String[] args) {
    Class<?> clazz = Member.class;
    
    Component anno = clazz.getAnnotation(Component.class);
    
    System.out.println(anno.value());
    System.out.println(anno.title());
    System.out.println(anno.no());
    
    System.out.println("-----------------------");
    
    clazz = Member2.class;

    anno = clazz.getAnnotation(Component.class);
    
    System.out.println(anno.value());
    System.out.println(anno.title());
    System.out.println(anno.no());
    
  }

}
