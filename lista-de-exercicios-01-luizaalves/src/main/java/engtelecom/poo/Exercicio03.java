package engtelecom.poo;


public class Exercicio03 {

    /**
     *
     * Verifica se o cpf digitado é valido;
     *
     * @param cpf cpf digitado pelo usuario;
     * @return retorna uma string: 'cpf válido' ou 'cpf inválido';
     */

    public String cpfValido( int[][] cpf) {

        int count = 1, soma =0, dv1, dv2;

        for(int a=0;a<9;a++,count ++) {
            soma = (cpf[0][a]*count) + soma;
        }

        dv1 = (soma%11)%10;
        count = 0;
        soma = 0;

        for(int a=0;a<9;a++,count ++) {
            soma = (cpf[0][a]*count) + soma;
        }
        soma = soma + (dv1*9);
        dv2 = (soma%11) %10;
        if(cpf[0][9]==dv1) {
            if (cpf[0][10]==dv2) return "cpf válido";
        }
        System.out.println(dv1+" "+dv2);
        return "cpf inválido.";
    }
}
