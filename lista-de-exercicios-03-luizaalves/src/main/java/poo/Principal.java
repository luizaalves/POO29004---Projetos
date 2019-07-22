package poo;

import java.io.*;

public class Principal {
    private static char progressChar = '#';
    /**
     * Função que chama as Threads
     * @param args caminho de entrada e de saída via argumentos de entrada
     */

    public static void main(String[] args) {
        if(args.length == 2) {
            File entrada = new File(args[0]);
            File[] y = entrada.listFiles();
            Zip compac = new Zip(y);

            for (int i = 0; i < y.length; i++) {
                Thread x = new Thread(new Imprimir(compac,args,y[i].getName()));
                x.start();
            }
        }
        else System.err.println("Argumentos de entrada incorretos.");
    }
}

