
import java.io.IOException;
import java.net.ServerSocket;
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
public class Server {
    static Socket socket;
    static ServerSocket serversocket;
    static Date d1,d2;
    
         
    public static void main(String[] args){
        try{
    serversocket= new ServerSocket(12000);
        }catch(IOException ex)
        {
            ex.printStackTrace();
        }
        while(true){
            try{
                 socket= serversocket.accept();
                 Thread thread= new Thread();
                 thread.start();
                 
                }catch (IOException ex1){
                    ex1.printStackTrace();
                }
           
         }
        
    
    }
    
    
    
}
