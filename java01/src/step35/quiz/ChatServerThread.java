package step35.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
 
public class ChatServerThread implements Runnable {
 
    /*
     * Thread 클래스
     * Socket을 받아 그에 연결된 클라이언트가 보내는 글을 읽고
     * 다시 클라이언트에 전송
     */
    private Socket socket;
     
    public ChatServerThread(Socket socket) {
        this.socket = socket;
    }
 
    private PrintWriter printWriter = null;
     
 
 
    public PrintWriter getPrintWriter() {
        return printWriter;
    }
 
 
    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            while(true){
                String str = bufferedReader.readLine();
                if(str == null){
                    break;
                }
                ServerThreadPool.println(str);
 
            }
              
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            System.out.println("client 해제");
            ServerThreadPool.println("Client 접속 종료");
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(printWriter != null){
                printWriter.close();
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            ServerThreadPool.remove(this);
        }
    }
     
}