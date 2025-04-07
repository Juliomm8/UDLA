import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Ingrese el primer numero: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int numeroIngresado = Integer.parseInt(num);

        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer numero: ");
        int num = sc.nextInt();
        */

        /**
         *  @return pito
         *
         */


        System.out.println("Numero es " + num  );
    }
}