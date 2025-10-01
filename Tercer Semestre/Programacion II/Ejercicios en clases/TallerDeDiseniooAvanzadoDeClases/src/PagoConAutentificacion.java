public abstract class PagoConAutentificacion implements ProcesadorPago {
    private String usuario;

    public PagoConAutentificacion(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void autenticar() {
        System.out.println("Verificando identidad de: " + usuario);
    }

    public abstract void procesarPago(double monto);
}
