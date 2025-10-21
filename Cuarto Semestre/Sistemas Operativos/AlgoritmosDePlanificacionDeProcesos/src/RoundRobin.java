import java.util.*;

public class RoundRobin {

    public static void roundRobin(List<Tabla> procesos, int quantum) {
        Queue<Tabla> cola = new LinkedList<>(procesos);
        int tiempoTranscurrido = 0;
        int totalEspera = 0;
        int totalRetorno = 0;

        while (!cola.isEmpty()) {
            Tabla proceso = cola.poll();

            int tiempoEjecucion = Math.min(proceso.getTiempoRafaga(), quantum);
            proceso.setTiempoRafaga(proceso.getTiempoRafaga() - tiempoEjecucion);

            int tiempoEspera = tiempoTranscurrido - proceso.getTiempoLlegada();
            int tiempoRetorno = tiempoTranscurrido + tiempoEjecucion - proceso.getTiempoLlegada();

            totalEspera += tiempoEspera;
            totalRetorno += tiempoRetorno;

            System.out.println(proceso.toString() + "\n Tiempo de espera: " + tiempoEspera +
                    "\n Tiempo de retorno: " + tiempoRetorno);

            if (proceso.getTiempoRafaga() > 0) {
                cola.offer(proceso);
            }
            tiempoTranscurrido += tiempoEjecucion;
        }

        double promedioEspera = (double) totalEspera / procesos.size();
        double promedioRetorno = (double) totalRetorno / procesos.size();
        System.out.println("\nMedia de Tiempo de Espera: " + promedioEspera);
        System.out.println("Media de Tiempo de Retorno: " + promedioRetorno);
    }
}
