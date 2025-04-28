public class Robot {
    private String modelo;
    private int energia;
    private int fuerza;
    private int defensa;

    public static int contadorRecarga = 0;

    public Robot() {
        this.modelo = modelo;
        this.energia = energia;
        this.fuerza = fuerza;
        this.defensa = defensa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void recargarEnergia() {
        this.setEnergia(this.getEnergia() + 20);

        contadorRecarga++;
    }

    public void atacar(Robot objetivo) {
        int resultadoAtaque = objetivo.getEnergia() - (this.getFuerza() - objetivo.getDefensa());
        objetivo.setEnergia(resultadoAtaque);

        System.out.println("Robot " + this.modelo + " ataco al robot " + objetivo.modelo + "con un ataque de " + resultadoAtaque);

        if (objetivo.energia <= 0) {
            System.out.println("Robot " + objetivo.modelo + " a sido desactivado");
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "nombre='" + modelo + '\'' +
                ", energia=" + energia +
                ", fuerza=" + fuerza +
                ", defensa=" + defensa +
                ", contadorRecarga=" + contadorRecarga +
                '}';
    }
}
