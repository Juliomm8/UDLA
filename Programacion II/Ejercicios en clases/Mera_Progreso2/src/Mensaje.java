/*
Requisitos:
Crea una clase abstracta Mensaje con:
Atributos protegidos:
    String contenidoOriginal
    int claveCifrado (un número entero entre 1 y 10, generado aleatoriamente)
Constructor que reciba el contenido del mensaje y genere automáticamente la clave.
Método abstracto String cifrar()
Método toString() que muestre el contenido original, la clave y el resultado del cifrado.

Crea dos clases concretas que hereden de Mensaje:
MensajeSimple: implementa cifrar() usando Cifrado César básico sobre letras minúsculas (sin cifrar espacios ni signos).
MensajeInverso: primero invierte el texto, y luego aplica Cifrado César sobre las letras minúsculas.
 */

public abstract class Mensaje {
    protected String contenidoOriginal;
    protected int claveCifrado;

    public Mensaje(String contenidoOriginal) {
        this.contenidoOriginal = contenidoOriginal;
        this.claveCifrado = (int) (Math.random() * 10 + 1);
    }

    public abstract String cifrar();

    public String getContenidoOriginal() {
        return contenidoOriginal;
    }

    public void setContenidoOriginal(String contenidoOriginal) {
        this.contenidoOriginal = contenidoOriginal;
    }

    public int getClaveCifrado() {
        return claveCifrado;
    }

    public void setClaveCifrado(int claveCifrado) {
        this.claveCifrado = claveCifrado;
    }

    @Override
    public String toString(){
        return "Mensaje original: " + contenidoOriginal + "\nClave cifrada: " + claveCifrado + "\nMensaje Simple: " + cifrar() + "\nMensaje Inverso: " + new MensajeInverso(cifrar()).cifrar() + "\n";
    }
}
