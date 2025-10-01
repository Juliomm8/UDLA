public class Autobus extends Vehiculo{

    private int cantidadAsientos;

    public Autobus(String marca, String patente) {
        super(marca, patente);
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }
}