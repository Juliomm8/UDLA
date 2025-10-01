public class Main {
    public static void main(String[] args) {
        Fecha f1 = new Fecha(02, 04, 2004);
        Fecha f2 = new Fecha(28, 03, 2025);


        Empleado e = new Empleado("17184211", "Julio", "Mera",
                'M', 0, f1, f2);

        //System.out.println(e.getCedula()
        //        + " " + e.getNombre() + " " + e.getApellido());

        System.out.println(e);

    }
}