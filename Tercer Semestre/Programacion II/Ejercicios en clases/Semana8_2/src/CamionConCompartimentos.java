public class CamionConCompartimentos extends Camion {

    private float cargaMaxima;
    private int cantidadCompartimentos;

    public CamionConCompartimentos(String marca, String patente, double cargaToneladas, float cargaMaxima, int cantidadCompartimentos) {
        super(marca, patente, cargaToneladas);
        this.cargaMaxima = cargaMaxima;
        this.cantidadCompartimentos = cantidadCompartimentos;
    }

    public float capacidadCargaPorCompartimiento(){
        return cargaMaxima / cantidadCompartimentos;
    }

    public float getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public int getCantidadCompartimentos() {
        return cantidadCompartimentos;
    }

    public void setCantidadCompartimentos(int cantidadCompartimentos) {
        this.cantidadCompartimentos = cantidadCompartimentos;
    }

    @Override
    public String toString() {
        super.getMarca();
        return "CamionConCompartimentos{" +
                "Marca=" + getMarca() +
                ", cantidadCompartimentos=" + cantidadCompartimentos +
                ", capacidad de carga por compartimento: " + capacidadCargaPorCompartimiento();
    }
}