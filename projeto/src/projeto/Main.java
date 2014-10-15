/*
 * Universidade Federal de Juiz de Fora
 * Instituto de Ciências Exatas
 * Departamento de Ciência da Computação
 * DCC012 - Estrutura de Dados
 * Prof.: Jairo Francisco de Souza
 * Aluno(a): Ana Carolina Fidelis Gonçalves - 200935002
 */
package projeto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import projeto.io.FileManager;
import projeto.util.Util;

/**
 * Chamada dos métodos principais para execução da aplicação.
 *
 * @author Ana Carolina FIdelis Gonçalves <acarolinafg@gmail.com>
 */
public class Main {

    /**
     * @param args Argumentos de entrada do programa
     */
    public static void main(String[] args) {
        //Leitura do nome do arquivo de entrada
        String arquivo;
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o caminho do arquivo:");
            arquivo = scanner.nextLine();
        } else {
            arquivo = args[0];
        }

        //Manipulação do arquivo
        FileManager file;
        try {
            file = new FileManager(arquivo);
            //Ler arquivo
            System.out.println("Lendo...");
            ArrayList<String> arq = file.lerArquivo();
            //System.out.println("Tamanho do arquivo: " + arq.size());

            //Tratar as urls
            System.out.println("Tratando...");
            HashMap<String, String> urls = Util.tratarUrl(arq);
            //System.out.println("Urls válidas: " + urls.size());

        } catch (IOException e) {
            System.err.println("Erro na leitura do arquivo.");
            System.exit(0);
        }

    }

}
