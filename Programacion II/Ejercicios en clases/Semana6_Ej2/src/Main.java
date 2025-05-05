import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        // LISA 10 ESTUDIANTES
        // EN EL MAIN
        // INGRESAR EL id BANNER Y BUSCAR EL NOMBRE MEDIANTE EL ID

        List<Estudiante> estudiantes = new ArrayList<Estudiante>();
        estudiantes.add(new Estudiante("123", "Julio0"));
        estudiantes.add(new Estudiante("456", "Julio1"));
        estudiantes.add(new Estudiante("656", "Julio2"));
        estudiantes.add(new Estudiante("234", "Julio3"));
        estudiantes.add(new Estudiante("165", "Julio4"));
        estudiantes.add(new Estudiante("423", "Julio5"));
        estudiantes.add(new Estudiante("467", "Julio6"));
        estudiantes.add(new Estudiante("876", "Julio7"));
        estudiantes.add(new Estudiante("974", "Julio8"));
        estudiantes.add(new Estudiante("468", "Julio9"));

        System.out.println("Ingrese el id banner:");
        String cadenaABuscar = sc.nextLine();

        Iterator<Estudiante> it = estudiantes.iterator();
        while (it.hasNext()) {
            Estudiante estudiante = it.next();
            if (estudiante.getIdbanner().equals(cadenaABuscar)) {
                System.out.println("El nombre es: " + estudiante.getNombre());
            }
        }


        /*
        int index = 0;
        boolean encontrado = false;

        for(index = 0; index < estudiantes.size() && !encontrado;){
             String idbanner = estudiantes.get(index).getIdbanner();
            if (idbanner.equals(cadenaABuscar)) {
                 encontrado = true;
                 System.out.println("El nombre es: " + estudiantes.get(index).getNombre());
             }
             else {
                 index++;
             }

         }

        while (index < estudiantes.size() && !encontrado) {
            String idbanner = estudiantes.get(index).getIdbanner();
            if (idbanner.equals(cadenaABuscar)) {
                encontrado = true;
                System.out.println("El nombre es: " + estudiantes.get(index).getNombre());
            } else {
                index++;
            }
        }
        */

    }
}
