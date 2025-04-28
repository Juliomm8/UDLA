import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Robot robot1 = new Robot();
        Robot robot2 = new Robot();

        int energia;

        // Ingreso de datos del robot 1
        System.out.println("Ingrese el nombre del robot 1: ");
        robot1.setModelo(sc.nextLine());
        do {
            System.out.println("Ingrese la energia del robot 1: (Debe ser un valor entre 0 y 100)");
            robot1.setEnergia(sc.nextInt());
            energia = robot1.getEnergia();

        } while (energia > 100 || energia < 0);

        System.out.println("Ingrese la fuerza del robot 1: ");
        robot1.setFuerza(sc.nextInt());

        System.out.println("Ingrese la defensa del robot 1: ");
        robot1.setDefensa(sc.nextInt());

        sc.nextLine();
        // Ingreso de datos del robot 2
        System.out.println("Ingrese el nombre del robot 2: ");
        robot2.setModelo(sc.nextLine());

        do {
            System.out.println("Ingrese la energia del robot 2: (Debe ser un valor entre 0 y 100)");
            robot2.setEnergia(sc.nextInt());
            energia = robot2.getEnergia();

        } while (energia > 100 || energia < 0);


        System.out.println("Ingrese la fuerza del robot 2: ");
        robot2.setFuerza(sc.nextInt());

        System.out.println("Ingrese la defensa del robot 2: ");
        robot2.setDefensa(sc.nextInt());

        // Muestra de los datos de los Robots
        System.out.println(robot1);
        System.out.println(robot2);

        // Recargar de energia 1 y muestra de la variable contadorRecarga
        robot1.recargarEnergia();
        robot2.recargarEnergia();
        System.out.println("Contador de la recarga del robot 1 es: " + Robot.contadorRecarga);
        System.out.println("Contador de la recarga del robot 2 es: " + Robot.contadorRecarga);

        // Recargar de energia 2
        robot1.recargarEnergia();
        robot2.recargarEnergia();
        System.out.println("Contador de la recarga del robot 1 es: " + Robot.contadorRecarga);
        System.out.println("Contador de la recarga del robot 2 es: " + Robot.contadorRecarga);

        // Ataque 1
        robot1.atacar(robot2);
        // Ataque 2
        robot1.atacar(robot2);

        System.out.println(robot1);
        System.out.println(robot2);
    }
}
