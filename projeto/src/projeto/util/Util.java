/*
 * Universidade Federal de Juiz de Fora
 * Instituto de Ciências Exatas
 * Departamento de Ciência da Computação
 * DCC012 - Estrutura de Dados
 * Prof.: Jairo Francisco de Souza
 * Aluno(a): Ana Carolina Fidelis Gonçalves - 200935002
 */
package projeto.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

/**
 * Classe utilitára que contém métodos para o tratamento do dados de entrada.
 *
 * @author Ana Carolina FIdelis Gonçalves <acarolinafg@gmail.com>
 */
public class Util {

    /**
     * Método que análisa a url e elimina os caracteres "<", ">" e os prótocolos
     * de internet http:// e https://
     *
     * @param url
     * @return Url formatada
     */
    public static String formatarUrl(String url) {
        url = url.replaceAll("<", "");
        url = url.replaceAll("http://", "");
        url = url.replaceAll("https://", "");
        url = url.replaceAll(">", "");
        return url;
    }

    /**
     * Realiza o tratamento de cada url do arquivo e remove as Urls duplicadas.
     *
     * @param arquivo
     * @return Tabela com as urls válidas
     */
    public static Set<String> tratarUrl(ArrayList<String> arquivo) {
        HashMap<String, String> tabela = new HashMap<>();
        String url;
        for (String arq : arquivo) {
            url = formatarUrl(arq);
            if (url.length() > 4) {
                tabela.put(url, url);
            }
        }
        Set urls = tabela.keySet();

        return urls;
    }

    /**
     * Retira todos os caracteres especiais de uma chave
     *
     * @param chave
     * @return
     */
    public static String formatarChave(String chave) {
        chave = chave.replaceAll("\\.", "B");
        chave = chave.replaceAll("/", "A");
        chave = chave.replaceAll("=", "T");
        chave = chave.replaceAll("-", "z");
        chave = chave.replaceAll("\\+", "4");
        return chave;
    }
}
