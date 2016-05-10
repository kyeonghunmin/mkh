package step34.quiz;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class DicServer {

  public static void main(String[] args) {
    ServerSocket serverSocket = null;
    Socket socket = null;
    
    try {
      System.out.println("서버 준비 중...");
      serverSocket = new ServerSocket(9999);
      while (true) {
        System.out.println("클라이언트 대기 중...");
        socket = serverSocket.accept();
        echo(socket);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {serverSocket.close();} catch (Exception e) {}
    }
  }
  
  private static void echo(Socket socket) {
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
          
        String result = toKor(message);
        String[] subs = result.split("\t\t\t\t\t\t\t\t");

        out.println("날씨: " + tagCut("<td>", "</td>", subs[7]));
        out.println("기온: " + tagCut("<td>", "&nbsp;</td>", subs[12]));
        out.println("습도: " + tagCut("<td>", "&nbsp;</td>", subs[15]));
        out.println("풍향: " + tagCut("<td>", "&nbsp;</td>", subs[16]));
        out.println("풍속: " + tagCut("<td>", "&nbsp;</td>", subs[17]));
      }
      
    } catch (Exception e) {
      System.out.println("클라이언트 통신 오류!");
    } finally {
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
    }
  }
  
  private static String toKor(String word) throws UnsupportedEncodingException {
    Socket socket = null;
    Scanner in = null;
    PrintStream out = null;
    
    try {
      socket = new Socket("weather.ytn.co.kr", 80);
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
      out.print("GET /forecast/forecast01.html HTTP/1.1\n");
      out.println("Host: weather.ytn.co.kr");
      out.println();
      
      StringBuilder buffer = new StringBuilder();
      String line;
      try {
        while (true) {
          line = in.nextLine();
          buffer.append(line);
        }
      } catch (Exception e) {}
      
      String weatherTable = tagCut("<table class=\"default\" cellspacing=\"0\" cellpadding=\"0\">", "</table>", buffer.toString());
      
      String locationRow = tagCut(word, "</tr>", weatherTable);

      return locationRow;
      
    } catch (Exception e) {
      e.printStackTrace();

    } finally {  
      try {out.close();} catch (Exception e) {}
      try {in.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
    }
    return "실행 오류!";
  }
  
  private static String tagCut(String start, String end, String buffer) {
    String startTag = start;
    String endTag = end;
    int startIndex = buffer.indexOf(startTag);
    int endIndex = buffer.indexOf(endTag, startIndex);
    
    return buffer.substring(startIndex + startTag.length(), endIndex).trim();
  }
}