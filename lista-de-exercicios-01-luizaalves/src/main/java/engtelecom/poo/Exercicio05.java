package engtelecom.poo;
import java.lang.String;

public class Exercicio05 {

    /**
     *
     * Soma duas matrizes 3x3
     *
     * @param n1 primeira matriz
     * @param n2 segunda matriz
     * @return retorna  uma matriz do tipo inteiro com a soma das matrizes
     */

    public String somaMatrizes(int[][] n1,int[][] n2 ) {
        String n12 = "";
        int[][] soma = new int[3][3];

        for(int a=0;a<3;a++) {
            for(int b=0;b<3;b++) {
                soma[a][b] = n1[a][b]+n2[a][b];
            }
        }

        for(int a=0;a<3;a++) {
            n12 = n12 + "[";

            for(int b=0;b<3;b++) {
                n12 = n12 + soma[a][b];
                if(b!=2) n12 = n12+" ";
            }
            n12 = n12 + "]" + "\n";
        }

        return n12;
    }
}
