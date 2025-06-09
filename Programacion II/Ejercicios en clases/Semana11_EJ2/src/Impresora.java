public class Impresora implements Conectable{
    @Override
    public void conectar() {
        System.out.println("Conectado a la impresora");
    }
    @Override
    public void desconectar() {
        System.out.println("Desconectado de la impresora");
    }

}
