public class Cuenta {
    private String num;
    private String titular;
    private float saldo;
    private float interesAnual;



    public void ingreso(float cantidad){
        //el "." permite acceder a los atributos de los objetos
        this.saldo += cantidad;//acceder al atributo saldo de ingreso
    }
    //-----------------------------------------------num----------------------------------------------------------
    //getter
    public  String getNum(){
        return this.num;
    }

    //setter
    public void setNum(String num) {
        this.num = num;
    }


    //---------------------------------------------titular--------------------------------------------------------

    public  String getTitular(){
        return this.titular;
    }

    public void setTitular(String titular){
        this.titular = titular;

    }

    //---------------------------------------------saldo----------------------------------------------------------
    public float getSaldo(){
        return this.saldo;
    }
    //--------------------------------------------interesanual----------------------------------------------------
    public float getInteresAnual(){
        return this.interesAnual;
    }

    public void setInteresAnual(float interesAnual){
        this.interesAnual = interesAnual;
    }
    // ----------------------------------------------metodos----------------------------------------------------

    //ingresa un float, no retorna nada
    public void reintegro(float cantidad) {
        this.saldo = cantidad;
    }

    //no tiene ingreso de variable, no retonra nada
    public void ingresoInteresMes(){
        this.saldo = this.saldo + (this.saldo * interesAnual / 12);
    }

    //no tiene ingreso de variables, retorna un bool
    public boolean enRojos(){
        return this.saldo < 0;
    }
}

