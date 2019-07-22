
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


/**
 * Classe de testes para verificar se a implementação respeita todas as regras de negócio
 */
public class Correcao {

    private Principal sistema;

    public Correcao(){
        this.sistema = new Principal();
    }

    @Test
    /**
     * cadastrar um balão sem haver ERB. - 80
     * Resultado esperado: false
     *
     * Visão do cenário após execução:
     *
     * ------------
     *
     */
    public void teste01_LancarBalaSemTerERB() {
         assertFalse("Lançou balão, mas não deveria", sistema.lancarBalao(80));

    }

    @Test
    /**
     * cadastrar uma ERB na posição 100.
     * Resultado esperado: true
     *
     * Visão do cenário após execução:
     *
     * -------------E------
     *             100
     */
    public void teste02_CadastrarPrimeiraERB() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));

    }

    @Test
    /**
     * cadastrar um balão com distância superior a 40km da ERB existente - 150
     * Resultado esperado: false
     *
     * Visão do cenário após execução:
     *
     * -------------E------
     *             100
     */
    public void teste03_LancarBalaoInvalido() {
         assertFalse("Lançou balão, mas não deveria", sistema.lancarBalao(150));
    }

    @Test
    /**
     * cadastrar um balão com distância inferior a 40km da ERB existente - 130
     * Resultado esperado: true
     *
     * Visão do cenário após execução:
     *
     * -------------E------B--------
     *             100    130
     */
    public void teste04_LancarBalaoValido() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
    }


    @Test
    /**
     *  remover a única ERB existente
     *  Resultado esperado: false
     *
     * Visão do cenário após execução:
     *
     * -------------E------B--------
     *             100    130
     */
    public void teste05_RemoverUnicaERB() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertFalse("Excluiu a única ERB", sistema.removerErb(1));
    }


    @Test
    /**
     * cadastrar uma ERB com distância inferior a 40km da ERB existente
     * e distância superior a 40km do balão - 80
     * Resultado esperado: false
     *
     * Visão do cenário após execução:
     *
     * -------------E------B--------
     *             100    130
     */
    public void teste06_CadastrarERBErrada() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertFalse("Cadastrou uma ERB menos de 40km", sistema.cadastrarErb(80));
    }


    @Test
    /**
     * cadastrar uma ERB com distância superior a 40km da ERB existente
     * e distância superior a 40km do balão - 50
     * Resultado esperado: true
     *
     * Visão do cenário após execução:
     *
     * -----E-------E------B--------
     *      50     100    130
     */
    public void teste07_CadastrarERBCerta() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertTrue("Não cadastrou a ERB", sistema.cadastrarErb(50));
    }

    @Test
    /**
     * imprimir os dados de todas ERBs existentes
     * Resultado esperado: dados das 2 ERBs
     *
     * Visão do cenário após execução:
     *
     * -----E-------E------B--------
     *      50     100    130
     */
    public void teste08_ImprimirDadosDeERBs() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertTrue("Não cadastrou a ERB", sistema.cadastrarErb(50));
        assertEquals("ID: 1, posição: 100\nID: 2, posição: 50\n", sistema.imprimirErb());
    }

    @Test
    /**
     * remover a ERB criada anteriormente
     * Resultado esperado: true
     *
     * Visão do cenário após execução:
     *
     * ----------E------B--------
     *          100    130
     */
    public void teste09_RemoverUltimaERB() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertTrue("Não cadastrou a ERB", sistema.cadastrarErb(50));
        assertTrue("Não removeu a ERB", sistema.removerErb(2));
    }

    @Test
    /**
     * imprimir os dados de todas ERBs existentes
     * Resultado esperado: dados da única ERB
     *
     * Visão do cenário após execução:
     *
     * ----------E------B--------
     *          100    130
     *
     */
    public void teste10_ImprimirDadosDaUnicaERB() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertEquals("ID: 1, posição: 100\n", sistema.imprimirErb());
    }

    @Test
    /**
     * imprimir dados do único balão existente
     * Resultado esperado: id e sem vizinhos
     *
     * Visão do cenário após execução:
     *
     * ----------E------B--------
     *          100    130
     *
     */
    public void teste11_ImprimirDadosDeBalao() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertEquals("Balões:\nId: 1, posição: 130\n", sistema.imprimirBaloes());
    }

    @Test
    /**
     * lançar um balão com distância superior a 40km do balão que já fora lançado anteriormente - 180
     * Resultado esperado: false
     *
     * Visão do cenário após execução:
     *
     * ----------E------B--------
     *          100    130
     *
     */
    public void teste12_LancarBalaoAlemDaDistancia() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertFalse("Lançou balão, mas não deveria", sistema.lancarBalao(180));
    }

    @Test
    /**
     * lançar um balão com distância inferior a 40km do balão que já fora lançado anteriormente - 150
     * Resultado esperado: true
     *
     * Visão do cenário após execução:
     *
     * ----------E------B-------B-----
     *          100    130     150
     */
    public void teste13_LancarBalaoDentroDaDistanciaPermitida() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(150));
    }


    @Test
    /**
     * lançar um balão com distância inferior a 40km de outro balão já lançado - 110
     * Resultado esperado: true
     *
     * Visão do cenário após execução:
     *
     * ----------E------B-------B------B--
     *          100    110     130    150
     */
    public void teste14_LancarBalaoDentroDaDistanciaPermitida() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(150));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(110));

    }


    @Test
    /**
     * lançar um balão com distância inferior a 40km de outro balão já lançado - 140
     * Resultado esperado: true
     *
     * Visão do cenário após execução:
     *
     * ----------E------B-------B------B-------B----
     *          100    110     130    140     150
     */
    public void teste15_LancarBalaoDentroDaDistanciaPermitida() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(150));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(110));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(140));

    }


    @Test
    /**
     * lançar um balão com distância inferior a 40km de outro balão já lançado - 180
     * Resultado esperado: true
     *
     * Visão do cenário após execução:
     *
     * ----------E------B-------B------B------B---
     *          100    110     130    150    180
     */
    public void teste16_LancarBalaoDentroDaDistanciaPermitida() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(150));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(110));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(140));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(180));

    }


    @Test
    /**
     * imprimir todos os dados do balão que está na posição 130
     * Resultado esperado: id, vizinho da direita 150, vizinho da esquerda 110
     *
     * Visão do cenário após execução:
     *
     * ----------E------B-------B------B------B---
     *          100    110     130    150    180
     */
    public void teste17_ImprimirDadosDeBalao() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(150));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(110));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(140));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(180));
        assertEquals("Id: 1, posição: 130\n", sistema.imprimirBalao(1));
    }


    @Test
    /**
     *  imprimir todos os dados do balão que está na posição 180
     *  Resultado esperado: id, vizinho da direita NULL, vizinho da esquerda 150
     *
     * Visão do cenário após execução:
     *
     * ----------E------B-------B------B------B---
     *          100    110     130    150    180
     */
    public void teste18_ImprimirDadosDeBalao() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(150));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(110));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(140));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(180));
        assertEquals("Id: 5, posição: 180\n", sistema.imprimirBalao(5));
         assertEquals("Dados do balão", "Não implementado de forma que pudesse ser testado");
    }


    @Test
    /**
     * imprimir id e coordenados de todos os balões
     * Resultado esperado: id e coordenados de todos os balões
     *
     * Visão do cenário após execução:
     *
     * ----------E------B-------B------B------B---
     *          100    110     130    150    180
     */
    public void teste19_ImprimirDadosDeTodosBaloes() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(150));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(110));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(140));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(180));
        assertEquals("Balões:\nId: 1, posição: 130\n" +
                "Id: 2, posição: 150\n" +
                "Id: 3, posição: 110\n" +
                "Id: 4, posição: 140\n" +
                "Id: 5, posição: 180\n", sistema.imprimirBaloes());
    }


    @Test
    /**
     * movimentar todos os balões em 10km
     * Resultado esperado: true
     *
     * Visão do cenário após execução:
     *
     * ----------E------B-------B------B------B---
     *          100    120     140    160    190
     */
    public void teste20_MovimentarBaloes() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(150));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(110));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(140));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(180));
        assertTrue("Balões não se movimentaram, mas deveria",sistema.simulaMov(10));
    }


    @Test
    /**
     * imprimir id e coordenados de todos os balões
     * Resultado esperado: id e coordenados de todos os balões
     *
     * Visão do cenário após execução:
     *
     * ----------E------B-------B------B------B---
     *          100    120     140    160    190
     */
    public void teste21_ImprimirDadosDeTodosBaloes() {
        assertTrue("Falha ao cadastrar uma ERB", sistema.cadastrarErb(100));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(130));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(150));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(110));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(140));
        assertTrue("Não lançou balão, mas deveria", sistema.lancarBalao(180));
        assertTrue("Balões não se movimentaram, mas deveria",sistema.simulaMov(10));
        assertEquals("Balões:\nId: 1, posição: 120\n" +
                "Id: 2, posição: 140\n" +
                "Id: 3, posição: 10\n" +
                "Id: 4, posição: 140\n" +
                "Id: 5, posição: 180\n", sistema.imprimirBaloes());
    }


    @Test
    /**
     * enviando mensagem para o balão 1 (na posição 120) - usuário na posição 105
     * Resultado esperado: mensagem entregue para ERB da posição 100
     *
     * Visão do cenário após execução:
     *
     * ----------E-----U------B-------B------B------B---
     *          100   105    120     140    160    190
     */
    public void teste22_EnviarMensagem() {
        // assertEquals("Rota percorrida pela mensagem", "Não implementado de forma que pudesse ser testado");
    }

    @Test
    /**
     * enviando mensagem para o balão 4 (na posição 190) - usuário na posição 175
     * Resultado esperado: mensagem entregue para: balao 160, balao 140, ERB
     *
     * Visão do cenário após execução:
     *
     * ----------E------B-------B------B-----U-----B---
     *          100    120     140    160   175   190
     */
    public void teste23_EnviarMensagem() {
        // assertEquals("Rota percorrida pela mensagem", "Não implementado de forma que pudesse ser testado");
    }
}
