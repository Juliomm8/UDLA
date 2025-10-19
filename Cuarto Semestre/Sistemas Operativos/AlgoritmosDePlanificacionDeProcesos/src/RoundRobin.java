import java.util.*;

public class RoundRobin {

    public static void roundRobin(List<Tabla> procesos, int quantum) {
        // Cola para mantener los procesos que aún necesitan ejecución
        Queue<Tabla> cola = new LinkedList<>(procesos);
        int tiempoTranscurrido = 0;
        int totalEspera = 0;
        int totalRetorno = 0;

        // Bucle para ejecutar los procesos hasta que la cola esté vacía
        while (!cola.isEmpty()) {
            Tabla proceso = cola.poll(); // Obtener el primer proceso en la cola

            // Calcular el tiempo que el proceso necesita ejecutarse
            int tiempoEjecucion = Math.min(proceso.getTiempoRafaga(), quantum);
            proceso.setTiempoRafaga(proceso.getTiempoRafaga() - tiempoEjecucion);

            // Calcular tiempos de espera y retorno
            int tiempoEspera = tiempoTranscurrido - proceso.getTiempoLlegada();
            int tiempoRetorno = tiempoTranscurrido + tiempoEjecucion - proceso.getTiempoLlegada();

            totalEspera += tiempoEspera;
            totalRetorno += tiempoRetorno;

            // Imprimir el estado del proceso después de ejecutarlo
            System.out.println(proceso.toString() + "\n Tiempo de espera: " + tiempoEspera +
                    "\n Tiempo de retorno: " + tiempoRetorno);

            // Si el proceso no ha terminado, agregarlo de nuevo a la cola
            if (proceso.getTiempoRafaga() > 0) {
                cola.offer(proceso);
            }

            // Actualizar el tiempo transcurrido
            tiempoTranscurrido += tiempoEjecucion;
        }

        // Calcular las medias de tiempo de espera y retorno
        double promedioEspera = (double) totalEspera / procesos.size();
        double promedioRetorno = (double) totalRetorno / procesos.size();
        System.out.println("\nMedia de Tiempo de Espera: " + promedioEspera);
        System.out.println("Media de Tiempo de Retorno: " + promedioRetorno);
    }
}
