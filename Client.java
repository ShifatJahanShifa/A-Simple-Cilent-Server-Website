import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        // creating client side socket = local host ip + port number
        Socket socket=new Socket("127.0.0.1",1301);

        // taking input from client
        Scanner input=new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int number1,number2;
        number1= input.nextInt();
        number2= input.nextInt();

        // giving information to server
        PrintStream toServer=new PrintStream(socket.getOutputStream());
        toServer.println(number1);
        toServer.println(number2);

        // receiving information from server
        Scanner receiver=new Scanner(socket.getInputStream());
        int result= receiver.nextInt();
        System.out.println("sum of the two numbers is: "+result);
    }
}
