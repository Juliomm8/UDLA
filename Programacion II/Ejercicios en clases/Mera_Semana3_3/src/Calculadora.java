public class Calculadora {
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int calcularSuma() {
        return this.num1 + this.num2;
    }

    public int calcularResta() {
        return this.num1 - this.num2;
    }

    public int calcularMultiplicacion() {
        return this.num1 * this.num2;
    }

    public float calcularDivision() {
        return (float) this.num1 / this.num2;
    }

}
