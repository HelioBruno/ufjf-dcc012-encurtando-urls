/*
 * Universidade Federal de Juiz de Fora
 * Instituto de Ciências Exatas
 * Departamento de Ciência da Computação
 * DCC012 - Estrutura de Dados
 * Prof.: Jairo Francisco de Souza
 * Aluno(a): Ana Carolina Fidelis Gonçalves - 200935002
 */
package projeto.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.UnixCrypt;
import projeto.util.Util;

/**
 * Classe responsável pelas funções de hash e contrução da tabela de hash.
 *
 * @author Ana Carolina FIdelis Gonçalves <acarolinafg@gmail.com>
 */
public class Hash {

    /**
     * Tabela de Hash (Chaves de 6 caracteres associadas a Urls)
     */
    private static HashMap<String, String> tburls;

    /**
     * Armazena o total de colisões geradas.
     */
    private static int colisoes;

    /**
     * Este método pega uma url e cria uma string da seguinte forma: Gera uma
     * chave randomica que é concatenada com a url codificada com o algoritimo
     * Base 64 após a url. A url é invertida e criptografada novamente com o
     * algoritimo de codificação UnixCrypt e concatenda a string que dara origem
     * Após esse processo é feito 6 interações que realiza uma escolha randômica
     * de 6 posições da string formada no passo anterior e a chave para url é
     * montada com os caracteres presentes nessas 6 posições. a chave.
     *
     * @param url Url que vai gerar a chave
     * @return Chave para gerada
     */
    public static String hash1(String url) {
        url = UUID.randomUUID().toString().concat(new Base64().encodeToString(url.getBytes())).concat(UnixCrypt.crypt(new StringBuffer(url).reverse().toString()));
        String chave = "";
        int i = 0;
        while (i < 6) {
            //sorteio de uma posição válida da string URL e adiciona a chave
            chave = chave.concat(String.valueOf(url.charAt(new Random().nextInt(url.length() - 1))));
            i++;
        }

        return Util.formatarChave(chave);
    }

    /**
     * Este método pega a chave gerada com o Hash1 e monta uma nova chave da
     * seguinte maneira: Gera uma chave randômica que é concatenada com chave
     * gerada pelo hash1() que é invertida, ou seja, traz pra frente e por
     * último é conctenado a essa string uma nova chave gerada aleatórimente.
     * Após a geração dessa string são feitas 6 interações escolhendo
     * aleatóriamente 6 posições da string que são conctenadas gerando umanova
     * chave.
     *
     * @param chave
     * @return Nova chave gerada
     */
    public static String hash2(String chave) {
        chave = UUID.randomUUID().toString().concat(new StringBuffer(chave).reverse().toString()).concat(UUID.randomUUID().toString());
        String chave2 = "";
        int i = 0;
        while (i < 6) {
            chave2 = chave2.concat(String.valueOf(chave.charAt(new Random().nextInt(chave.length() - 1))));
            i++;
        }
        return Util.formatarChave(chave2);
    }

    /**
     * Dado um conjunto de urls realiza a codificação de cada uma e insere em
     * uma tabela de hash associando o código gerado a Url dada.
     *
     * @param urls
     */
    public static void codificarUrls(Set<String> urls) {
        Iterator<String> links = urls.iterator();
        String url, chave;
        colisoes = 0;
        tburls = new HashMap<>();
        while (links.hasNext()) {
            url = links.next();
            chave = hash1(url);
            while (tburls.containsKey(chave) && !tburls.get(chave).equals(url)) {
                chave = hash2(chave);
                colisoes++;
            }
            tburls.put(chave, url);
        }
    }

    /**
     * Dado uma chave retorna a Url a qual a chave corresponde.
     *
     * @param chave
     */
    public static void getUrl(String chave) {
        if (tburls != null) {
            if (tburls.containsKey(chave)) {
                System.out.println(chave + " - " + tburls.get(chave));
            } else {
                System.out.println("Url não encontrada.");
            }
        } else {
            System.out.println("Tabela de hash se encontra vazia.");
        }
    }

    public static HashMap<String, String> getTburls() {
        return tburls;
    }

    public static int getColisoes() {
        return colisoes;
    }

}
