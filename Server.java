import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        // server side socket
        ServerSocket serverSocket=new ServerSocket(1301);

        // receiving or accepting from client
        Socket clientsInfo=serverSocket.accept();  // establishing connection with clients
        Scanner info=new Scanner(clientsInfo.getInputStream());

        // process with the info
        int number1,number2,sum;
        number1= info.nextInt();
        number2= info.nextInt();
        sum=number1+number2;

        // giving back result to client
        PrintStream result=new PrintStream(clientsInfo.getOutputStream());
        result.println(sum);
    }
}
