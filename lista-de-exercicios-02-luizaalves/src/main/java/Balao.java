import java.util.ArrayList;

public class Balao {
    private int id;
    private int pos;
    private static int count;

    /**
     * Construtor do balão
     * @param pos posição do balão a ser lançado
     */
    public Balao(int pos) {
        this.pos = pos;
        count++;
        this.id = count;
    }

    /**
     * Mensagem do usuario passando pelo balao
     * @return retorna dados do balão por onde passou a mensagem
     */
    public String enviarMensagem() {
        return ("Mensagem passou pelo balão ID: "+this.id+", localização: "+this.pos+"\n");
    }

    /**
     * Posição das erbs para verificar se possui alguma erb proxima a aquele balão
     * @param erbs lista de erbs que estão cadastradas
     * @return se houver uma erb proxima daquele balão retorna ele, ou retorna null se não
     */
    public String posicaoErbs(ArrayList<Erb> erbs) {
        for (int j = 0; j < erbs.size(); j++) {//agr verifica o balao mais proximo dessa erb
            if(Math.abs(erbs.get(j).getPos()-getPos())<=40){
                return erbs.get(j).enviarMensagem();
            }
        }
        return null;
    }

    /**
     * Alterar o valor da posição do balao
     * @param pos nova posição
     */
    public void setPos(int pos) {
        this.pos = pos;
    }

    /**
     * posição atual do balão
     * @return retorna a posição
     */
    public int getPos() {
        return pos;
    }

    /**
     * ID do balao
     * @return retorna o valor do id do balao
     */
    public int getId() {
        return id;
    }

    /**
     * Dados do balão
     * @return retorna uma string com o id e posição do balão
     */
    public String toString() {
        return "Id: "+this.id+", posição: "+this.pos+"\n";
    }

}