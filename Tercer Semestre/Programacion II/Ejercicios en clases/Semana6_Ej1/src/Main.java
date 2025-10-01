import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        int[] temperaturas = new int[6];

        temperaturas[0] = 34;
        temperaturas[1] = 36;
        temperaturas[2] = 38;
        temperaturas[3] = 40;

        for (int i = 0; i < temperaturas.length; i++) {

            System.out.println("Temperatura en la posicion " + i + " es " + temperaturas[i]);
        }

        Estudiante estudiante[] = new Estudiante[2];

        estudiante[0] = new Estudiante("15212", "XDXD");
        estudiante[1] = new Estudiante("545549", "julio xd");

        for (int i = 0; i < estudiante.length; i++) {
            System.out.printf("\nEstudiante en la posicion " + i + " es de:"+ estudiante[i].getNombre() + " y el id es " + estudiante[i].getIdbanner() );

        }
        */

        List<Estudiante> estudiantes = new ArrayList<Estudiante>();
        estudiantes.add(new Estudiante("123", "Julio0"));
        estudiantes.add(new Estudiante("456", "Julio1"));
        estudiantes.add(new Estudiante("656", "Julio2"));
        estudiantes.add(new Estudiante("234", "Julio3"));


        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println("El estudiante en la posicion " + i + " es: " + estudiantes.get(i).getNombre() + " y el id es: " + estudiantes.get(i).getIdbanner());
        }
        System.out.println("-----------------------");

        estudiantes.add(2, new Estudiante("123", "Julio4"));


        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println("El estudiante en la posicion " + i + " es: " + estudiantes.get(i).getNombre() + " y el id es: " + estudiantes.get(i).getIdbanner());
        }

    }

}