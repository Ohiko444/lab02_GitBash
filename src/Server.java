import java.io.*;
import java.net.*;

public class Server {
    private static final int PORT = 444;

    public static void main(String[] args) {
        System.out.println("Сервер запущен и готов к работе...");
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (
                        Socket socket = server.accept();
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    String msg = input.readUTF();
                    output.writeUTF(msg);
                    System.out.println("К нам пришёл " + msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
