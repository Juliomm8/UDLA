public class Main {
    public static void main(String[] args) {
        // Crear usuarios
        Usuario usuario1 = new Usuario("Jere", "1234");
        Usuario usuario2 = new Usuario("Ana", "5678");
        Usuario usuario3 = new Usuario("Carlos", "9012");
        Biblioteca biblioteca = new Biblioteca();

        // Comprobar la bibliteca antes de agregar publicaciones
        System.out.println("Estado inicial de la biblioteca:\n");
        biblioteca.mostrarPublicaciones();

        // Crear las publicaciones
        Libro libro1 = new Libro("El Quijote", "Cervantes");
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez");
        Libro libro3 = new Libro("1984", "George Orwell");
        Revista revista1 = new Revista("National Geographic", "National Geographic", 123);
        Revista revista2 = new Revista("Scientific American", "Nature Publishing Group", 456);

        // Agregar publicaciones a la biblioteca
        biblioteca.agregarPublicacion(libro1);
        biblioteca.agregarPublicacion(libro2);
        biblioteca.agregarPublicacion(libro3);
        biblioteca.agregarPublicacion(revista1);
        biblioteca.agregarPublicacion(revista2);

        // Estado de la biblioteca despues de agregar las publicaciones a la biblioteca
        System.out.println("Estado de la biblioteca:");
        biblioteca.mostrarPublicaciones();
        System.out.println();

        // Pruebas de prestar las publicaciones
        System.out.println("Préstamos de usuario1 (Jere):");
        usuario1.prestarPublicacion(biblioteca, libro1);
        usuario1.prestarPublicacion(biblioteca, libro2);
        usuario1.mostrarPublicacionesPrestadas();

        System.out.println("\nPréstamos de usuario2 (Ana):");
        usuario2.prestarPublicacion(biblioteca, libro3);
        usuario2.prestarPublicacion(biblioteca, libro1); // Intentar prestar libro ya prestado
        usuario2.mostrarPublicacionesPrestadas();

        System.out.println("\nPréstamos de usuario3 (Carlos):");
        usuario3.prestarPublicacion(biblioteca, revista1); // Intentar prestar revista
        usuario3.prestarPublicacion(biblioteca, libro2); // Intentar prestar libro ya prestado
        usuario3.mostrarPublicacionesPrestadas();

        System.out.println("\nEstado de la biblioteca después de préstamos:");
        biblioteca.mostrarPublicaciones();

        // Devoluciones
        System.out.println("\nDevoluciones:");
        usuario1.devolverPublicacion(biblioteca, libro1);
        usuario1.devolverPublicacion(biblioteca, libro2);
        usuario2.devolverPublicacion(biblioteca, libro3);

        // Intentar devolver otra ves
        System.out.println("\nIntentar devolver otra vez:");
        usuario1.devolverPublicacion(biblioteca, libro1);
        usuario1.devolverPublicacion(biblioteca, libro2);
        usuario2.devolverPublicacion(biblioteca, libro3);

        System.out.println("\nEstado final de la biblioteca:");
        biblioteca.mostrarPublicaciones();
    }
}