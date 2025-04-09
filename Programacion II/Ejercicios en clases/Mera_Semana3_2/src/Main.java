import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cuadrilatero c = new Cuadrilatero();

        System.out.println("Ingrese el largo del cuadrilatero");
        c.setLargo(sc.nextInt());

        System.out.println("Ingrese el ancho del cuadrilatero");
        c.setAncho(sc.nextInt());

        System.out.println("El area del cuadrilatero es: " + c.calcularArea());
        System.out.println("El perimetro del cuadrilatero es: " + c.calcularPerimetro());
    }
}