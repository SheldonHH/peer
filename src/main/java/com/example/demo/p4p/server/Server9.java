package com.example.demo.p4p.server;

import com.example.demo.net.i2p.util.NativeBigInteger;
import com.example.demo.p4p.peer.P4PPeer;
import com.example.demo.p4p.user.UserVector2;
import com.example.demo.p4p.util.P4PParameters;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server9 {


    public static void main(String args[]) throws IOException,
            InterruptedException{

        while(true){
            ServerSocket ss=new ServerSocket(8890);
            System.out.println("Server Peer is Awaiting");
            Socket s=ss.accept();
            Multi1 t=new Multi1(s);
            t.start();

            Thread.sleep(2000);
            ss.close();
        }

    }
}
class Multi9 extends Thread{
    private Socket s=null;
    ObjectInputStream infromClient;
    NativeBigInteger g = new NativeBigInteger("3459276026518079674568408512735917085876933054878224377582397778495423201743627684916338757642004215208935956214764216182555928533733818616652879775932081");
    NativeBigInteger h = new NativeBigInteger("1815409602493030510804268646246184547552449386433387561905816534248675443892847368541434018303659631380097127756952567150690215332149993674119991116919571")
;
    int k = 512;     // Security parameter
    int m = 3;      // User vector dimension
    int n = 1;      // Number of users
    int l = 40;      // Bit length of L
    int zkpIterations = 50;
    long L = ((long) 2) << l - 1;
    long F = 0;
    SecureRandom rand = null;
    Multi9() throws IOException{


    }
    Multi9(Socket s) throws IOException{
        this.s=s;
        infromClient = new ObjectInputStream(s.getInputStream());
        P4PParameters.initialize(k, false);
        try {
            rand = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("NoSuchAlgorithmException!");
            ex.printStackTrace();
            rand = new SecureRandom();
        }
        rand.nextBoolean();
        this.F = BigInteger.probablePrime(Math.min(l + 30, 62), rand).longValue();
        NativeBigInteger[] bi = P4PParameters.getGenerators(2);
        g = bi[0];
        h = bi[1];
    }
    public void run(){
        P4PPeer peer = null;
        Object SQL=new String();
        P4PServer server = new P4PServer(m, F, l, zkpIterations, g, h);
        try {
            SQL = infromClient.readObject();
            peer = (P4PPeer) SQL;
            server.compute(peer);
        } catch (IOException ex) {
            Logger.getLogger(Multi1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        System.out.println("Query: " + SQL);
        try {
            System.out.println("Socket Closing");
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Multi1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

//import java.io.*;
//import java.net.*;
//
//// Server class
//class Server {
//    public static void main(String[] args)
//    {
//        ServerSocket server = null;
//
//        try {
//
//            // server is listening on port 1234
//            server = new ServerSocket(1234);
//            server.setReuseAddress(true);
//
//            // running infinite loop for getting
//            // client request
//            while (true) {
//
//                // socket object to receive incoming client
//                // requests
//                Socket client = server.accept();
//
//                // Displaying that new client is connected
//                // to server
//                System.out.println("New client connected"
//                        + client.getInetAddress()
//                        .getHostAddress());
//
//                // create a new thread object
//                ClientHandler clientSock
//                        = new ClientHandler(client);
//
//                // This thread will handle the client
//                // separately
//                new Thread(clientSock).start();
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            if (server != null) {
//                try {
//                    server.close();
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    // ClientHandler class
//    private static class ClientHandler implements Runnable {
//        private final Socket clientSocket;
//
//        // Constructor
//        public ClientHandler(Socket socket)
//        {
//            this.clientSocket = socket;
//        }
//
//        public void run()
//        {
//            PrintWriter out = null;
//            BufferedReader in = null;
//            try {
//
//                // get the outputstream of client
//                out = new PrintWriter(
//                        clientSocket.getOutputStream(), true);
//
//                // get the inputstream of client
//                in = new BufferedReader(
//                        new InputStreamReader(
//                                clientSocket.getInputStream()));
//
//                String line;
//                while ((line = in.readLine()) != null) {
//
//                    // writing the received message from
//                    // client
//                    System.out.printf(
//                            " Sent from the client: %s\n",
//                            line);
//                    out.println(line);
//                }
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//            finally {
//                try {
//                    if (out != null) {
//                        out.close();
//                    }
//                    if (in != null) {
//                        in.close();
//                        clientSocket.close();
//                    }
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}