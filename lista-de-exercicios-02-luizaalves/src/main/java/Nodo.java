public class Nodo {
    private Balao dado;
    private Nodo proximo;
    private Nodo anterior;

    /**
     * construtor do nodo
     * @param valor do tipo balão
     */
    public Nodo(Balao valor) {

        this.dado = valor;
    }

    /**
     * obtem o dado que é um balão
     * @return o dado
     */
    public Balao getDado() {
        return dado;
    }

    /**
     * obtem o proximo nodo
     * @return retorna o proximo nodo
     */
    public Nodo getProximo() {
        return proximo;
    }

    /**
     * altera o valor do proximo nodo
     * @param proximo o novo valor do proximo nodo
     */
    public void setProximo(Nodo proximo) {

        this.proximo = proximo;
    }

    /**
     * obtem o nodo anterior
     * @return retorna o nodo anterior
     */
    public Nodo getAnterior() {

        return anterior;
    }

    /**
     * altera o valor do novo anterior
     * @param anterior o novo valor do nodo anterior
     */
    public void setAnterior(Nodo anterior) {

        this.anterior = anterior;
    }
}