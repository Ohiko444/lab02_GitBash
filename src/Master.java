public class Master {
    public static void main(String[] args) {

        System.out.println("Hello, " + args[0]);

        double x = Double.parseDouble(args[1]);
        double y = Double.parseDouble(args[2]);

        System.out.println((3*Math.cos(x-(Math.PI/6.0))*Math.cos(x-(Math.PI/6.0)))/(1/2.0+Math.sin(y*y)));
    }
}
