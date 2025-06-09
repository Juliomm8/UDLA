public class Tienda {
    public void realizarPago(ProcesadorPago metodoPago, double monto) {
        System.out.println("Realizando transaccion");
        metodoPago.procesarPago(monto);
        System.out.println("Transaccion realizada");
    }
}
