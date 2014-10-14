/*
 * Universidade Federal de Juiz de Fora
 * Instituto de Ciências Exatas
 * Departamento de Ciência da Computação
 * DCC012 - Estrutura de Dados
 * Prof.: Jairo Francisco de Souza
 * Aluno(a): Ana Carolina Fidelis Gonçalves - 200935002
 */
package projeto.io;

import java.io.File;

/**
 * Classe responsável por todas as manipulações de arquivos no sistema.
 *
 * @author Ana Carolina FIdelis Gonçalves <acarolinafg@gmail.com>
 */
public class FileManager {

    /**
     * Nome do arquivo que está sendo manipulado
     */
    private String arquivo;

    public FileManager() {
        this.arquivo = null;
    }

    public FileManager(String arquivo) {
        this.setArquivo(arquivo);
    }

    public String getArquivo() {
        return arquivo;
    }

    /**
     * Armazena um novo arquivo, mas antes verfica se o arquivo existe.
     * @param arquivo Arquivo que será armazenado
     */
    public final void setArquivo(String arquivo) {
        if (new File(arquivo).exists()) {
            this.arquivo = arquivo;
        } else {
            System.err.println("Arquivo não encontrado.");
            System.exit(0);
        }
    }

}
