package step35.quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author nishant
 */
public class PMSClient {
    private final static int PORT = 9999;
 private final static String HOST = "192.168.0.40";
 
 public static void main(String[] args) throws IOException
 {
  try
  {
   
   Socket s = new Socket(HOST, PORT);
   
   System.out.println("You connected to " + HOST);
   
   Clients client = new Clients(s,1);
   Clients clients =new Clients(s,2);
   Thread t1 = new Thread(client);
                        Thread t2 =new Thread(clients);
   t1.start();
   t2.start();
  }
  catch (Exception noServer)
  {
   System.out.println("The server might not be up at this time.");
   System.out.println("Please try again later.");
  }
 }
}
 class Clients implements Runnable {

 private Socket socket;
 int id;
 public Clients(Socket s,int pid)
 {
  socket = s;
                id=pid;
 }
 
 
 public void run()
 {
  try
  {
   Scanner chat = new Scanner(System.in); 
   Scanner in = new Scanner(socket.getInputStream()); 
   PrintWriter out = new PrintWriter(socket.getOutputStream());
   
   while (true)
   { 
                            if(id==1)
                            {
    String input = chat.nextLine();
    out.println(input); 
    out.flush();
                            }
                            if(id==2)
                            {
    if(in.hasNext())
     System.out.println(in.nextLine());
                            }
   }
  }
  catch (Exception e)
  {
   e.printStackTrace();
  }
 }

}