public class Tienda {
    public void realizarPago(ProcesadorPago metodoPago, double monto) throws ValidacionMontoException{
        if (monto <= 0) {
            throw new ValidacionMontoException("El monto debe ser mayor a 0");
        } else {
            metodoPago.procesarPago(monto);
        }
    }
}
