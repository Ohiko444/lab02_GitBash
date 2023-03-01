import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output  = new DataOutputStream(socket.getOutputStream())
        ) {
            Scanner inp = new Scanner(System.in);

            System.out.print("Введите своё имя: ");
            String name = inp.nextLine();
            output.writeUTF(name);
            String nameMsg = input.readUTF();
            System.out.println("Привет, " + nameMsg);

            System.out.print("Введите вариант: ");
            int var = inp.nextInt();

            output.writeInt(var);

            int kol = input.readInt();
            for (int i = 0; i < kol; i++){
                System.out.print("Введите значение: ");
                double variable = inp.nextDouble();
                output.writeDouble(variable);
            }

            double rez = input.readDouble();

            System.out.println("Результат вычисления: " + rez);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}