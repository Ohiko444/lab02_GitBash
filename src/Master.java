public class Master {
    public static void main(String[] args) {

        System.out.println("Hello, " + args[0]);

        int variantNumber = Integer.parseInt(args[1]);

        System.out.println("Вариант: " + variantNumber);

        switch (variantNumber){
            case 1 -> variant1(Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), Double.parseDouble(args[5]), Double.parseDouble(args[6]));
            case 2 -> variant2(Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), Double.parseDouble(args[5]));
            case 3 -> variant3(Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), Double.parseDouble(args[5]));
            case 4 -> variant4(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
            case 5 -> variant5(Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), Double.parseDouble(args[5]), Double.parseDouble(args[6]));
            case 6 -> variant6(Double.parseDouble(args[2]));
            case 7 -> variant7(Double.parseDouble(args[2]));
        }


    }

    public static void variant1 (double a, double b, double c, double n, double x){
        System.out.println("Входные данные: \na = " + a + "\nb = " + b + "\nc = " + c + "\nn = " + n + "\nx = " + x);
        double one = 5 * Math.pow(a, n*x);
        double two = b + c;
        double three = Math.sqrt(Math.abs(Math.cos(Math.pow(x, 3))));
        System.out.println("Результат вычисления: " + (one/two - three));
    }

    public static void variant2 (double a, double x, double y, double w){
        System.out.println("Входные данные: \na = " + a + "\nx = " + x + "\ny = " + y + "\nw = " + w);
        double one = Math.abs(x - y);
        double two = Math.pow((1 + 2*x), a);
        double three = Math.exp(Math.sqrt(1 + w));
        System.out.println("Результат вычисления: " + (one/two - three));
    }

    public static void variant3 (double a0, double a1, double a2, double x){
        System.out.println("Входные данные: \na0 = " + a0 + "\na1 = " + a1 + "\na2 = " + a2 + "\nx = " + x);
        double one = a0 + a1*x;
        double two = a2 * Math.pow(Math.abs(Math.sin(x)), 1/3.0);
        System.out.println("Результат вычисления: " + Math.sqrt(one + two));
    }

    public static void variant4 (double a, double x){
        System.out.println("Входные данные: \na = " + a + "\nx = " + x);
        double one = Math.log(Math.abs(Math.pow(a, 7)));
        double two = Math.atan(x*x);
        double three = Math.PI/(Math.sqrt(Math.abs(a + x)));
        System.out.println("Результат вычисления: " + (one + two + three));
    }

    public static void variant5 (double a, double b, double c, double d, double x){
        System.out.println("Входные данные: \na = " + a + "\nb = " + b + "\nc = " + c + "\nd = " + d + "\nx = " + x);
        double one = Math.pow((a + b), 2)/(c + d);
        double two = Math.exp(Math.sqrt(x + 1));
        System.out.println("Результат вычисления: " + Math.pow((one + two), 1/5.0));
    }
    public static void variant6 (double x){
        System.out.println("Входные данные: \nx = " + x);
        double one = 2 * Math.sin(4*x);
        double two = Math.pow(Math.cos(x*x), 2);
        double three = (one + two)/3*x;
        System.out.println("Результат вычисления: " + Math.exp(three));
    }
    public static void variant7 (double x){
        System.out.println("Входные данные: \nx = " + x);
        double one = (1 + x*x)/(1 - x);
        double two = 1/2.0 * Math.tan(x);
        double three = 1/4.0 * (one + two);
        System.out.println("Результат вычисления: " + three);
    }
}
