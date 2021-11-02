package com.company;
import java.awt.desktop.SystemEventListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



class driver_handler implements Runnable
{


    Socket area_socket;
    public driver_handler(Socket s)
    {
        this.area_socket = s;
    }

    @Override
    public void run()
    {

        try
        {

            Socket socket_1 = new Socket("127.0.0.1", 9999);
            DataInputStream input_stream = new DataInputStream(socket_1.getInputStream());
            DataOutputStream output_stream = new DataOutputStream(socket_1.getOutputStream());

            DataInputStream inputStream = new DataInputStream(area_socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(area_socket.getOutputStream());


            String location ;
            while (true)
            {
                String server_message = input_stream.readUTF();


                outputStream.writeUTF("Start Point is Your Location [y/n]:");
                outputStream.flush();
                String location_choice = inputStream.readUTF();

                if (location_choice.equals("n"))
                {
                    outputStream.writeUTF("Set Start Location");
                    outputStream.flush();
                     location = inputStream.readUTF();
                }

                else {
                    outputStream.writeUTF("currentlocation");
                    outputStream.flush();
                     location = inputStream.readUTF();
                }

                outputStream.writeUTF("Set Your Destination ");
                outputStream.flush();
                String dest_location = inputStream.readUTF();


                output_stream.writeUTF(location+"/"+dest_location);
                output_stream.flush();
                server_message = input_stream.readUTF();
                outputStream.writeUTF(server_message);
                outputStream.flush();








                outputStream.writeUTF("Do you Wanna another rute [y/n]?");
                outputStream.flush();
                String usr_choice = inputStream.readUTF();
                //apply checks
                if (usr_choice.equals("n"))
                {
                    outputStream.writeUTF("End");
                    outputStream.flush();
                    break;
                }


            }

            inputStream.close();
            outputStream.close();
            area_socket.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}

class area_thread extends Thread
{

    public void run()
    {
        try
        {
            //1.open server socket
            ServerSocket sv = new ServerSocket(8899);
            System.out.println("Area Server Running Throw port 8899 ....");

            while (true)
            {
                //2.accept connection
                Socket s = sv.accept();
                System.out.println("Driver Client Accepted...");
                //3. open thread for this client (s)
                driver_handler ch = new driver_handler(s);
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



class area_server {


    public static void main(String arg[])
    {
        System.out.println("################# Computer Area Console ################## RazZk - 16x0103");

        area_thread server = new area_thread();
        server.start();



    }
}