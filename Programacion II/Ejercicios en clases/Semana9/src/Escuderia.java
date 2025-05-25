import java.util.ArrayList;
import java.util.List;

public class Escuderia {
    private String nombreEscuderia;
    private String pais;
    private List<PersonaF1> miembros = new ArrayList<>();

    public Escuderia(String nombreEscuderia, String pais) {
        this.nombreEscuderia = nombreEscuderia;
        this.pais = pais;
    }

    public void agregarMiembro(PersonaF1 miembro) {
        miembros.add(miembro);
    }

    public void mostrarMiembros() {
        System.out.println("Miembros de " + nombreEscuderia +
                " (" + pais + "):");
        for (PersonaF1 p : miembros) {
            p.presentarse();
        }
    }

    public void mostrarMensajesCifrados() {
        System.out.println("Mensajes cifrados:");
        for (PersonaF1 p : miembros) {
            if (p instanceof Ingeniero) {
                System.out.println(((Ingeniero) p).verMensajeTecnicoCifrado());
            }

            if (p instanceof Piloto) {
                System.out.println(((Piloto) p).verEstrategiaCifrada());
            }
        }
    }
}