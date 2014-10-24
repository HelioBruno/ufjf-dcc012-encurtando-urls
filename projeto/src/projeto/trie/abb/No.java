/*
 * Universidade Federal de Juiz de Fora
 * Instituto de Ciências Exatas
 * Departamento de Ciência da Computação
 * DCC012 - Estrutura de Dados
 * Prof.: Jairo Francisco de Souza
 * Aluno(a): Ana Carolina Fidelis Gonçalves - 200935002
 */
package projeto.trie.abb;

/**
 * Armazena as informações da estrutura da árvore binária de busca.
 *
 * @author Ana Carolina FIdelis Gonçalves <acarolinafg@gmail.com>
 */
public class No {

    /**
     * Sequência codificada
     */
    private final String chave;
    /**
     * URL
     */
    private final String url;

    public No(String chave, String url) {
        this.chave = chave;
        this.url = url;
    }

    public String getChave() {
        return chave;
    }

    public String getUrl() {
        return url;
    }

}
