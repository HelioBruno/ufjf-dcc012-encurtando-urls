/*
 * Universidade Federal de Juiz de Fora
 * Instituto de Ciências Exatas
 * Departamento de Ciência da Computação
 * DCC012 - Estrutura de Dados
 * Prof.: Jairo Francisco de Souza
 * Aluno(a): Ana Carolina Fidelis Gonçalves - 200935002
 */
package projeto.trie.abb;

import java.util.Arrays;
import projeto.trie.Trie;

/**
 * Classe de implementação da árvore binária de busca
 *
 * @author Ana Carolina FIdelis Gonçalves <acarolinafg@gmail.com>
 */
public class TrieBB implements Trie {

    /**
     * Nó que armazena as informações da árvore.
     */
    private No info;
    /**
     * Filho esquerdo.
     */
    private TrieBB esquerdo;

    /**
     * Filho direito.
     */
    private TrieBB direito;

    @Override
    public void inserir(String dados) {
        this.inserir(new No(dados.split(" ")[0], dados.split(" ")[1]));
    }

    /**
     * Insere um novo nó na árvore
     * @param info 
     */
    private void inserir(No info) {
        if (this.info == null) {
            this.info = info;
        } else if (info.getChave().compareTo(this.info.getChave()) < 0) {
            if (this.esquerdo == null) {
                this.esquerdo = new TrieBB();
            }
            this.esquerdo.inserir(info);
        } else {
            if (this.direito == null) {
                this.direito = new TrieBB();
            }
            this.direito.inserir(info);
        }
    }

    @Override
    public String buscar(String chave) {
        No no = this.search(chave);
        if (chave != null) {
            return no.getUrl();
        } else {
            return "Chave não encontrada.";
        }
    }

    /**
     * Busca uma chave na árvore
     * @param chave
     * @return Nó da chave pesquisada 
     */
    private No search(String chave) {
        if (this.info == null) {
            return null;
        } else if (chave.compareTo(this.info.getChave()) < 0) {
            return this.esquerdo.search(chave);
        } else {
            return this.direito.search(chave);
        }
    }

    @Override
    public void purge() {
        info = null;
        esquerdo = null;
        direito = null;
    }

}
