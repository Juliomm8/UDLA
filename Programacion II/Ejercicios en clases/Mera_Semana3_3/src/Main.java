import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        int operacion;

        System.out.println("Ingrese el primer numero: ");
        calculadora.setNum1(sc.nextInt());
        System.out.println("Ingrese el segundo numero: ");
        calculadora.setNum2(sc.nextInt());

        do {
            System.out.println("Que operacion quiere realizar: ");
            System.out.println("1. Sumar \n2. Restar \n3. Multiplicar \n4. Divisir \n5. Cambiar numeros\n0. Salir");
            operacion = sc.nextInt();

            if (operacion == 1) {
                System.out.println("La suma es " + calculadora.calcularSuma());
            }
            if (operacion == 2) {
                System.out.println("La resta es " + calculadora.calcularResta());
            }
            if (operacion == 3) {
                System.out.println("La multiplicacion es " + calculadora.calcularMultiplicacion());
            }
            if (operacion == 4) {
                System.out.println("La division es " + calculadora.calcularDivision());
            }
            if (operacion == 5) {
                System.out.println("Ingrese el primer numero: ");
                calculadora.setNum1(sc.nextInt());
                System.out.println("Ingrese el segundo numero: ");
                calculadora.setNum2(sc.nextInt());
            }


        } while (operacion != 0);
    }
}