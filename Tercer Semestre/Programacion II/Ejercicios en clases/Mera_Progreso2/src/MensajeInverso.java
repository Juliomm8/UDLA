public class MensajeInverso  extends Mensaje {
    public MensajeInverso(String contenidoOriginal) {
        super(contenidoOriginal);
    }

    private String reverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public String cifrar() {
        StringBuilder resultado = new StringBuilder();
        String textoInvertido = reverseString(getContenidoOriginal());
        int clave = getClaveCifrado();

        for (char c : textoInvertido.toCharArray()) {
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
