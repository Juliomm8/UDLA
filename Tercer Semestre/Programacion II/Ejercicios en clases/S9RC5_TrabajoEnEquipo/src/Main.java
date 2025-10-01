import java.util.Scanner;
import java.util.Random; //decidimos usar la librería random debido a que la implementación del método de generar un numero aleatorio de habitaciones entre 100 y 150, se podía hacer más rápido

public class Main {
    public static void main(String[] args) {
        // Objeto Scanner para leer entradas del usuario por consola
        Scanner scanner = new Scanner(System.in);

        // Crear un número aleatorio entre 100 y 150 que representa el total de habitaciones
        Random random = new Random();
        int numero = 100 + random.nextInt(51); // Genera un número entre 100 y 150 (inclusive)

        // Crear una instancia del hotel con la cantidad aleatoria de habitaciones
        Hotel hotel = new Hotel(numero);
        System.out.println("Número total de habitaciones: " + numero);

        System.out.println("Bienvenido al sistema de reservas del hotel.");
        boolean activo = true; // Variable de control para el menú

        // Ciclo principal del menú
        while (activo) {
            // Mostrar las opciones disponibles
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Crear nueva reserva");
            System.out.println("2. Consultar disponibilidad");
            System.out.println("3. Salir");
            System.out.print("Opción: ");

            // Leer la opción del usuario
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner (carácter '\n')

            // Ejecutar acción según la opción seleccionada
            switch (opcion) {
                case 1:
                    // Crear una nueva reserva
                    System.out.print("Nombre del cliente: ");
                    String cliente = scanner.nextLine();

                    // Intentar crear una reserva para el cliente
                    Reserva reserva = hotel.crearReserva(cliente);
                    if (reserva != null) {
                        // Reserva exitosa
                        System.out.println("Reserva creada con éxito para " + cliente +
                                " en habitación " + reserva.getNumeroHabitacion());
                    } else {
                        // No hay habitaciones disponibles
                        System.out.println("Lo sentimos, no hay habitaciones disponibles.");
                    }
                    break;

                case 2:
                    // Consultar disponibilidad de una habitación específica
                    System.out.print("Ingrese número de habitación a consultar: ");
                    int num = scanner.nextInt();

                    // Verificar si la habitación está disponible
                    boolean disponible = hotel.consultarDisponibilidad(num);
                    System.out.println(disponible ? "Habitación disponible." : "Habitación ocupada o no existe.");
                    break;

                case 3:
                    // Salir del sistema
                    activo = false;
                    break;

                default:
                    // Opción no válida
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        // Cerrar el scanner al finalizar para evitar fugas de recursos
        scanner.close();
    }
}