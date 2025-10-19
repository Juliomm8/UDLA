public class Tabla {
    private String nombreTrabajo;
    private int tiempoLlegada;
    private int tiempoRafaga;
    private int nivelPrioridad;
    private int tiempoInicioEjecucion;
    private int tiempoFinEjecucion;

    public Tabla(String nombreTrabajo, int tiempoRafaga, int tiempoLlegada, int nivelPrioridad) {
        this.nombreTrabajo = nombreTrabajo;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoRafaga = tiempoRafaga;
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getNombreTrabajo() {
        return nombreTrabajo;
    }

    public void setNombreTrabajo(String nombreTrabajo) {
        this.nombreTrabajo = nombreTrabajo;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public int getTiempoRafaga() {
        return tiempoRafaga;
    }

    public void setTiempoRafaga(int tiempoRafaga) {
        this.tiempoRafaga = tiempoRafaga;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(int nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }

    public int getTiempoInicioEjecucion() {
        return tiempoInicioEjecucion;
    }

    public void setTiempoInicioEjecucion(int tiempoInicioEjecucion) {
        this.tiempoInicioEjecucion = tiempoInicioEjecucion;
    }

    public int getTiempoFinEjecucion() {
        return tiempoFinEjecucion;
    }

    public void setTiempoFinEjecucion(int tiempoFinEjecucion) {
        this.tiempoFinEjecucion = tiempoFinEjecucion;
    }

    @Override
    public String toString() {
        return "nombreTrabajo: " + nombreTrabajo +
                ", tiempoLlegada: " + tiempoLlegada +
                ", tiempoRafaga: " + tiempoRafaga +
                ", nivelPrioridad: " + nivelPrioridad;
    }
}
