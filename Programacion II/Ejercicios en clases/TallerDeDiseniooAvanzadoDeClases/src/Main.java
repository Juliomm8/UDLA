import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Tienda tienda = new Tienda();

        System.out.println("---------- MENÚ DE PAGOS ----------");
        System.out.print("Ingrese el monto que va pagar: ");
        double monto = s.nextDouble();
        s.nextLine();

        System.out.println("Seleccione método de pago:");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");
        System.out.println("3. PayPal");
        System.out.println("4. Salir");

        int opcion = s.nextInt();
        s.nextLine();

        switch (opcion) {
            case 1:
                tienda.realizarPago(new PagoEfectivo(), monto);
                break;
            case 2:
                System.out.print("Usuario: ");
                String user1 = s.nextLine();
                tienda.realizarPago(new PagoTarjeta(user1), monto);
                break;
            case 3:
                System.out.print("Usuario: ");
                String user2 = s.nextLine();
                tienda.realizarPago(new PagoPayPal(user2), monto);
            case 4 :
                System.out.println("Cancelando operación...");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }
}




// Diseniar y emplentar un sistema de procesamiento de pago para una tienda, usar polimorfismo
// La tienda debe procesar los pagos de targetas, paypal, efectivo.
// Todos los metodos deben seguir un interface comun ""ProcesadorPago"
// Donde se reciba un parametro de tipo double que se llame "monto"
// Algunos metodos requieren autentificacion de pago antes de que se realice (Targeta, paypal)
// Estos metodos deben usar un abstract que se llame "PagoConAutenticacion"
// Implementar String usuario, autenticar(), precesarPago(double monto)
// El metodo de pago efectivo no requiere autenticacion
// la calse tienda debe tener un metodo llamado "RealizarPago" que reciba un objeto de tipo "ProcesadorPago metodoPago, double monto"
// En el main, Toca instanciar un pago de cada tipo y llamar al metodo "RealizarPago"
// EN autentificar solo poner un mensaje "de autentificando"
// En prcesarPago con targeta y paypal poner un mensaje "Se esta pagando con tal, "


// Main
// Monto a pagar por consola
// menu de pagos
    // 1. efectivo
    // 2. targeta (Ingresar usuario)
    // 3. paypal    (Ingresar usuario)
    // 4. cancelar



// hacer UML 2pto
// Uso adecuado del Interface 1.5 ptos
// Polimorfismo 1 ptos
// Que corra el progra 3 pto
// que este bien estructurad 1 pto