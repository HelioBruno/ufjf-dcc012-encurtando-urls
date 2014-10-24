/*
 * Universidade Federal de Juiz de Fora
 * Instituto de Ciências Exatas
 * Departamento de Ciência da Computação
 * DCC012 - Estrutura de Dados
 * Prof.: Jairo Francisco de Souza
 * Aluno(a): Ana Carolina Fidelis Gonçalves - 200935002
 */
package projeto.trie;

/**
 * Interface para implementação das árvores
 *
 * @author Ana Carolina Fidelis Gonçalves <acarolinafg@gmail.com>
 */
public interface Trie {

    /**
     * Método abstrato para inserção na árvore
     *
     * @param dado
     */
    public abstract void inserir(String dado);

    /**
     * Método abstrato pa realização da busca na árvore
     *
     * @param chave
     * @return Na TrieABB retorna a url da chave buscada, já na Trie Multiyay
     * retorna a própia chave
     */
    public abstract String buscar(String chave);
    
    /**
     * Método que tem como próposito esvaziar a árvore
     */
    public abstract void purge();
}
