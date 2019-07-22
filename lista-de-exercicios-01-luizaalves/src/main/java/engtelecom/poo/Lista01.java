package engtelecom.poo;

/**
 * Instituto Federal de Santa Catarina - IFSC
 * Engenharia de Telecomunicações
 * POO29004 - Programação Orientada a Objetos
 *
 * Lista de exercício 01
 */
public class Lista01 {



    /**
     * Método que é chamado pelo sistema operacional
     *
     * @param args argumentos de linha de comando
     */
    public static void main(String[] args) {
        int[][] x = {{0,9,4,8,0,2,7,9,9,1,6}};
        int[][] n1 = {{1,2,3},{1,2,3,},{1,2,3}};
        int[][] n2 = {{1,2,3},{1,2,3,},{1,2,3}};

        Exercicio01 ex01 = new Exercicio01();
        System.out.println("Ex01: " + ex01.tipoTriangulo(5,8,9));

        Exercicio02 ex02 = new Exercicio02();
        System.out.println("Ex02: " + ex02.somaSerieHarmonica(4));

        Exercicio03 ex03 = new Exercicio03();
        System.out.println("Ex03: " + ex03.cpfValido(x));

        Exercicio04 ex04 = new Exercicio04();

        int[][] n3 = ex04.gerarCpf(3);
        System.out.println("Ex04: ");
        for(int a=0;a<3;a++) {
            for(int b=0;b<11;b++) {
                System.out.print(n3[a][b]);
            }
            System.out.println();
        }

        Exercicio05 ex05 = new Exercicio05();
        System.out.println("Ex05: " + ex05.somaMatrizes(n1,n2));
    }

}
