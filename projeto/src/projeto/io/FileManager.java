/*
 * Universidade Federal de Juiz de Fora
 * Instituto de Ciências Exatas
 * Departamento de Ciência da Computação
 * DCC012 - Estrutura de Dados
 * Prof.: Jairo Francisco de Souza
 * Aluno(a): Ana Carolina Fidelis Gonçalves - 200935002
 */
package projeto.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import projeto.hash.Hash;

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
     *
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

    /**
     * Realiza a leitura do arquivo de entrada e retorna uma lista contendo a
     * terceira coluna de cada linha do arquivo.
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public ArrayList<String> lerArquivo() throws FileNotFoundException, IOException {
        if (this.arquivo == null) {
            System.err.println("Arquivo não encontrado.");
            System.exit(0);
        } else {
            ArrayList lista = new ArrayList<>();
            String linha;
            //retirar a primeira linha
            try (BufferedReader br = new BufferedReader(new FileReader(this.arquivo))) {
                //retirar a primeira linha, pois não é uma linha válida
                br.readLine();
                while (br.ready()) {
                    linha = br.readLine();
                    lista.add(linha.split(" ")[2]);
                }
                br.close();
            }
            //retira a última posição do ArrayList, pois não é uma linha válida
            lista.remove(lista.size() - 1);
            return lista;
        }
        return null;
    }

    public void criarArquivoTbHash() throws IOException {
        HashMap<String, String> tabela = Hash.getTburls();
        if (tabela != null) {
            File file = new File(System.getProperty("user.dir") + "/tbHash.txt");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            try (
                    FileWriter fw = new FileWriter(file, true)) {
                BufferedWriter bw;
                bw = new BufferedWriter(fw);

                Set<String> chaves = tabela.keySet();
                Iterator<String> it = chaves.iterator();
                String chave;
                while (it.hasNext()) {
                    chave = it.next();
                    if (chave != null) {
                        bw.write(chave + " - " + tabela.get(chave));
                        bw.newLine();
                    }
                }
                bw.close();
            }
        } else {
            System.err.println("Arquivo não foi criado, pois a tabela de hash esta vazia.");
            System.exit(0);
        }
    }

}
