public class ListaEncadeada {
    private Nodo primeiro;
    private Nodo ultimo;
    private static int tamanho;

    /**
     * insere ordenadamente um balão na lista
     * @param algo do tipo balao que será inserido
     * @return retorna true ou false
     */
    public boolean insereOrdenado(Balao algo){
        if(tamanho==0) {
            Nodo atual = primeiro;
            Nodo aux = new Nodo(algo);
            atual = aux;
            atual = aux;
        }
        else {
            Nodo atual = primeiro;
            Nodo aux = new Nodo(algo);

            for (int i = 0; atual!=null; i++,atual=atual.getProximo()) {
                if(aux.getDado().getPos()<atual.getDado().getPos()) {
                    if(tamanho==1){
                        primeiro = aux;
                        aux.setProximo(atual);
                        atual.setAnterior(aux);
                    }
                    else{
                        aux.setAnterior(atual.getAnterior());
                        aux.setProximo(atual);
                        atual.getAnterior().setProximo(aux);
                        atual.setAnterior(aux);
                    }
                    break;
                }
                else if(atual==ultimo){
                    ultimo = aux;
                    aux.setAnterior(atual);
                    atual.setProximo(aux);
                    break;
                }
            }
        }
        tamanho++;
        return true;
    }

    /**
     * obtem o dado de um balão
     * @param pos obtem esse dado atraves da posição
     * @return retorna o balão que possui esse dado
     */
    public Balao obtemDado(int pos){
        Nodo atual = primeiro;
        if(pos==1) {
            return atual.getDado();
        }

        for (int i = 0; i < pos-1; i++,atual=atual.getProximo()) {

        }

        return atual.getDado();
    }

    /**
     * obtem o dado de um balão
     * @param id obtem esse dado atraves do id passado como parametro
     * @return retorna o dado desse balão com essa id
     */
    public Balao obtemDadoId(int id){
        Nodo atual = primeiro;
        if(getTamanho()==1) {
            return atual.getDado();
        }
        for (int i = 0; atual!=null; i++,atual=atual.getProximo()) {
            if(atual.getDado().getId()==id) {
                return atual.getDado();
            }
        }
        return null;
    }

    /**
     * obtem o tamanho da lista
     * @return retorna o tamanho
     */
    public static int getTamanho() {
        return tamanho;
    }

    /**
     * Dados da lista de balões
     * @return retorna esse dados da lista, id e posição do balao
     */
    public String toString() {
        String x = "Balões:\n";
        for (Nodo atual = primeiro; atual!=null; atual=atual.getProximo()) {
            x = x + atual.getDado().toString();
        }

        return x;
    }
}