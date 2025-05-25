// Main.java
public class Main {
    public static void main(String[] args) {
        Escuderia escuderia = new Escuderia("Scuderia Eclipse", "Ecuador");

        Ingeniero ing = new Ingeniero("Ana Pérez", 35, "Aerodinámica",
                "revisar alerones traseros");
        Piloto pil = new Piloto("Luis Gómez", 28, 7,
                "mantener rebufo en recta");

        escuderia.agregarMiembro(ing);
        escuderia.agregarMiembro(pil);

        escuderia.mostrarMiembros();
        escuderia.mostrarMensajesCifrados();
    }
}
