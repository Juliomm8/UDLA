/*
En el main, realiza lo siguiente:
Crear 2 empleados.
Cada uno debe enviar al menos 2 mensajes: uno MensajeSimple y uno MensajeInverso.
Mostrar todos los mensajes cifrados por cada empleado.
 */

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Juan", new ArrayList<>());
        Empleado empleado2 = new Empleado("María", new ArrayList<>());

        empleado1.enviarMensaje(new MensajeSimple( "Buenas Tardes"));
        empleado2.enviarMensaje(new MensajeSimple( "Hola"));


        empleado1.mostrarMensajes();
        empleado2.mostrarMensajes();

    }
}

