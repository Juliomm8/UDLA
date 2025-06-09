public class AdministradorDeDispositivos {
    public void gestionarConeccion(Conectable dispositivo) {
        dispositivo.conectar();
        System.out.println("Se ejecutan las acciones del dispositivo");
        dispositivo.desconectar();
    }
}





