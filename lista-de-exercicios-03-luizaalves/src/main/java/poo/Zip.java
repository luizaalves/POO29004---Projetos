package poo;

import java.io.*;
import java.util.zip.*;

public class Zip {
    private int BUFFER = 2048;
    private StringBuilder acesso = new StringBuilder();
    private static char progressChar = '#';
    private File[] dir;

    public Zip(File[] y){
        this.dir = y;
    }

    /**
     * Adiciona arquivos em um ZIP que está sendo criado. Se o arquivo passado for um diretório, então
     * o método é chamado de forma recursiva.
     *
     * @param zos        arquivo ZIP que estará sendo criado
     * @param fileZip    arquivo que se deseja colocar no ZIP
     * @param parentPath caminho do diretório onde o arquivo se encontra
     */
    private synchronized void addFilesRecursively(ZipOutputStream zos, File fileZip, String parentPath) throws IOException {

        String entryFullPath = fileZip.getName();
        StringBuilder sb = new StringBuilder();
        if (fileZip.isDirectory()) {
            for (File arquivo : fileZip.listFiles()) {
                addFilesRecursively(zos, arquivo, entryFullPath);
            }
        } else {
            byte data[] = new byte[BUFFER];
            FileInputStream fi = new FileInputStream(fileZip);
            BufferedInputStream origin = new BufferedInputStream(fi, BUFFER);
            zos.putNextEntry(new ZipEntry(entryFullPath));
            int count,countPorc=0,countBarra=0,porcentagem = 0;
            while ((count = origin.read(data, 0, BUFFER)) != -1) {
                zos.write(data, 0, count);
                int qtia = (int)((fileZip.length()/count)*4)/100;

                if(countBarra==qtia){
                    sb.append(progressChar);
                    countBarra = 0;
                }
                if(countPorc==(((qtia*100)/4)/100)){
                    countPorc=0;
                    porcentagem++;
                }
                countPorc++;
                countBarra++;
                chamaConsole(porcentagem,sb);
            }
            porcentagem = 100;
            chamaConsole(porcentagem,sb);
            zos.closeEntry();
            origin.close();
            fi.close();
        }
    }

    /**
     * Cria um arquivo ZIP contendo todos os arquivos e diretórios que estão contidos no diretório informado
     * como parâmetro.
     *
     * @param diretorio caminho do diretório que contém os arquivos que deverão ser colocados no ZIP
     * @return true se o processo ocorreu com sucesso, false se acontecer algum problema.
     */
    public boolean compressDirectoryRecursively(String diretorio, String arquivoZip,String nomeArq) {
        try {
            FileOutputStream dest = new FileOutputStream(arquivoZip);
            CheckedOutputStream checksum = new CheckedOutputStream(dest, new Adler32());
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(checksum));
            addFilesRecursively(out, new File(diretorio+"/"+nomeArq), "");
            out.flush();
            dest.flush();
            out.close();
            dest.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void chamaConsole(int porcent,StringBuilder atual){
        acesso.delete(0,acesso.length());
        try {
            Thread.sleep((long) 0.5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i< dir.length; i++) {
            acesso.append(dir[i].getName()+".zip "+porcent+"% -> " +atual+"\n");
        }
        System.console();
        System.out.println(acesso);
    }
}
