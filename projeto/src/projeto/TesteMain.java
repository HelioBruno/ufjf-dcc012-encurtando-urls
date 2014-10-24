package projeto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import projeto.hash.Hash;
import projeto.io.FileManager;
import projeto.trie.Trie;
import projeto.trie.abb.TrieBB;
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

            //Criar a tabela de hash
            System.out.println("Criando Hash...");
            Hash.codificarUrls(urls);
            System.out.println("Colisões:" + Hash.getColisoes());

            //Arquivo com a tabela de hash
            System.out.println("Criando arquivo...");
            file.criarArquivoTbHash();
            
            //Criar árvore binária
            System.out.println("Criando árvore abb...");
            Trie abb = new TrieBB();
            HashMap<String, String> tabela = Hash.getTburls();
            Set<String> chaves = tabela.keySet();
            Iterator<String> it = chaves.iterator();
            String chave;
            while (it.hasNext()) {
                chave = it.next();
                if (chave != null) {
                    abb.inserir(chave + " " + tabela.get(chave));
                }
            }
            System.out.println("Fim abb...");
            //Busca
            Scanner scanner = new Scanner(System.in);
            int i = 0;
            while (i < 4) {
                System.out.println("Informe a chave:");
                chave = scanner.nextLine();
                System.out.println(abb.buscar(chave));
                i++;
            }

            // System.out.println("Urls válidas: " + urls.size());
        } catch (IOException e) {
            System.err.println("Erro na leitura do arquivo.");
            System.exit(0);
        }

    }
}
