package com.camel.camel_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

class TCPClient extends Thread {

    public static void main(String argv[]) {

        try {
            System.out.println("Staring");
            Socket clientSocket = new Socket("localhost", 7000);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
            Long startTime = System.currentTimeMillis();
            String csvData = "19023,santosh,debit,2000";
            outToServer.writeBytes(csvData + '\n');
            System.out.println("Response from Camel : " + inFromServer.readLine());
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("Total round trip time :" + elapsedTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}