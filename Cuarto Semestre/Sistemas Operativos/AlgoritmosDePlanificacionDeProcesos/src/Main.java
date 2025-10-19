import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Tabla> procesos = new ArrayList<>();

        procesos.add(new Tabla("A", 3, 2, 2));
        procesos.add(new Tabla("B", 1, 4, 3));
        procesos.add(new Tabla("C", 3, 0, 1));
        procesos.add(new Tabla("D", 4, 1, 3));
        procesos.add(new Tabla("E", 2, 3, 4));

        Scanner lector = new Scanner(System.in);

        boolean seguirEjecutando = true;
        while (seguirEjecutando) {

            System.out.println("Selecciona el algoritmo a ejecutar:");
            System.out.println("1. Algoritmo FIFO");
            System.out.println("2. Algoritmo SJF");
            System.out.println("3. Algoritmo de Prioridad");
            System.out.println("4. Algoritmo Round Robin");
            System.out.print("Ingrese el número correspondiente al algoritmo: ");
            int opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    FIFO.fifo(procesos);
                    break;
                case 2:
                    SJF.sjf(procesos);
                    break;
                case 3:
                    Prioridad.prioridad(procesos);
                    break;
                case 4:
                    System.out.print("Ingresa el quantum para Round Robin: ");
                    int quantum = lector.nextInt();
                    RoundRobin.roundRobin(procesos, quantum);
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número entre 1 y 4.");
            }

            // Preguntar si el usuario desea ejecutar otro algoritmo
            System.out.print("¿Desea ejecutar otro algoritmo? (s/n): ");
            String respuesta = lector.next();
            if (respuesta.equalsIgnoreCase("n")) {
                seguirEjecutando = false;
            }
        }

        lector.close();
    }
}
