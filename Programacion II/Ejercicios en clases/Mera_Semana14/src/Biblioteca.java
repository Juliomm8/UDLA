import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Publicacion> publicaciones;

    public Biblioteca() {
        this.publicaciones = new ArrayList<>();
    }

    // Agregar publicación a la biblioteca
    public void agregaPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }
    
    // Prestar una publicación
    public void prestaPublicacion(Publicacion publicacion) throws NoDisponibleException {
        if (publicacion instanceof Prestable) {
            ((Prestable) publicacion).presta();
        } else {
            System.out.println("La publicación no es prestable.");
        }
    }

    // Devolver una publicación
    public void devuelvePublicacion(Publicacion publicacion) throws NoPrestadoException {
        if (publicacion instanceof Prestable) {
            ((Prestable) publicacion).devuelve();
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
