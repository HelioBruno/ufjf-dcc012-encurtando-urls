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
     * Realiza o tratamento de cada url do arquivo e remve as Urls duplicadas.
     *
     * @param arquivo
     * @return Tabela com as urls válidas
     */
    public static HashMap<String, String> tratarUrl(ArrayList<String> arquivo) {
        HashMap<String, String> urls = new HashMap<>();
        String url;
        for (String arq : arquivo) {
            url = formatarUrl(arq);
           urls.put(url, "");
        }
        return urls;
    }
}
