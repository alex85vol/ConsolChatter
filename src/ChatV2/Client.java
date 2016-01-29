package ChatV2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by ovo on 29.01.2016.
 */
public class Client {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 8585);
        InputStream obj = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(obj));
        String str;
        while ((str = br.readLine())!=null)
            System.out.println("From server:=" + str);
        br.close();
        s.close();
    }

}

