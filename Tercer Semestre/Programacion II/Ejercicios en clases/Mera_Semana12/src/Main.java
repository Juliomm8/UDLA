import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        String[] a = new String[4];


        // System.out.println(5/0);

        try {
            a[0] = "0";
            a[1] = "1";
            a[2] = "2";
            a[3] = "3";
            a[4]= "4";

            for (String s : a){
                System.out.println(s);
            }


        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {

        }


        System.out.println();

    }
}