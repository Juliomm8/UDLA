public class Mascota {
    private String nombre;
    private String especie;
    private int edad;
    private boolean adoptada;

    public Mascota(String nombre, String especie, int edad, boolean adoptada) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.adoptada = adoptada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isAdoptada() {
        return adoptada;
    }

    public void setAdoptada(boolean adoptada) {
        this.adoptada = adoptada;
    }

    public void adoptar(){
        if (adoptada){
            System.out.println("No se puede adoptar a " + nombre);
        }
        else{
            adoptada = true;
            System.out.println("Has adoptado a " + nombre);
        }
    }

    public void devolver(){
        if (!adoptada){
            System.out.println("No se puede devolver a " + nombre);
        }
        else{
            adoptada = false;
            System.out.println("Has devuelto a " + nombre);
        }
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", edad=" + edad +
                ", adoptado=" + adoptada +
                '}';
    }
}
