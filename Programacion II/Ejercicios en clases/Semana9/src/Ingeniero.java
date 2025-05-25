public class Ingeniero extends PersonaF1 {
    private String especialidad;
    private String mensajeTecnico;

    public Ingeniero(String nombre, int edad, String especialidad, String mensajeTecnico) {
        super(nombre, edad);
        this.especialidad = especialidad;
        this.mensajeTecnico = mensajeTecnico;
    }

    @Override
    public void presentarse() {
        System.out.println("Ingeniero " + getNombre() +
                ", edad " + getEdad() +
                ", especialidad: " + especialidad);
    }

    public String verMensajeTecnicoCifrado() {
        return cifrarMensaje(mensajeTecnico, 3);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getMensajeTecnico() {
        return mensajeTecnico;
    }

    public void setMensajeTecnico(String mensajeTecnico) {
        this.mensajeTecnico = mensajeTecnico;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Ingeniero{" +
                "especialidad='" + especialidad + '\'' +
                ", mensajeTecnico='" + mensajeTecnico + '\'' +
                '}';
    }
}