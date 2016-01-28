package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ConcurrentModificationException;
import java.util.Scanner;


/**
 * Created by ovo on 22.01.2016.
 */
public class Client {
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;

    public Client() throws ConcurrentModificationException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter IP for connection to server.");
        System.out.println("Format: xxx.xxx.xxx.xxx");

        String ip = scan.nextLine();

        try {

            socket = new Socket(ip, main.Const.Port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Enter your nickname:");
            out.println(scan.nextLine());
            Resender resend = new Resender();
            resend.start();
            String str = "";
            while (!str.equals("exit")) {
                str = scan.nextLine();
                out.println(str);
            }
            resend.setStop();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }


    private void close() throws ConcurrentModificationException {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("��⮪� �� �뫨 �������!");
        }
    }


    private class Resender extends Thread {

        private boolean stoped;


        public void setStop() {
            stoped = true;
        }


        @Override
        public void run()throws ConcurrentModificationException {
            try {
                while (!stoped) {
                    String str = in.readLine();
                    System.out.println(str);
                }
            } catch (IOException e) {
                System.err.println("Error of receiving message.");
                e.printStackTrace();
            }
        }
    }
}
