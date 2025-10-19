import java.util.*;

public class SJF {

    public static void sjf(List<Tabla> procesos) {
        procesos.sort(Comparator.comparingInt( proceso -> proceso.getTiempoRafaga()));

        int tiempoTranscurrido = 0;
        int totalEspera = 0;
        int totalRetorno = 0;
        int tiempoInicio;
        int tiempoFin;

        for(Tabla proceso : procesos) {
            if(tiempoTranscurrido <= proceso.getTiempoLlegada());

            tiempoInicio = proceso.getTiempoLlegada();
            tiempoFin = proceso.getTiempoRafaga() + tiempoTranscurrido;

            int tiempoEspera = tiempoTranscurrido - tiempoInicio;
            int tiempoRetorno = tiempoFin;

            totalEspera += tiempoEspera;
            totalRetorno += tiempoRetorno;

            System.out.println(proceso.toString() + "\n Tiempo de espera: " + tiempoEspera +
                    "\n Tiempo de retorno: " + tiempoRetorno);
            tiempoTranscurrido = tiempoFin;
        }

        double promedioEspera = (double) totalEspera / procesos.size();
        double promedioRetorno = (double) totalRetorno / procesos.size();
        System.out.println("\nMedia de Tiempo de Espera: " + promedioEspera);
        System.out.println("Media de Tiempo de Retorno: " + promedioRetorno);
    }
}
