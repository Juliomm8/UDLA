
public class Rectangulo extends Figura {
    private int base;
    private int altura;

    public Rectangulo() {
        this.base = (int) (Math.random() * 5 + 1);
        this.altura = (int) (Math.random() * 5 + 1);
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double calcularArea() {
        return base * altura;
    }

    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}