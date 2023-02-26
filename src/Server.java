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
                    String name = input.readUTF();
                    output.writeUTF(name);
                    System.out.println("К нам пришёл " + name);

                    if (!name.equals("admin")){

                        String msg = input.readUTF();
                        output.writeUTF(msg);
                        int i = 0;

                        while (!msg.equals("bye")){
                            i++;
                            System.out.println("Получено сообщение №" + i + " - " + msg);
                            msg = input.readUTF();
                            output.writeUTF(msg);
                        }
                        System.out.println("Пока, " + name);

                    } else {

                        String msg = input.readUTF();
                        output.writeUTF(msg);

                        while (!msg.equals("exit")) {
                            int i = 0;

                            while (!msg.equals("bye") && !msg.equals("exit")){
                                i++;
                                System.out.println("Получено сообщение №" + i + " - " + msg);
                                msg = input.readUTF();
                                output.writeUTF(msg);
                            }
                            System.out.println("Пока, " + name);
                            break;
                        }

                        if (msg.equals("exit")){
                            System.out.println("admin завершил работу сервера");
                            socket.close();
                            input.close();
                            output.close();
                            break;
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
