import java.io.*;
import java.net.Socket;

public class client {
    public static DataOutputStream out;
    private static DataInputStream in;
    private static BufferedReader keyboard;

    public static void main(String[] args) throws IOException {
        try {
        Socket client=new Socket("localhost", 9090);

         in= new DataInputStream(client.getInputStream());
         out=new DataOutputStream(client.getOutputStream());
         keyboard=new BufferedReader(new InputStreamReader(System.in));

         String message;
         String key;

             while (true){
                 System.out.println(">");
                 key=keyboard.readLine();
                 out.writeUTF(key);
                 message= in.readUTF();
                 System.out.println("server-> "+ message);
             }
        } catch (IOException e) {
             e.printStackTrace();
         }

    }
}
