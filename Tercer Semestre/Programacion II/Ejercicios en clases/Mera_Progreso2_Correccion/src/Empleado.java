import java.util.ArrayList;
import java.util.List;

public class Empleado {

    private String nombre;
    private final List<Mensaje> mensajes;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.mensajes = new ArrayList<>();
    }

    public void enviarMensaje(Mensaje mensaje) {
        mensajes.add(mensaje);
    }

    public void mostrarMensajes(){
        System.out.println(mensajes);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }
}
