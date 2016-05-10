package step35.exam03;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

  public static void main(String[] args) {
    ServerSocket serverSocket = null;
    Socket socket = null;
    
    try {
      System.out.println("서버 준비 중...");
      serverSocket = new ServerSocket(9999);
      
      while (true) {
        System.out.println("클라이언트 대기 중...");
        socket = serverSocket.accept();
        
        new ClientThread(socket).start(); // start() 내부에서 run()을 호출한다.
        // MyThread가 클라이언트와 통신을 하게 된다.
        // => 클라이언트마다 MyThread를 생성한다.
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {serverSocket.close();} catch (Exception e) {}
    }

  }
  
  static class ClientThread extends Thread {
    Socket socket;
    
    public ClientThread(Socket socket) {
      this.socket = socket;
    }
    
    @Override
    public void run() {
      Scanner in = null;
      PrintStream out = null;
      String message = null;
      
      try {
        in = new Scanner(socket.getInputStream());
        out = new PrintStream(socket.getOutputStream());
        
        while (true) {
          message = in.nextLine();
          
          if (message.equals("quit")) {
            out.println("즐거운 하루되세요.");
            break;          
          }
          
          out.println(toKor(message));
        }
        
      } catch (Exception e) {
        System.out.println("클라이언트 통신 오류!");
        
      } finally {
        try {out.close();} catch (Exception e) {}
        try {in.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
      }
    }
  }
  
  private static String toKor(String word) {
    Socket socket = null;
    Scanner in = null;
    PrintStream out = null;
    
    try {
      socket = new Socket("endic.naver.com", 80);
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
      out.printf("GET /search.nhn?sLn=kr&searchOption=all&query=%s\n", word);
      out.println("Host: endic.naver.com");
      out.println();
      
      // 네이버의 응답을 버퍼에 저장한다.
      StringBuilder buffer = new StringBuilder();
      String line;
      try {
        while (true) {
          line = in.nextLine(); // 서버의 응답정보를 line에 담는다.
          buffer.append(line); // 버퍼에 line을 담는다.
          System.out.println(line);
        }
        
      } catch (Exception e) {}
      
      // 버퍼에 저장된 내용을 분석하여 한국어 번역 부분을 발췌한다.
      String startTag = "<span class=\"fnt_k05\">";
      String endTag = "</span>";
      int startIndex = buffer.indexOf(startTag);
      int endIndex = buffer.indexOf(endTag, startIndex);
      
      return buffer.substring(startIndex + startTag.length(), endIndex);
      // startIndex는 시작위치이기 때문에 그 길이만큼 더해주어야 한다.
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {out.close();} catch (Exception e) {}
      try {in.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
    }
    return "실행 오류!";
  }
  
}