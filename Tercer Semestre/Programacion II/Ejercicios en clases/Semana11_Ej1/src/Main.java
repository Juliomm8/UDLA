public class Main {
    public static void main(String[] args){
        Pajaro pajaro = new Pajaro();
        Avion avion = new Avion();

        ejecutarVuelo(pajaro);
        ejecutarVuelo(avion);
    }

    public static void ejecutarVuelo(Volador volador){
        volador.volar();
    }

}
