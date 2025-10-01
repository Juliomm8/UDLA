public class Monitor implements Conectable{
    @Override
    public void conectar() {
        System.out.println("Conectado al monitor");
    }
    @Override
    public void desconectar() {
        System.out.println("Desconectado del monitor");
    }
}
