package main;

import java.util.Vector;

abstract class Tokenizador <T> {
	/** lista gen�rica */
    protected Vector<T> lista = new Vector<T>();

	/** 
	 * Converte conte�do de linha para classe gen�rica
	 *
	 * @param tokensLinha linha contendo os tokens a serem convertidos em classe
	 * @return retorna objeto convertido
	 */
    public abstract T fromLinhaTokens(String[] tokensLinha);

    /**
	 * Retorna a lista gen�rica.
	 *
	 * @return lista gen�rica
	 */
	public Vector<T> getLista() {
		return lista;
	}

	/**
	 * Transforma tokens de linha CSV obtidos por {@link main.Csv#tokenizaCsv(String)}.
	 *
	 * @param tokens os tokens a serem serializados
	 */
	public void tokensToLista(String[][] tokens) {
   		for(int i = 2; i < tokens.length; i++) {
   			T materia = this.fromLinhaTokens(tokens[i]);
    		this.inserir(materia);
    	}
	}

	/**
	 * Retorna o tamanho da lista.
	 *
	 * @return tamanho da lista
	 */
    public int tamanhoLista() {
		return this.lista.size();
	}

	/**
	 * Obt�m objeto da lista em �ndice espec�fico.
	 *
	 * @param i �ndice ocupado pelo objeto
	 * @return retorna classe gen�rica
	 */
    public T listaGetAt(int i) {
		return this.lista.get(i);
	}
    
	/** Imprime conte�do da lista. */
    public void imprimeLista() {
		for(int i = 0; i < this.tamanhoLista(); i++) {									
			System.out.println("Elemento "+ i + " : {" + this.listaGetAt(i).toString()+ "}");	//get at retorno o elemento na posicao i , imprimivel torna o objeto Materia imprimivel com o println 
		}
	} 

	/**
	 * Insere novo elemento na lista
	 *
	 * @param mat elemento a ser inserido
	 */
	public void inserir(T mat) {
		this.lista.add(mat);
	}
	
	/**
	 * Insere novo elemento na lista em um �ndice espec�fico.
	 *
	 * @param mat elemento a ser inserido
	 * @param pos posi��o a ser inserido
	 */
	public void inserirEm(T mat, int pos) {
		this.lista.add(pos, mat);
	}
	
	/**
	 * Remove um elemento da lista.
	 *
	 * @param mat elemento a ser removido
	 */
	public void remover(T mat) {
		this.lista.remove(mat);
	}
	
	/**
	 * Remove um elemento da lista em um �ndice espec�fico.
	 *
	 * @param pos posi��o do elemento a ser removido
	 */
	public void removerEm(int pos) {
		this.lista.remove(pos);
	}
}
