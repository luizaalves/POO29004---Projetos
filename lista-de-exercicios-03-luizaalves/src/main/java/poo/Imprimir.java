package poo;

public class Imprimir implements Runnable {
    private String caminhoEntrada;
    private String caminhoSaida;
    private String nomeArq;
    Zip compactar;
    private StringBuilder acesso = new StringBuilder();

    /**
     * Construtor da classe Zip
     * @param args argumentos de entrada (caminho de entrada e caminho de saida);
     * @param nomeArq o nome de cada item a ser zipado;
     */
    public Imprimir(Zip compac,String[] args,String nomeArq){
        this.caminhoEntrada = args[0];
        this.caminhoSaida = args[1];
        this.nomeArq = nomeArq;
        this.compactar = compac;
    }

    /**
     * sobreescrita do método run, nele é chamado a função que faz o zip;
     */
    @Override
    public void run(){
        compactar.compressDirectoryRecursively(caminhoEntrada, caminhoSaida + nomeArq + ".zip",nomeArq);
    }

}
