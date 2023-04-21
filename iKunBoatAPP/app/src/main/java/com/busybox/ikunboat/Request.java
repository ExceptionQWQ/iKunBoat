package com.busybox.ikunboat;

import java.io.IOException;
import java.net.Socket;

public class Request {
    private static Socket socket;
    private static boolean connectStatus = false;
    private static void Release()
    {
        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void Connect()
    {
        Release();
        try {
            socket = new Socket("192.168.4.1", 8896);
            socket.setSoTimeout(3000);
            connectStatus = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void Send(String msg) throws IOException
    {
        socket.getOutputStream().write(msg.getBytes());
        socket.getOutputStream().flush();
    }
    public static void Request(String msg)
    {
        while (!connectStatus) Connect();
        try {
            Send(msg);
        } catch (IOException e) {
            e.printStackTrace();
            connectStatus = false;
        }
    }
}
