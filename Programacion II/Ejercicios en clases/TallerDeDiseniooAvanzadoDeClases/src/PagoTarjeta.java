public class PagoTarjeta extends PagoConAutentificacion {
    public PagoTarjeta(String usuario) {
        super(usuario);
    }

    @Override
    public void procesarPago(double monto) {
        autenticar();
        System.out.println("\nProcesando el pago de $" + monto + " con TARJETA del usuario " + getUsuario() + " correctamente");
    }
}
