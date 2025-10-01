public class Estudiante {
    private String nombre;
    private String idbanner;

    public Estudiante(String idbanner, String nombre) {
        this.idbanner = idbanner;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdbanner() {
        return idbanner;
    }

    public void setIdbanner(String idbanner) {
        this.idbanner = idbanner;
    }
}