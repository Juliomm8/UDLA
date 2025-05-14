import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona martin = new Profesor_Hora();
        Persona jose = new Alumno_Pregrado();
        Persona thomas = new Alumno_Magister();

        List<Persona> personas = new ArrayList<Persona>();
        personas.add(martin);
        personas.add(jose);
        personas.add(thomas);

    }
}