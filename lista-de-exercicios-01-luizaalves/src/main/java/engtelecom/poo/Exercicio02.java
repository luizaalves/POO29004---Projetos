package engtelecom.poo;

public class Exercicio02 {

    /**
     * Faz a soma de uma série harmônica: 1 + 1/2 + 1/3 + 1/4 + 1/5 + ...
     *
     * @param n número de elementos da série
     * @return retorna um inteiro com o valor da soma da série harmônica
     */
    public double somaSerieHarmonica(int n) {
        double resultado = 0;
        for(int a=0;a<n;a++) {
            resultado = resultado + (1.0/((double)a+1.0));
        }

        return resultado;
    }

}
