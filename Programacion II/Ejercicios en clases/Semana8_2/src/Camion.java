public class Camion extends Vehiculo {

    private double cargaToneladas;

    public Camion(String marca, String patente, double cargaToneladas) {
        super(marca, patente);
        this.cargaToneladas = cargaToneladas;
    }

    public double getCargaToneladas() {
        return cargaToneladas;
    }

    public void setCargaToneladas(double cargaToneladas) {
        this.cargaToneladas = cargaToneladas;
    }
}