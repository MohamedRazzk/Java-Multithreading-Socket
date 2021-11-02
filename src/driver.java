package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class driver
{
    public static void main(String[] args)
    {
        System.out.println("################# Driver Console ################## RazZk - 16x0103");


        Scanner sc = new Scanner(System.in);
        try
        {
            Socket socket_1 = new Socket("127.0.0.1", 8899);
            DataInputStream input_stream = new DataInputStream(socket_1.getInputStream());
            DataOutputStream output_stream = new DataOutputStream(socket_1.getOutputStream());
            while (true)
            {
                String server_message = input_stream.readUTF();



                if(server_message.equals("currentlocation"))
                {

                    output_stream.writeUTF("my_location");
                    output_stream.flush();
                }


                else if(server_message.equals("End"))
                {
                    System.out.println("Session Terminated");
                    break;
                }

                else if(server_message.contains("$"))
                {
                    System.out.println(server_message);

                }

                else {
                    System.out.println(server_message);
                    String usr_msg = sc.next();
                    output_stream.writeUTF(usr_msg);
                    output_stream.flush();
                }
            }
            input_stream.close();output_stream.close();socket_1.close();

        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
