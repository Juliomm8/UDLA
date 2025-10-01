public class Carro extends Vehiculo {
    private int numeroPasajeros;

    public Carro(String marca, String patente, int numeroPasajeros) {
        super(marca, patente);
        this.numeroPasajeros = numeroPasajeros;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    @Override
    public String toString() {
        String info = super.toString();
        return info + ":" + "carro{" +
                "numeroPasajeros=" + numeroPasajeros +
                '}';
    }
}