public class Main {
    public static void main(String[] args) {

        Cuenta c = new Cuenta();
        Cuenta d = new Cuenta();
        Cuenta e = new Cuenta();

        //------------- C ---------------
        c.setNum("6516165156");
        c.setTitular("Miguel Perez");
        c.reintegro(1000f);
        c.setInteresAnual(0.25f);
        c.ingresoInteresMes();  // <- AQUI

        //------------- D ---------------
        d.setNum("165198198");
        d.setTitular("Javier Sanchez");
        d.reintegro(1000f);
        d.setInteresAnual(1.25f);
        d.ingresoInteresMes();  // <- AQUI

        //------------- E ---------------
        e.setNum("64446984");
        e.setTitular("cuenta 3");
        e.reintegro(1000f);
        e.setInteresAnual(2.25f);
        e.ingresoInteresMes();  // <- AQUI

        //------------- E ---------------
        System.out.println("------------------");
        System.out.println("Nombre: " + e.getTitular());
        System.out.println("Numero de cuenta: " + e.getNum());
        System.out.println("Saldo: " + e.getSaldo());
        System.out.println("Interes anual: " + e.getInteresAnual());
        System.out.println("------------------");

        //------------- D --------------
        System.out.println("------------------");
        System.out.println("Nombre: " + d.getTitular());
        System.out.println("Numero de cuenta: " + d.getNum());
        System.out.println("Saldo con interés mensual: " + d.getSaldo());
        System.out.println("Interes anual: " + d.getInteresAnual());
        System.out.println("------------------");

        //------------- C ------------------
        System.out.println("Nombre: " + c.getTitular());
        System.out.println("Numero de cuenta: " + c.getNum());
        System.out.println("Saldo con interés mensual: " + c.getSaldo());
        System.out.println("Interes anual: " + c.getInteresAnual());
        System.out.println("------------------");
    }
}
