public class Torneo {
    public static void main(String[] args) {

        Pokemon p = new Pokemon("Snorlax", "Normal", 10, 100);
        Pokemon o = new Pokemon("Carmander", "Fuego", 10, 100);

        System.out.println(p);
        System.out.println(o);
        System.out.println("\n-------------------------\n");

        p.entrenar();
        o.entrenar();


        System.out.println(p);
        System.out.println(o);
        System.out.println("\n-------------------------\n");

        do {
            o.atacar();
            System.out.println(o);

        } while (o.getVida() >= 10);

        if (p.getVida() == 0) {
            System.out.println(o.getNombre() + " murio" );
        }


        System.out.println("\n-------------------------\n");

        System.out.println(p);
        System.out.println(o);

    }
}
