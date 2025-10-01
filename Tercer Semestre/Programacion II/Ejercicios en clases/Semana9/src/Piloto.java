public class Piloto extends PersonaF1 {
    private int numero;
    private String estrategiaCarrera;

    public Piloto(String nombre, int edad, int numero, String estrategiaCarrera) {
        super(nombre, edad);
        this.numero = numero;
        this.estrategiaCarrera = estrategiaCarrera;
    }

    @Override
    public void presentarse() {
        System.out.println("Piloto " + getNombre() +
                ", edad " + getEdad() +
                ", número: " + numero);
    }

    public String verEstrategiaCifrada() {
        return cifrarMensaje(estrategiaCarrera, 5);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstrategiaCarrera() {
        return estrategiaCarrera;
    }

    public void setEstrategiaCarrera(String estrategiaCarrera) {
        this.estrategiaCarrera = estrategiaCarrera;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Piloto{" +
                "numero=" + numero +
                ", estrategiaCarrera='" + estrategiaCarrera + '\'' +
                '}';
    }
}