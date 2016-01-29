package ChatV2;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ovo on 29.01.2016.
 */
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8585);
        Socket s = ss.accept();
        System.out.println("Conection established");
        OutputStream obj = s.getOutputStream();
        PrintStream ps = new PrintStream(obj);
        String str = "Hello client";
        ps.println(str);
        ps.println("Bye");
        ps.close();
        ss.close();
        s.close();
    }


}
