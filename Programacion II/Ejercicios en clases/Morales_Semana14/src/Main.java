public class Main {
    public static void main(String[] args) {
        // Instanciación de usuarios
        Usuario userA = new Usuario("Marta", "2222");
        Usuario userB = new Usuario("Pedro", "3333");
        Usuario userC = new Usuario("Lucía", "4444");

        Biblioteca myLibrary = new Biblioteca();

        // Estado inicial de la biblioteca
        System.out.println(">> Biblioteca vacía al inicio:");
        myLibrary.mostrarPublicaciones();
        System.out.println("---------------------");

        // Crear algunos libros y revistas
        Libro l1 = new Libro("Rayuela", "Julio Cortázar");
        Libro l2 = new Libro("Fahrenheit 451", "Ray Bradbury");
        Libro l3 = new Libro("La sombra del viento", "Carlos Ruiz Zafón");
        Revista r1 = new Revista("Muy Interesante", "MI Editorial", 105);
        Revista r2 = new Revista("Nature", "Springer", 333);

        // Añadir a la biblioteca
        myLibrary.agregarPublicacion(l1);
        myLibrary.agregarPublicacion(l2);
        myLibrary.agregarPublicacion(l3);
        myLibrary.agregarPublicacion(r1);
        myLibrary.agregarPublicacion(r2);

        System.out.println(">> Biblioteca después de añadir publicaciones:");
        myLibrary.mostrarPublicaciones();
        System.out.println("---------------------");

        // Pruebas de préstamo
        System.out.println("-- Préstamos de Marta --");
        userA.prestarPublicacion(myLibrary, l1);
        userA.prestarPublicacion(myLibrary, l2);
        userA.mostrarPublicacionesPrestadas();

        System.out.println("\n-- Préstamos de Pedro --");
        userB.prestarPublicacion(myLibrary, l3);
        userB.prestarPublicacion(myLibrary, l1); // Ya prestado
        userB.mostrarPublicacionesPrestadas();

        System.out.println("\n-- Préstamos de Lucía --");
        userC.prestarPublicacion(myLibrary, r1); // Revistas no prestables
        userC.prestarPublicacion(myLibrary, l2); // Ya prestado
        userC.mostrarPublicacionesPrestadas();

        System.out.println("\n>> Biblioteca tras los préstamos:");
        myLibrary.mostrarPublicaciones();

        // Proceso de devoluciones
        System.out.println("\n--- Devoluciones ---");
        userA.devolverPublicacion(myLibrary, l1);
        userA.devolverPublicacion(myLibrary, l2);
        userB.devolverPublicacion(myLibrary, l3);

        // Devoluciones dobles
        System.out.println("\n--- Segundo intento de devolución ---");
        userA.devolverPublicacion(myLibrary, l1);
        userA.devolverPublicacion(myLibrary, l2);
        userB.devolverPublicacion(myLibrary, l3);

        System.out.println("\n>> Estado definitivo de la biblioteca:");
        myLibrary.mostrarPublicaciones();
    }
}
