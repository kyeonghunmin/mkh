package step34.quiz;

import org.omg.IOP.Encoding;

public class Test {

  public static void main(String[] args) throws Exception {
    String a = "고양";
    System.out.println(new String(a.getBytes("utf-8"), "ksc5601"));

    
    String b = "B0EDBEE7";
    System.out.println(new String(b.getBytes("ksc5601"), "utf-8"));
    
    
    
    
    
    
  }

}
