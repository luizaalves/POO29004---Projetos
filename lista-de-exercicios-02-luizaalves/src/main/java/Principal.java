import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private ArrayList<Erb> listaErbs;
    private ListaEncadeada listaBalao;

    /**
     * construtor do main, inicializa os atributos
     */
    public Principal(){
        listaErbs = new ArrayList<Erb>();
        listaBalao = new ListaEncadeada();
    }

    /**
     * metodo onde sera colocada o menu para o usuario escolher opções
     * @param args obrigatorio no main
     */
    public static void main(String[] args) {

        Principal x = new Principal();
        int op = 0;
        int pos;
        int id;

        Scanner ler = new Scanner(System.in);


        while(op!=9) {
            System.out.println("1. Cadastrar estação rádio base terrestre. \n"+
                            "2. Remover estação rádio base terrestre. \n" +
                            "3. Imprimir os dados de todas estações rádio base terrestres. \n"+
                            "4. Lançar balão. \n" +
                            "5. Imprimir todos os dados de um balão específico. \n"+
                            "6. Simular a movimentação dos balões. \n"+
                            "7. Imprimir somente o identificador e as coordenadas de todos os balões. \n"+
                            "8. Simular o usuário enviando uma mensagem e essa sendo entregue em uma ERB. \n"+
                            "9. Sair do programa.\n");

            op = ler.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Posição que deseja inserir: ");
                    pos = ler.nextInt();
                    if(x.cadastrarErb(pos)){
                        System.out.println("ERB cadastrada com sucesso!\n");
                    }
                    else System.err.println("ERB tem que está a no mínimo a 40 km de outra ERB ja cadastrada.");
                    break;

                case 2:
                    System.out.println("ID da ERB que deseja remover: ");
                    id = ler.nextInt();
                    if(x.removerErb(id)){
                        System.out.println("ERB removida com sucesso!\n");
                    }
                    else System.err.println("ERB não pode ser removida.\n");
                    break;

                case 3:
                    if(x.imprimirErb()==null){
                        System.err.println("Não tem ERBs cadastradas.\n");
                    }
                    else System.out.println(x.imprimirErb());
                    break;

                case 4:
                    System.out.println("Posição do balão que deseja lançar: ");
                    pos = ler.nextInt();
                    if(x.lancarBalao(pos)){
                        System.out.println("Balão cadastrado com sucesso!\n");
                    }
                    else System.err.println("Balão não lançado.\n");
                    break;

                case 5:
                    System.out.println("ID do balão que deseja imprimir: ");
                    id = ler.nextInt();
                    if(x.imprimirBalao(id)==null){
                        System.err.println("ID não encontrada.");
                    }
                    else System.out.println(x.imprimirBalao(id));
                    break;

                case 6:
                    int desl ;
                    System.out.println("Quantidade de deslocamento dos balões:");
                    desl = ler.nextInt();
                    if(x.simulaMov(desl)){
                        System.out.println("Balões deslocados com sucesso.\n");
                    }
                    else System.err.println("Não foi possível concluir essa movimentação dos balões.\n");
                    break;

                case 7:
                    if(x.imprimirBaloes()==null){
                        System.err.println("Não possui balões lançados.\n");
                    }
                    else System.out.println(x.imprimirBaloes());
                    break;

                case 8:
                    String sms = "";
                    System.out.println("Sua localização atual: ");
                    pos = ler.nextInt();
                    ler.nextLine();
                    System.out.println("Mensagem: ");
                    sms = ler.nextLine();
                    if(x.mensagem(sms,pos)==null){
                        System.err.println("Não há balões lançados.\n");
                    }
                    else System.out.println(x.mensagem(sms,pos));
                    break;

                case 9:
                    break;
            }
        }
    }

    /**
     * cadastra uma erb
     * @param pos passa a posição da erb a ser inserida
     * @return retorna se foi ou não inserida (com true ou false)
     */
    public boolean cadastrarErb(int pos){
        if(listaErbs.isEmpty()){
            listaErbs.add(new Erb(pos));
            return true;
        }
        else{
            for (int i = 0; i <listaErbs.size(); i++){
                if(Math.abs(listaErbs.get(i).getPos() - pos)<=39){
                    return false;
                }
            }
        }
        listaErbs.add(new Erb(pos));
        return true;
    }

    /**
     * remove uma erb
     * @param id passa a id da erb a ser removida
     * @return retorna se foi ou não removida (com true ou false)
     */
    public boolean removerErb(int id){
        for (int i = 0; i <listaErbs.size(); i++){
            if(listaErbs.get(i).getId() == id){
                Erb x = listaErbs.get(i);
                listaErbs.remove(i);
                if(listaErbs.size()==0) {
                    listaErbs.add(x);
                    return false;
                }
                else{
                    if(listaBalao.getTamanho()==0) {
                        return true;
                    }
                    for (int j = 0; j < listaErbs.size(); j++) {
                        for (int k = 0; k < listaBalao.getTamanho(); k++) {
                            if(Math.abs(listaErbs.get(j).getPos()-listaBalao.obtemDado(i+1).getPos())<=40){
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * imprime as erbs cadastradas
     * @return retorna os dados dessas erbs
     */
    public String imprimirErb(){
        String x = "";
        if(listaErbs.size()==0){
            return null;
        }
        for (int i = 0; i < listaErbs.size(); i++) {
            x = x + listaErbs.get(i).toString();
        }
        return x;
    }

    /**
     * enviando mensagem para o balão
     * @param sms a mensagem a ser transmitida
     * @param loc a localização atual da pessoa que está enviando a mensagem
     * @return retorna o historico por onde a mensagem passou
     */
    public String mensagem(String sms, int loc){
        String x = "";
        if(listaErbs.size()==0){
            if(listaBalao.getTamanho()==0){
                return null;
            }
        }
        else{
            for (int i = 0; i < listaBalao.getTamanho(); i++) {

                if(listaBalao.obtemDado(i+1).getPos()>loc){ //se a localização do sms for menor que o a do balao atual
                    x = x + (listaBalao.obtemDado(i+1).enviarMensagem());//pega a info do balao

                    if(listaBalao.obtemDado(i+1).posicaoErbs(listaErbs)!=null){
                        x = x+ listaBalao.obtemDado(i+1).posicaoErbs(listaErbs);
                        return x;
                    }
                }
            }
        }
        return x;
    }

    /**
     * lança um balão
     * @param loc passa a posição do balao a ser lançado
     * @return retorna se foi ou não inserida (com true ou false)
     */
    public boolean lancarBalao(int loc){
        if(listaErbs.isEmpty()) {
            return false;
        }
        else {
            if(listaBalao.getTamanho()==0) {
                for (int i = 0; i <listaErbs.size(); i++){
                    if(Math.abs(listaErbs.get(i).getPos() - loc)<=40){
                        listaBalao.insereOrdenado(new Balao(loc));
                        return true;
                    }
                }
                return false;
            }
            else {
                for (int i = 0; i <listaBalao.getTamanho(); i++){
                    if(Math.abs(listaBalao.obtemDado(i+1).getPos() - loc)<=40){
                        listaBalao.insereOrdenado(new Balao(loc));
                        return true;
                    }
                }
                return false;
            }
        }
    }

    /**
     * movimenta a posição dos balões
     * @param desl passa o quanto quer deslocar
     * @return retorna se foi ou não deslocada (com true ou false)
     */
    public boolean simulaMov(int desl){
        for (int i = 0; i < listaBalao.getTamanho(); i++) {
            int valor = listaBalao.obtemDado(i+1).getPos();
            listaBalao.obtemDado(i+1).setPos(valor+desl);
        }
        for (int i = 0; i < listaBalao.getTamanho(); i++) {
            for (int j = 0; j < listaErbs.size(); j++) {
                if(Math.abs(listaBalao.obtemDado(i+1).getPos()-listaErbs.get(j).getPos())<40){
                    return true;
                }
            }
        }
        for (int i = 0; i < listaBalao.getTamanho(); i++) {
            int valor = listaBalao.obtemDado(i+1).getPos();
            listaBalao.obtemDado(i+1).setPos(valor-desl);
        }
        return false;
    }

    /**
     * dados dos balões
     * @return retorna os dados dos balões(ID e posição)
     */
    public String imprimirBaloes(){
        if(listaBalao.getTamanho()==0) {
            return null;
        }
        return listaBalao.toString();
    }

    /**
     * dados de um balão especifico
     * @param id passa a id do balão como parametro
     * @return retorna os dados desse balão com essa id
     */
    public String imprimirBalao(int id){
        if(listaBalao.obtemDadoId(id).toString()==null) {
            return null;
        }
        return "Balão: \n"+listaBalao.obtemDadoId(id).toString();
    }
}