import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 34522;

    public static void main(String[] args) {

        System.out.println("Сервер запущен и готов к работе...");

        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Session session = new Session(server.accept());
                session.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Session extends Thread {
    private final Socket socket;

    public Session(Socket socketForClient) {
        this.socket = socketForClient;
    }

    public void run() {
        try (
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {

            String name = input.readUTF();
            output.writeUTF(name);
            System.out.println("К нам пришёл(ла) " + name);

            int var = input.readInt();
            System.out.println(name + " выбрал(ла) вариант: " + var);

            double rez = 0;

            switch (var){
                case 1 -> rez = variant1(input, output);
                case 2 -> rez = variant2(input, output);
                case 3 -> rez = variant3(input, output);
                case 4 -> rez = variant4(input, output);
                case 5 -> rez = variant5(input, output);
                case 6 -> rez = variant6(input, output);
                case 7 -> rez = variant7(input, output);
            }

            output.writeDouble(rez);
            System.out.println("Результат вычисления: " + rez);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double variant1 (DataInputStream input, DataOutputStream output) throws IOException {
        output.writeInt(5);
        double a = input.readDouble();
        double b = input.readDouble();
        double c = input.readDouble();
        double n = input.readDouble();
        double x = input.readDouble();

        System.out.println("Входные данные: \na = " + a + "\nb = " + b + "\nc = " + c + "\nn = " + n + "\nx = " + x);
        double one = 5 * Math.pow(a, n*x);
        double two = b + c;
        double three = Math.sqrt(Math.abs(Math.cos(Math.pow(x, 3))));

        return (one/two - three);
    }

    public static double variant2 (DataInputStream input, DataOutputStream output) throws IOException {
        output.writeInt(4);
        double a = input.readDouble();
        double x = input.readDouble();
        double y = input.readDouble();
        double w = input.readDouble();

        System.out.println("Входные данные: \na = " + a + "\nx = " + x + "\ny = " + y + "\nw = " + w);
        double one = Math.abs(x - y);
        double two = Math.pow((1 + 2*x), a);
        double three = Math.exp(Math.sqrt(1 + w));
        double otv = one/two - three;

        return otv;
    }

    public static double variant3 (DataInputStream input, DataOutputStream output) throws IOException {
        output.writeInt(4);
        double a0 = input.readDouble();
        double a1 = input.readDouble();
        double a2 = input.readDouble();
        double x = input.readDouble();

        System.out.println("Входные данные: \na0 = " + a0 + "\na1 = " + a1 + "\na2 = " + a2 + "\nx = " + x);
        double one = a0 + a1*x;
        double two = a2 * Math.pow(Math.abs(Math.sin(x)), 1/3.0);

        return Math.sqrt(one + two);
    }

    public static double variant4 (DataInputStream input, DataOutputStream output) throws IOException {
        output.writeInt(2);
        double a = input.readDouble();
        double x = input.readDouble();

        System.out.println("Входные данные: \na = " + a + "\nx = " + x);
        double one = Math.log(Math.abs(Math.pow(a, 7)));
        double two = Math.atan(x*x);
        double three = Math.PI/(Math.sqrt(Math.abs(a + x)));

        return (one + two + three);
    }

    public static double variant5 (DataInputStream input, DataOutputStream output) throws IOException {
        output.writeInt(5);
        double a = input.readDouble();
        double b = input.readDouble();
        double c = input.readDouble();
        double d = input.readDouble();
        double x = input.readDouble();

        System.out.println("Входные данные: \na = " + a + "\nb = " + b + "\nc = " + c + "\nd = " + d + "\nx = " + x);
        double one = Math.pow((a + b), 2)/(c + d);
        double two = Math.exp(Math.sqrt(x + 1));

        return Math.pow((one + two), 1/5.0);
    }
    public static double variant6 (DataInputStream input, DataOutputStream output) throws IOException {
        output.writeInt(1);
        double x = input.readDouble();

        System.out.println("Входные данные: \nx = " + x);
        double one = 2 * Math.sin(4*x);
        double two = Math.pow(Math.cos(x*x), 2);
        double three = (one + two)/3*x;

        return Math.exp(three);
    }
    public static double variant7 (DataInputStream input, DataOutputStream output) throws IOException {
        output.writeInt(1);
        double x = input.readDouble();

        System.out.println("Входные данные: \nx = " + x);
        double one = (1 + x*x)/(1 - x);
        double two = 1/2.0 * Math.tan(x);
        double three = 1/4.0 * (one + two);

        return three;
    }

}