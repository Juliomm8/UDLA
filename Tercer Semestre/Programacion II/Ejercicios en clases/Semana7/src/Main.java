import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Camion("Chery", "1234", 1.2f));
        vehiculos.add(new Carro("Chery", "5678", 3));

        for(Vehiculo vehiculo : vehiculos){
            System.out.println(vehiculo.toString());//polimorfismo
        }
    }
}