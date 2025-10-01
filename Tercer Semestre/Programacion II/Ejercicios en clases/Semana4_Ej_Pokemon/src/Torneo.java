public class Torneo {
    public static void main(String[] args) {
        //
        System.out.println("Valores iniciales");
        Pokemon pokemon1 = new Pokemon("Snorlax",    "Normal", 10, 100);
        Pokemon pokemonOponente = new Pokemon("Charmander", "Fuego",  10, 100);

        // Estado inicial
        System.out.println(pokemon1);
        System.out.println(pokemonOponente);

        // Entrenan
        pokemon1.entrenar();
        pokemonOponente.entrenar();
        System.out.println("\nDespués de entrenar:");
        System.out.println(pokemon1);
        System.out.println(pokemonOponente);

        // Batalla
        System.out.println("\nComienza la batalla (solo va atacar " + pokemon1.getNombre() + "):");
        while (pokemonOponente.getVida() > 0) {
            pokemon1.atacar(pokemonOponente);
            System.out.println("Vida de " + pokemonOponente.getNombre() + " es: " + pokemonOponente.getVida());
        }

        // Mensaje final
        System.out.println("\n" + pokemonOponente.getNombre() + " ha perdido.");
        System.out.println(pokemon1.getNombre() + " gana! :3");
    }
}
