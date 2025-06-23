public class Revista extends Publicacion {
    private int numeroEdicion;

    // Constructor
    public Revista(String titulo, String autor, int numeroEdicion) {
        super(titulo, autor);
        this.numeroEdicion = numeroEdicion;
    }

    // Getter para numeroEdicion
    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    // Sobrescritura del método mostrarInformacion
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Edición: " + numeroEdicion);
    }
}
