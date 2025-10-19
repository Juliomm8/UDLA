public class Procesos {
    private String trabajo;
    private int rafagaCPU;
    private int tiempoLlegada;
    private int prioridad;

    public Procesos(String trabajo, int rafagaCPU, int tiempoLlegada, int prioridad) {
        this.trabajo = trabajo;
        this.rafagaCPU = rafagaCPU;
        this.tiempoLlegada = tiempoLlegada;
        this.prioridad = prioridad;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public int getRafagaCPU() {
        return rafagaCPU;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public int getPrioridad() {
        return prioridad;
    }
}
