public class Erb {
    private int pos;
    private int id;
    private static int count;

    /**
     * construtor da erb
     * @param pos posição a ser inserida a erb
     */
    public Erb(int pos) {
        this.pos = pos;
        count++;
        this.id = count;
    }

    /**
     * obtem a posição da erb
     * @return retorna a posição da erb
     */
    public int getPos() {
        return pos;
    }

    /**
     * obtem a id da erb
     * @return retorna a id da erb
     */
    public int getId() {
        return id;
    }

    /**
     * Mensagem do usuario passando pela erb
     * @return retorna dados da erb por onde passou a mensagem
     */
    public String enviarMensagem() {
        return ("Mensagem chegou na ERB ID: "+this.id+", localização: "+this.pos+"\n");
    }

    /**
     * Dados da erb
     * @return retorna uma string com o id e posição da erb
     */
    public String toString() {

        return "ID: " +this.id+", posição: " + this.pos +"\n";
    }
}
