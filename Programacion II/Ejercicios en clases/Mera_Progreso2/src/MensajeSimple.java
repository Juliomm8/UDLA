public class MensajeSimple extends Mensaje{
    public MensajeSimple(String contenidoOriginal) {
        super( contenidoOriginal);
    }

    public String cifrar() {
        StringBuilder resultado = new StringBuilder();
        String texto = getContenidoOriginal();
        int clave = getClaveCifrado();

        for (char c : texto.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                char cifrado = (char) ((c - 'a' + clave) % 26 + 'a');
                resultado.append(cifrado);
            } else {
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

}
