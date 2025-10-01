public abstract class PersonaF1 {
    private String nombre;
    private int edad;

    public PersonaF1(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public abstract void presentarse();

    /*
     El ingeniero usa desplazamiento de 3 y el piloto desplazamiento de 5.
     */
    public String cifrarMensaje(String mensaje, int desplazamiento) {
        StringBuilder cifrado = new StringBuilder();
        for (char c : mensaje.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                char letraCifrada = (char) ((c - 'a' + desplazamiento) % 26 + 'a');
                cifrado.append(letraCifrada);
            } else {
                cifrado.append(c);
            }
        }
        return cifrado.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "PersonaF1{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}