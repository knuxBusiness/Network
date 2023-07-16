import java.net.ServerSocket;
import java.net.Socket;

public class Demo {
    public static void main(String[] args) {
        Socket skt;
        int count=1;
        do {
            try {
                ServerSocket ss = new ServerSocket(2004);
                skt = ss.accept();
                System.out.println("Client Connected :" + count++);
                MyServer sr = new MyServer(skt);
                sr.start();
            } catch (Exception ignored) {
            };
        }while(true);
    }
}
