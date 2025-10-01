public class Camion extends Vehiculo{

    private float cargaMaxima;

    public void metodoCualquiera(){
        String marca = this.getMarca();//podemos llamar al get xq es publico
    }

    public Camion(String marca, String patente, float cargaMaxima) {
        super(marca, patente);
        this.cargaMaxima = cargaMaxima;
    }

    public void activaTolva(){
        System.out.println("tolva activada");
    }

    public float getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(float cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    @Override
    public String toString() {
        String s = super.toString();//se ejecuta  el metodo o comportamiento de la clase padre
        return s + ":" + "Camion{" +
                "cargaMaxima=" + cargaMaxima +
                '}';
    }
}