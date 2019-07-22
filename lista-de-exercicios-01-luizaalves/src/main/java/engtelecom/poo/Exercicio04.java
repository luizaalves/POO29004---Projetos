package engtelecom.poo;
import java.util.Random;
import  java.lang.String;

public class Exercicio04 {

    /**
     *
     * Gera um cpf válido
     *
     * @param n quantidade de cpfs que o usuario pediu
     * @return retorna uma matriz de inteiros com os cpfs requeridos valido
     */

    public int[][] gerarCpf(int n) {

        int cpfs[][] = new int[n][11];
        int count = 1, soma =0, dv1, dv2;
        for(int b=0;b<n;b++) {
            Random r = new Random();

            for (int a = 0; a < 9; a++) {
                cpfs[b][a] = r.nextInt(10);
            }

            for (int a = 0; a < 9; a++, count++) {
                soma = (cpfs[b][a] * count) + soma;
            }

            dv1 = (soma % 11) % (10);
            count = 0;
            soma = 0;

            for (int a = 0; a < 9; a++, count++) {
                soma = (cpfs[b][a] * count) + soma;
            }
            soma = soma + (dv1 * 9);
            dv2 = (soma % 11) % 10;
            cpfs[b][9] = dv1;
            cpfs[b][10] = dv2;
        }
        return cpfs;
    }
}
