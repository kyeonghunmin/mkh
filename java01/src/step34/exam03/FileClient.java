package step34.exam03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class FileClient {

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("사용법: FileClient 서버주소 파일경로");
      // 서버주소에 파일경로에 해당하는 파일을 전송한다.
      return;
    }
    
    String serverAddress = args[0];
    File file = new File(args[1]);
    
    if (!file.exists() || !file.isFile()) {
      System.out.println("유효하지 않은 파일경로입니다.");
      return;
    }
    
    Socket socket = null;
    BufferedInputStream fileIn = null;
    // file로부터 읽어서(fileInputStream) Buffered 단위로 읽기위해 데코레이션 패턴 사용
    Scanner in = null; // 서버에서 읽기
    DataOutputStream out = null; // 서버에서 출력
    
    try {
      fileIn = new BufferedInputStream(new FileInputStream(file));
      socket = new Socket(serverAddress, 9999);
      in = new Scanner(socket.getInputStream());
      out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
      
      // 1) 파일명을 보낸다.
      out.writeUTF(file.getName());
      System.out.println("파일명 전송");
      
      // 2) 파일의 크기를 보낸다.
      out.writeLong(file.length());
      System.out.println("파일크기 전송");
      
      // 3) 파일을 전송한다.
      int b;
      while ((b = fileIn.read()) != -1) {
        out.write(b);
        // BufferedOutputStream에서는 내부 버퍼 메모리에 출력 데이터가 꽉 찰 때
        // 서버에 전송한다.
        // write()를 호출할 때 마다 서버에 전송하는 것이 아니다.
        // (1byte 단위로 전송하게 되면 속도가 느려지기 때문) => 반드시 버퍼를 사용할 것!
        // BufferedOutputStream을 붙였기 때문에
        // write()는 1바이트씩 전송하지 않고 버퍼를 이용하여 전송하게 된다.
      }
      
      out.flush(); // 버퍼의 잔여 내용 강제 송출.
                   // 파일 크기가 버퍼의 크기보다 작을 경우 서버로 전송되지 않기 때문에
                   // flush()를 통해 버퍼에 남은 데이터를 송출한다.
      
      String message = in.nextLine();
      if (message.equals("ok")) {
        System.out.println("전송 완료했습니다.");
      } else {
        System.out.println("전송 실패입니다.");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {out.close();} catch (Exception e) {}
      try {in.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
    }
  }
}
