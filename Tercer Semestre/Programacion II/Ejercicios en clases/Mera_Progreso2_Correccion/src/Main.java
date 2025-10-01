import java.util.List;

public class Main {
    public static void main(String[] args) {

        Empleado empleado1 = new Empleado("Juan");
        Empleado empleado2 = new Empleado("Pedro");

        MensajeSimple m1 = new MensajeSimple("Mensaje 1");
        MensajeSimple m2 = new MensajeSimple("Mensaje 2");

        MensajeInverso m3 = new MensajeInverso("Mensaje 3");
        MensajeInverso m4 = new MensajeInverso("Mensaje 4");

        empleado1.enviarMensaje(m1);
        empleado1.enviarMensaje(m3);

        empleado2.enviarMensaje(m2);
        empleado2.enviarMensaje(m4);

        empleado1.mostrarMensajes();
        System.out.println("------------------------------------------");

        empleado2.mostrarMensajes();
        System.out.println("------------------------------------------");

    }
}