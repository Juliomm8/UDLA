public class MensajeInverso extends Mensaje{

    public MensajeInverso(String contendoOriginal) {
        super(contendoOriginal);
    }

    @Override
    public String cifrar()
    {
        String invertido = new StringBuilder(getContendoOriginal()).reverse().toString();

        StringBuilder cifrado  = new StringBuilder();

        for(char c: invertido.toCharArray()){
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
