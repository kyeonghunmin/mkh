package step22;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {

  public static void main(String[] args) throws IOException {
    FileOutputStream out = new FileOutputStream("exam02.Test02.data");
    
    int value = 0x2a3b4c5d;
    
    out.write(value >> 24);
    out.write(value >> 16);
    out.write(value >> 8);
    out.write(value);
    
    out.close();
  }

}
