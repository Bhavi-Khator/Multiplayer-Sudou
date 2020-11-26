
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class HandlClient implements Runnable{
      private Socket socket;
    ObjectInputStream objectInputStream;
    ObjectOutputStream outputstream;

    public HandlClient(Socket socket) {
        this.socket = socket;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            outputstream= new ObjectOutputStream(socket.getOutputStream());      
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                Date time = (Date) objectInputStream.readObject();
                
                System.out.println("Message received");
                System.out.println(time);
                boolean first=false;
                if(Server.d1==null){
                    Server.d1=time;
                    first=true;
                }
                  else
                     Server.d2=time;
                    while(Server.d1==null|| Server.d2==null){
                                             
                        
                    }
                    if(first==true){
                        if(Server.d2.getTime()>Server.d1.getTime()){
                            outputstream.writeObject("You won");
                        }
                        else
                              outputstream.writeObject("You lost");
                    }
                
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    
    
}
}
