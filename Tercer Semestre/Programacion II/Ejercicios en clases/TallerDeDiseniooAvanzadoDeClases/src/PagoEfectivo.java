public class PagoEfectivo implements ProcesadorPago {
    @Override
    public void procesarPago(double monto)  {
        System.out.println("Procesando pago en efectivo de $" + monto);
    }
}
