package engtelecom.poo;

public class Exercicio01 {

    /**
     *
     * Verifica se os valores passados como parâmetro formam ou não um triângulo, indicando ainda qual o tipo do triângulo.
     *
     * @param a lado a do triangulo
     * @param b lado b do triangulo
     * @param c lado c do triangulo
     * @return retorna as seguintes Strings: 'equilátero', 'isósceles', 'escaleno' ou 'não forma um triângulo'
     */
    public String tipoTriangulo(int a, int b, int c) {
        String tipo = null;
        if(((b+c)>a) && ((a+c)>b) && ((a+b)>c)) {
            if ((a * b) == (a * c) && (a * b) == (b * c)) {
                tipo = "Equilátero";
            }
            else if ((a * b) != (a * c) && (a * c) != (b * c) && (b * c) != (a * b)) {
                tipo = "Escaleno";
            }
            else if ((a == b && b != c) || (a == c && b != a) || (b == c && a != c)) {
                tipo = "Isósceles";
            }
        }
        else tipo = "não forma um triangulo";

        return tipo;
    }
}