import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 444;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output  = new DataOutputStream(socket.getOutputStream())
        ) {
            Scanner inp = new Scanner(System.in);
            System.out.println("Как Вас зовут?");
            String msg = inp.nextLine();

            output.writeUTF(msg);
            String receivedMsg = input.readUTF();

            System.out.println("Привет, " + receivedMsg);

            if (!receivedMsg.equals("admin")){

                String word = inp.nextLine();
                output.writeUTF(word);
                receivedMsg = input.readUTF();

                int i = 0;

                while (!word.equals("bye")){
                    i++;
                    System.out.println("Ответ сервера: " + i + " - " + receivedMsg);
                    word = inp.nextLine();
                    output.writeUTF(word);
                    receivedMsg = input.readUTF();
                }

            } else {

                String word = inp.nextLine();
                output.writeUTF(word);
                receivedMsg = input.readUTF();

                int i = 0;

                while (!word.equals("bye") && !word.equals("exit")){

                    i++;
                    System.out.println("Ответ сервера: " + i + " - " + receivedMsg);
                    word = inp.nextLine();
                    output.writeUTF(word);
                    receivedMsg = input.readUTF();

                }

                if (word.equals("exit")){
                    socket.close();
                    input.close();
                    output.close();
                }

            }

            System.err.println("Сервер закрыт? - " + socket.isClosed());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}