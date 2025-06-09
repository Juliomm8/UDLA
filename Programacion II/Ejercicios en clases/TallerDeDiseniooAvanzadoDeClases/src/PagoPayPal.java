public class PagoPayPal extends PagoConAutentificacion {
    public PagoPayPal(String usuario) {
        super(usuario);
    }

    @Override
    public void procesarPago(double monto) {
        autenticar();
        System.out.println("\nProcesando el pago de $" + monto + " con PayPal del usuario " + getUsuario() + " correctamente");
    }
}
