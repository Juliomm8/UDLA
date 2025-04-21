public class Main {
    public static void main(String[] args) {

        Mascota mascota1 = new Mascota("Kira", "Husky", 3, false);
        Mascota mascota2 = new Mascota("Chuco", "Golden", 8, false);

        // como inicia
        System.out.println(mascota1);
        System.out.println(mascota2);

        // Despues de adoptar
        mascota1.adoptar();

        // adoptar otra vez
        mascota1.adoptar();

        // Devolver
        mascota1.devolver();

        System.out.println(mascota1);
        System.out.println(mascota2);
    }
}