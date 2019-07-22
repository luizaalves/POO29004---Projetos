package engtelecom.poo.luiza.ifnightfood;

public class Cardapio {
    private DiaSemana[] cardapio;

    public Cardapio(DiaSemana[] cardapio) {
        this.cardapio = cardapio;
    }

    public DiaSemana[] getCardapio() {
        return cardapio;
    }

    public void setCardapio(DiaSemana[] cardapio) {
        this.cardapio = cardapio;
    }
}
