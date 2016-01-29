package ChatV1;


import java.util.Scanner;

/**
 * Created by ovo on 22.01.2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Start programm in server or ChatV1 mode ? (S(erver) / C(lient))");
        while (true) {
            char answer = Character.toLowerCase(in.nextLine().charAt(0));
            if (answer == 's') {
                new Server();
                break;
            } else if (answer == 'c') {
                new Client();
                break;
            } else {
                System.out.println("You made wrong choice. Please choose S or C");
            }
        }
    }

}
