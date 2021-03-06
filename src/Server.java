import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static DataOutputStream out;
    private static DataInputStream in;
    private static BufferedReader keyboard;
    public static void main(String[] args) throws IOException {
        try{
            System.out.println("waiting for user to connect");
            ServerSocket server=new ServerSocket(9090);
            Socket client=server.accept();
            System.out.println("Server connected");

            in= new DataInputStream(client.getInputStream());
            out=new DataOutputStream(client.getOutputStream());
            keyboard=new BufferedReader(new InputStreamReader(System.in));
            String clientMessage;
            String key;
            while (true){
                clientMessage=in.readUTF();
                System.out.println(clientMessage);

                System.out.println(">");
                keyboard.readLine();
                key= String.valueOf(keyboard);
                out.writeUTF(key);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
