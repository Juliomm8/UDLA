public class Pokemon {
    private String nombre;
    private String tipo;
    private int nivel;
    private int vida;

    public Pokemon(String nombre, String tipo, int nivel, int vida) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void entrenar(){
        setVida(getVida() + 10);
        setNivel(getNivel() + 1);

    }

    public void atacar(){

        setVida(getVida() - 10);

    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nivel=" + nivel +
                ", vida=" + vida +
                '}';
    }

}
