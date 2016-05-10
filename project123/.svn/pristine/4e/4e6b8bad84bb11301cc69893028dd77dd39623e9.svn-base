package bitcamp.pms.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class PMSClient {
  static Scanner keyScan = new Scanner(System.in);
  Socket socket;
  Scanner in;  // Scanner로 입력.
  PrintStream out; // PrintStream으로 출력하기 위함.
  
  public PMSClient(String server, int port) throws Exception {
    socket = new Socket(server, port);
    in = new Scanner(new BufferedInputStream(socket.getInputStream()));
    out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
  }
  
  public void close() {
    try {in.close();} catch (Exception e) {}
    try {out.close();} catch (Exception e) {}
    try {socket.close();} catch (Exception e) {}
  }
  
  public void execute() {
    String command = null;
    
    do {
      command = sendCommand(keyScan);
      receiveMessage();
    } while (!command.equals("quit"));
    
    keyScan.close();
  }
  
  private String sendCommand(Scanner keyScan) {    
    System.out.print("명령? ");
    String command = keyScan.nextLine();
    out.println(command); // 입력받은 command를 서버로 보낸다.
    out.flush();
    return command;
  }
  
  private void receiveMessage() {
    String message = null;
    do {
      message = in.nextLine();  // 서버로부터 message를 받는다.
      System.out.println(message);
    } while (!message.equals("")); // message가 빈문자열이 올때까지 반복.
  }
  
  public static void main(String[] args) {
    System.out.print("서버? ");
    String server = keyScan.nextLine();
    
    System.out.print("포트번호: ");
    int port = Integer.parseInt(keyScan.nextLine());
    
    PMSClient client = null;
    try {
      client = new PMSClient(server, port);
      // 서버주소(String)와 포트번호(int)를 가지고 객체 생성
      client.execute(); // 클라이언트 실행
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      client.close();
    }
  }
}