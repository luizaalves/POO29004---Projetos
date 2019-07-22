
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;


public class TesteDeValidacao {


    @Test
    public void testeMain(){

        Principal x = new Principal();
        //CadastrarERB;
        assertTrue("Falha na criação da ERB",x.cadastrarErb(1));
        assertTrue("Falha na criação da ERB",x.cadastrarErb(81));
        assertFalse("ERB cadastrada.",x.cadastrarErb(2));

        //RemoverERB;
        assertTrue("Falha na remoção da ERB", x.removerErb(1));
        x.lancarBalao(80);
        assertFalse("ERB removida.",x.removerErb(2));

        //ImprimirERB;
        assertEquals("Falha na impressão das ERBs.","ID: 2, posição: 81\n",x.imprimirErb());

        //Mensagem;
        assertEquals("Falha no envio da mensagem","Mensagem passou pelo balão ID: 1, localização: 80\nMensagem chegou na ERB ID: 2, localização: 81\n",x.mensagem("oi",70));

        //Lançar balão;
        assertTrue("Falha na criação do balão", x.lancarBalao(90));
        assertFalse("Balão cadastrado.", x.lancarBalao(10));

        //Simular movimentação dos balões;
        assertTrue("Falha na simulação de movimentação dos balões.",x.simulaMov(5));
        assertFalse("Simulação de movimentação dos balões aprovada.",x.simulaMov(40));

        //Imprimir balões;
        assertEquals("Falha na impressão dos balões","Balões:\nId: 1, posição: 85\nId: 2, posição: 95\n",x.imprimirBaloes());
    }

}