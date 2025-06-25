import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Publicacion> publicaciones;

    public Biblioteca() {
        this.publicaciones = new ArrayList<>();
    }

    // Agregar publicación a la biblioteca
    public void agregarPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }

    // Prestar una publicación
    public void prestarPublicacion(Publicacion publicacion) throws NoDisponibleException {
        if (publicacion instanceof Prestable publicacionPrestable) {
            publicacionPrestable.prestar();
        } else {
            System.out.println("La publicación '" + publicacion.getTitulo() + "' no es prestable.");
        }
    }

    // Devolver una publicación
    public void devolverPublicacion(Publicacion publicacion) throws NoPrestadoException {
        if (publicacion instanceof Prestable publicacionPrestable) {
            publicacionPrestable.devolver();
        } else {
            System.out.println("La publicación no es prestable.");
        }
    }

    // Mostrar todas las publicaciones
    public void mostrarPublicaciones() {
        for(Publicacion publicacion : publicaciones){
            publicacion.mostrarInformacion();
        }
    }
}
