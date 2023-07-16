import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        try{
        Socket skt=new Socket("localhost",2004);

            BufferedReader keybr=new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br=new BufferedReader(new InputStreamReader(skt.getInputStream()));
            PrintStream ps=new PrintStream(skt.getOutputStream());

            String msg;
            do{
                msg= keybr.readLine();
                ps.println(msg);
                msg=br.readLine();
                System.out.println("Server send :"+msg);
            }while(!msg.equals("END"));

            skt.close();

        }catch(Exception ignored){};

    }
}
