public class Vehiculo {

    private String marca;
    private String patente;

    public Vehiculo(String marca, String patente) {
        this.marca = marca;
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void avanza(){
        System.out.println("el vehiculo avanza");
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", patente='" + patente + '\'' +
                '}';
    }
}