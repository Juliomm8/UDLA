import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Figura> figuras = new ArrayList<>();

        int numCirculos = (int) (Math.random() * 4 + 1);
        for (int i = 0; i < numCirculos; i++) {
            figuras.add(new Circulo());
        }

        int numRectangulos = (int) (Math.random() * 4 + 1);
        for (int i = 0; i < numRectangulos; i++) {
            figuras.add(new Rectangulo());
        }

        for (int i = 0; i < figuras.size(); i++) {
            Figura figura = figuras.get(i);
            System.out.println("\nFigura #" + (i + 1));

            if (figura instanceof Circulo) {
                Circulo circulo = (Circulo) figura;
                System.out.println("Tipo: Círculo");
                System.out.println("Radio: " + circulo.getRadio());
            }
            if (figura instanceof Rectangulo) {
                Rectangulo rectangulo = (Rectangulo) figura;
                System.out.println("Tipo: Rectángulo");
                System.out.println("Base: " + rectangulo.getBase());
                System.out.println("Altura: " + rectangulo.getAltura());
            }

            System.out.println("Área: " + figura.calcularArea());
            System.out.println("Perímetro: " + figura.calcularPerimetro());
            System.out.println("---------------------------------------");
        }

        System.out.println("\nTotal de figuras: " + figuras.size());
        System.out.println("Círculos generados: " + numCirculos);
        System.out.println("Rectángulos generados: " + numRectangulos);
    }

}