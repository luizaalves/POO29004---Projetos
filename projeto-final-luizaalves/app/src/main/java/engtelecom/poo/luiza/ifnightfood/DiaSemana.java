package engtelecom.poo.luiza.ifnightfood;

public class DiaSemana {
    private  String dia;
    private String[] lanches;

    public  DiaSemana(String dia, String[] lanches) {
        this.dia = dia;
        this.lanches = lanches;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String[] getLanches() {
        return lanches;
    }

    public void setLanches(String[] lanches) {
        this.lanches = lanches;
    }
}
