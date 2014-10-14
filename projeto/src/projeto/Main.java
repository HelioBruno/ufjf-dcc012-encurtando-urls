/*
 * Universidade Federal de Juiz de Fora
 * Instituto de Ciências Exatas
 * Departamento de Ciência da Computação
 * DCC012 - Estrutura de Dados
 * Prof.: Jairo Francisco de Souza
 * Aluno(a): Ana Carolina Fidelis Gonçalves - 200935002
 */
package projeto;

import java.util.Scanner;
import projeto.io.FileManager;

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
        FileManager file = new FileManager(arquivo);
        System.out.println(file.getArquivo());

    }

}
