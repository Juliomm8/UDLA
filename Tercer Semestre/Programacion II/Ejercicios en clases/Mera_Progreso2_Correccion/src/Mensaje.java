public abstract class Mensaje {

    protected String contendoOriginal;
    protected int claveCifrado;

    public Mensaje(String contendoOriginal) {
        this.contendoOriginal = contendoOriginal;
        this.claveCifrado = (int)(Math.random() * (10) + 1);
    }

    public abstract String cifrar();

    //getters & setters
    public String getContendoOriginal() {
        return contendoOriginal;
    }

    public void setContendoOriginal(String contendoOriginal) {
        this.contendoOriginal = contendoOriginal;
    }

    public int getClaveCifrado() {
        return claveCifrado;
    }

    public void setClaveCifrado(int claveCifrado) {
        this.claveCifrado = claveCifrado;
    }


    @Override
    public String toString() {
        return "Mensaje: " + "contendoOriginal: " + contendoOriginal + " claveCifrado: " + claveCifrado + "cifrado: " + cifrar();
    }
}
