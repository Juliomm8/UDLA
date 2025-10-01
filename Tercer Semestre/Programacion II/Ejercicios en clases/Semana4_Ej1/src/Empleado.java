public class Empleado {
private String cedula;
private String nombre;
private String apellido;
private char genero;
private double salario;

private Fecha fechaNacimiento;
private Fecha fechaIngreso;

    public Empleado(String cedula, String nombre, String apellido, char genero, double salario, Fecha fechaNacimiento, Fecha fechaIngreso) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Fecha getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Fecha fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\nApellido: " + this.apellido +  "\nGenero: " + this.genero + "\nSalario: " + this.salario + "\nFechaNacimiento: " + this.fechaNacimiento + "\nFechaIngreso: " + this.fechaIngreso;
    }
}
