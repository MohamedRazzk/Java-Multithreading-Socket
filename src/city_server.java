package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class computer_area_handler implements Runnable
{

    Socket s;

    public computer_area_handler(Socket s)
    {
        this.s = s;
    }

    @Override
    public void run()
    {
        try
        {
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            while (true)
            {

                dos.writeUTF("Data");
                dos.flush();
                String Data = dis.readUTF();
                String[] arrOfStr = Data.split("/", 2);
                System.out.println(Data);
                dos.writeUTF("$Best Way To "+arrOfStr[1]+" From "+arrOfStr[0]+" is City Center Road ");
                dos.flush();

            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}

class city_thread
{


    public static void main(String[] args)
    {
        System.out.println("################# City Server Console ################## RazZk - 16x0103");

        try
        {
            //1.open server socket
            ServerSocket sv = new ServerSocket(9999);
            System.out.println("City Server is running throw port 9999....");

            while (true)
            {
                //2.accept connection
                Socket s = sv.accept();
                System.out.println("Area Computer Accepted ...");
                //3. open thread for this client (s)
                computer_area_handler ch = new computer_area_handler(s);
                Thread t = new Thread(ch);
                t.start();

            }

            //6.close server
            //sv.close();
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
