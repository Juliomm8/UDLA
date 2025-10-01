public class Main {
    public static void main(String[] args) {
        Impresora impresora = new Impresora();
        Monitor monitor = new Monitor();

        AdministradorDeDispositivos admin = new AdministradorDeDispositivos();

        admin.gestionarConeccion(impresora);
        admin.gestionarConeccion(monitor);
    }
}


