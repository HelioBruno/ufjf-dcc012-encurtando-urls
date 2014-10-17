package projeto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import projeto.hash.Hash;
import projeto.io.FileManager;
import projeto.util.Util;

/**
 * Classe de teste temporária
 *
 * @author ana
 */
public class TesteMain {

    /**
     * @param args Argumentos de entrada do programa
     */
    public static void main(String[] args) {
        //Manipulação do arquivo

        FileManager file;
        try {
            file = new FileManager(args[0]);
            //Ler arquivo
            System.out.println("Lendo...");
            ArrayList<String> arq = file.lerArquivo();
            System.out.println("Tamanho do arquivo: " + arq.size());

            //Tratar as urls
            System.out.println("Tratando...");
            Set<String> urls = Util.tratarUrl(arq);
            System.out.println("Urls válidas: " + urls.size());

            //Criar a tabela de hash
            System.out.println("Criando Hash");
            Hash.codificarUrls(urls);
            System.out.println("Colisões:" + Hash.getColisoes());

            //Arquivo com a tabela de hash
            System.out.println("Criando arquivo...");
            file.criarArquivoTbHash();

        } catch (IOException e) {
            System.err.println("Erro na leitura do arquivo.");
            System.exit(0);
        }
        //String txt = "es.uefa.com/uefaeuropaleague/season=2012/matches/round=2000269/match=2007129/index.html";
        //System.out.println(new ColognePhonetic().encode(txt));
    }
}
