package engtelecom.poo;

import engtelecom.poo.Exercicio01;
import engtelecom.poo.Exercicio02;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Classe para realizar testes de unidade e verificar a corretude das soluções desenvolvidas pelos alunos
 *
 * Alguns exemplos de como usar JUnit podem ser obtidos aqui: https://github.com/junit-team/junit4/wiki/Assertions
 */
public class TesteDeValidacao {



    @Test
    public void exercicio01(){
        Exercicio01 ex = new Exercicio01();
        assertEquals("falha no ex01", "Equilátero", ex.tipoTriangulo(3,3,3));
        assertEquals("falha no ex01", "Isósceles", ex.tipoTriangulo(3,3,4));
        assertEquals("falha no ex01", "Escaleno", ex.tipoTriangulo(3,4,5));
        assertEquals("falha no ex01","não forma um triangulo",ex.tipoTriangulo(10,3,5));
    }


    @Test
    public void exercicio02() {
        Exercicio02 ex = new Exercicio02();
        assertEquals("falha no ex02",1.5, ex.somaSerieHarmonica(2));
        assertEquals("falha no ex02",2.083333333333333, ex.somaSerieHarmonica(4));
        assertEquals("falha no ex02",2.7178571428571425, ex.somaSerieHarmonica(8));
        assertEquals("falha no ex02",3.3807289932289937, ex.somaSerieHarmonica(16));
        assertEquals("falha no ex02",4.05849519543652, ex.somaSerieHarmonica(32));
        assertEquals("falha no ex02",4.7438909037057675, ex.somaSerieHarmonica(64));
    }

    @Test
    public void exercicio03() {
        Exercicio03 ex = new Exercicio03();
        int[][] x = {{0,9,4,8,0,2,7,9,9,1,6}};
        assertEquals("falha no ex03","cpf válido",ex.cpfValido(x));
    }

    @Test
    public void exercicio04() {
        Exercicio04 ex = new Exercicio04();
        Exercicio03 ex3 = new Exercicio03();
        assertEquals("falha no ex04","cpf válido",ex3.cpfValido(ex.gerarCpf(1)));
    }

    @Test
    public void exercicio05(){
        int[][] n1 = {{1,2,3},{1,2,3,},{1,2,3}};
        int[][] n2 = {{1,2,3},{1,2,3,},{1,2,3}};
        String res = "[2 4 6]\n[2 4 6]\n[2 4 6]\n";
        Exercicio05 ex = new Exercicio05();
        assertEquals("falha no ex05",res,ex.somaMatrizes(n1,n2));
    }
}
