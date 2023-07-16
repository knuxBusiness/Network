import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyServer extends Thread{
    Socket skt;
    public MyServer(Socket s){
        skt=s;
    }

    public void run() {
        try{
        BufferedReader br=new BufferedReader(new InputStreamReader(skt.getInputStream()));
        PrintStream ps=new PrintStream(skt.getOutputStream());
        String msg;
        do{
            msg=br.readLine();
            if(msg.equals("hi")){
                msg="hello";
                ps.println(msg);
            }
            else{
                msg=msg.toUpperCase();
                ps.println(msg);
            }
        }while(!msg.equals("END"));
        skt.close();
        }catch(Exception ignored){};
    }
}
