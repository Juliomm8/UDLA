public class PagoEfectivo implements ProcesadorPago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("\nPago en efectivo exitoso. \nTotal pagado: $" + monto);
    }
}
