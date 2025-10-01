// Main.java
public class Main {
    public static void main(String[] args) {
        Escuderia escuderia = new Escuderia("Ferrari", "Italia");

        Ingeniero ing = new Ingeniero("Jose", 19, "Aerodinámica",
                "Ajustar el aleron trasero");
        Piloto pil = new Piloto("Lewis", 38, 17,
                "Atacar en la curva 7");

        escuderia.agregarMiembro(ing);
        escuderia.agregarMiembro(pil);

        escuderia.mostrarMiembros();
        escuderia.mostrarMensajesCifrados();



    }
}
