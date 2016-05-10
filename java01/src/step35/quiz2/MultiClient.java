package step35.quiz2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class MultiClient {

  static boolean chatmode = false;
  static int chatState = 0;

  public static void main(String[] args) throws Exception {

    try {
      String ServerIP = "192.168.0.13";
      Socket socket = new Socket(ServerIP, 9999);
      System.out.println("연결 성공!");

      Thread sender = new Sender(socket);
      Thread receiver = new Receiver(socket);

      sender.start();
      receiver.start();

    } catch (Exception e) {
      System.out.println("오류 발생!" + e);
    }
  }
}

class Receiver extends Thread {
  Socket socket;
  DataInputStream in;

  public Receiver(Socket socket) {
    this.socket = socket;

    try {
      in = new DataInputStream(this.socket.getInputStream());
    } catch (Exception e) {
      System.out.println("오류 발생!" + e);
    }
  }

  public String[] getMsgParse(String msg) {
    String[] tmpArr = msg.split("[|]");

    return tmpArr;
  }

  @Override
  public void run() {
    while (in != null) {
      try {
        String msg = in.readUTF();
        String[] msgArr = getMsgParse(msg.substring(msg.indexOf("|") + 1));

        if (msg.startsWith("logon#yes")) {
          MultiClient.chatState = 1;
          System.out.println(msgArr[0]);
          System.out.print("입력(enter) : ");

        } else if (msg.startsWith("logon#no")) {

          MultiClient.chatState = 0;
          System.out.println("중복된 이름이 존재합니다\n이름을 다시 입력해 주세요:");
        } else if (msg.startsWith("enterRoom#yes")) {

          System.out.println("채팅방에 입장하였습니다.(종료: /exit)");
          MultiClient.chatState = 2;

        } else if (msg.startsWith("enterRoom#no")) {
          System.out.println("잘못된 입력입니다.");
          System.out.println("입장하시려면 enter 을 입력해 주세요");
          System.out.print("입력(enter) : ");
        } else if (msg.startsWith("show")) {

          System.out.println(msgArr[0]);

        } else if (msg.startsWith("say")) {
          System.out.println("[" + msgArr[0] + "] " + msgArr[1]);

        } else if (msg.startsWith("req_exit")) {
        }

      } catch (SocketException e) {
        System.out.println("오류 발생!" + e);
        System.out.println("서버와 연결이 끊어졌습니다.");
        return;

      } catch (Exception e) {
        System.out.println("오류 발생!" + e);

      }
    }
  }
}

class Sender extends Thread {
  Socket socket;
  DataOutputStream out;
  String name;

  public Sender(Socket socket) {
    this.socket = socket;
    try {
      out = new DataOutputStream(this.socket.getOutputStream());

    } catch (Exception e) {
      System.out.println("오류 발생!" + e);
    }
  }

  @Override
  public void run() {
    @SuppressWarnings("resource")
    Scanner s = new Scanner(System.in);
    System.out.print("이름을 입력해 주세요: ");

    while (out != null) {
      try {
        String msg = s.nextLine();

        if (msg == null || msg.trim().equals("")) {
          msg = " ";
        }

        if (MultiClient.chatState == 0) {
          if (!msg.trim().equals("")) {
            name = msg;
            out.writeUTF("req_logon|" + msg);
          } else {
            System.out.println("이름을 입력하세요");
            System.out.print("입력: ");
          }
        } else if (MultiClient.chatState == 1) {
          if (!msg.trim().equals("")) {
            out.writeUTF("req_enterRoom|" + name + "|" + msg);
          } else {
            System.out.println("입장하시려면 enter를 입력해주세요");
            System.out.print("입력: ");
          }
        } else if (msg.trim().startsWith("/")) {
          if (msg.equalsIgnoreCase("/exit")) {
            System.out.println("채팅을 종료합니다.");
            System.exit(0);
            break;
          } else {
            out.writeUTF("req_cmdMsg|" + name + "|" + msg);
          }
        } else {
          out.writeUTF("req_say|" + name + "|" + msg);
        }

      } catch (SocketException e) {
        System.out.println("오류 발생!" + e);
        System.out.println("서버와 연결이 끊어졌습니다.");
        return;
      } catch (IOException e) {
        System.out.println("오류 발생!" + e);
      }
    }
  }
}
