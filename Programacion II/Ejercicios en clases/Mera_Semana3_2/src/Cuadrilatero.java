public class Cuadrilatero {
    private int largo;
    private int ancho;

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int calcularArea() {
        return this.largo * this.ancho;
    }

    public int calcularPerimetro() {
        return 2 * (this.largo + this.ancho);
    }
}
