public class MensajeSimple extends Mensaje{

    public MensajeSimple(String contendoOriginal) {
        super(contendoOriginal);
    }

    @Override
    public String cifrar()
    {
        StringBuilder cifrado  = new StringBuilder();

        for(char c: getContendoOriginal().toCharArray()){

            if(c >= 'a' && c <= 'z'){
                char letraCifrada = (char)((c - 'a' + getClaveCifrado()) %26 + 'a');
                cifrado.append(letraCifrada);

            }else{
                cifrado.append(c);
            }
        }
        return cifrado.toString();
    }
}
