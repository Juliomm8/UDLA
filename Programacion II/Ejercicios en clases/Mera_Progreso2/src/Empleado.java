/*
Una empresa tecnológica desarrolla un sistema de comunicación segura.
Cada Empleado puede enviar MensajesCifrados, pero según su tipo de empleado, el comportamiento del cifrado varía.
Se desea modelar este sistema utilizando principios de programación orientada a objetos.

Crea una clase Empleado con:
Atributos privados:
    String nombre
    List<Mensaje> mensajes
Constructor con nombre e inicialización de la lista.
Método enviarMensaje(Mensaje mensaje) que lo agregue a la lista.
Método mostrarMensajes() que imprima todos los mensajes con su cifrado.
 */

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre;
    private List<Mensaje> mensajes = new ArrayList<>();

    public Empleado(String nombre, List<Mensaje> mensajes) {
        this.nombre = nombre;
        this.mensajes = mensajes;
    }

    public void enviarMensaje(Mensaje mensaje){
        mensajes.add(mensaje);
    }

    public void mostrarMensajes(){
        for (Mensaje mensaje : mensajes) {
            System.out.println(mensaje);
        }

    }
}
