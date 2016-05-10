package step35.quiz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
  ServerSocket serverSocket;
  
  static class MyThread extends Thread {
    Socket socket = null;
    public MyThread(Socket socket) {
      this.socket = socket;
    }
    
    @Override
    public void run() {
      Scanner in = null;
      PrintStream out = null;
      
      try {
        in = new Scanner(new BufferedInputStream(socket.getInputStream()));
        out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
        
        String command = null;
        do {
          command = in.nextLine();
          if (command.equals("quit")) {
            break;
          }
          out.println("haha");
          out.println("너가 보낸 명령어: " + command);
          out.println();
          out.flush();
        } while (!command.equals("quit")); // quit일 때까지 반복한다.
        
        out.println("Good bye!");
        out.println();
        out.flush();
        
        
      } catch (Exception e) {
        System.out.println("클라이언트 통신 오류!");
        
      } finally {
        try {in.close();} catch (Exception e) {}
        try {out.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
      }
    }
  }
  
  public ChatServer() throws Exception {
    serverSocket = new ServerSocket(this.getServerPort());
  }
  
  public void execute() {
    Socket socket = null;

    
    try {
      while (true) {
        socket = serverSocket.accept();
        MyThread t = new MyThread(socket);
        
        t.start();
                
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void close() {
    try {serverSocket.close();} catch (Exception e) {}
  }
  
  private int getServerPort() {
    // java -Dport=8989 -cp ./bin ChatServer
    String value = System.getProperty("port");
    if (value != null) {
      return Integer.parseInt(value);
    }
    return 9999;
  } 
  
  public static void main(String[] args) {
    ChatServer server = null;
    
    try {
      server = new ChatServer();
      System.out.println("ChatServer 실행 중...");
      
      server.execute(); // 클라이언트 요청을 처리하는 부분.      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      server.close();
    }
    
  }

}
