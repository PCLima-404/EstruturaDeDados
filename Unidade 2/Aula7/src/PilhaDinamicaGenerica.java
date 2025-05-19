package Aula7.src;

import java.util.NoSuchElementException;

/**
 * Esse código serve para implementar uma pilha dinamica
 * 
 * @author Lima P. C. P., observando aula de claudio
 * @version 1.0
 * @since 2025-05-05
 */

public class PilhaDinamicaGenerica<T> implements Empilhavel<T> {
	private int tamanho;
	private int quantidade;
	private NodoDuplo<T> ponteiroTopo;
	
	/**
 	* Construtor que recebe um tamanho máximo.
	*
 	* @param tamanho indica o tamanho máximo que a pilha pode ter
 	*/		
	public PilhaDinamicaGenerica(int tamanho) {
		this.tamanho = tamanho;
		quantidade = 0;
		ponteiroTopo = null;
	}

	/**
 	* Construtor vazio.
 	* 
 	*/	
	public PilhaDinamicaGenerica() {
		this(10);
	}

	/**
 	* Empilha um elemento na pilha.
 	* 
 	* @param dado é o dado a ser empilhado
 	* @throws NoSuchElementException se a pilha estiver cheia
 	*/
	@Override
	public void empilhar(T dado) {
		if (estaCheia()) {
			throw new NoSuchElementException("Pilha Cheia!");
		}
		NodoDuplo<T> noTemporario = new NodoDuplo<T>();
		noTemporario.setDado(dado);
		noTemporario.setAnterior(ponteiroTopo);
		if (!estaVazia()) {
			ponteiroTopo.setProximo(noTemporario);
		}
		ponteiroTopo = noTemporario;
		quantidade++;		
	}
	
	/**
 	* Desempilha o topo da pilha.
 	* 
	* @return retorna o elemento desempilhado
 	* @throws NoSuchElementException se a pilha estiver vazia
 	*/
	@Override
	public T desempilhar() {
		if (estaVazia()) {
			throw new NoSuchElementException("Pilha Vazia!");
		}
		T dadoTopo = ponteiroTopo.getDado();
		ponteiroTopo = ponteiroTopo.getAnterior();
		quantidade--;
		if (!estaVazia()) {
			ponteiroTopo.setProximo(null);
		}
		return dadoTopo;
	}

	/**
 	* Espia o topo da pilha.
 	* 
	* @return retorna o elemento do topo
 	* @throws NoSuchElementException se a pilha estiver vazia
 	*/
	@Override
	public T espiar() {
		if (estaVazia()) {
			throw new NoSuchElementException("Pilha Vazia!");
		}
		T dadoTopo = ponteiroTopo.getDado();
		return dadoTopo;
	}

	/**
 	* Atualiza o topo da pilha.
 	* 
	* @param novoDado é o elemento a substituir o elemento do topo
 	* @throws NoSuchElementException se a pilha estiver vazia
 	*/
	@Override
	public void atualizar(T novoDado) {
		if (estaVazia()) {
			throw new NoSuchElementException("Pilha Vazia!");
		}
		ponteiroTopo.setDado(novoDado);
	}

	/**
 	* Verifica se a pilha está vazia.
 	* 
	* @return true se a pilha estiver vazia, false caso contrário
 	*/	
	@Override
	public boolean estaVazia() {
		return (quantidade == 0);
	}
	
	/**
 	* Verifica se a pilha está cheia.
 	* 
	* @return true se a pilha estiver cheia, false caso contrário
 	*/	
	@Override
	public boolean estaCheia() {
		return (quantidade == tamanho);
	}

	/**
 	* Texto referente aos elementos da pilha para serem impressos.
 	* 
	* @return um texto com os elementos separados por ",", delimitados por colchetes
 	*/	
	@Override
	public String imprimir() {
		NodoDuplo<T> ponteiroAuxiliar = ponteiroTopo;
		String resultado = "[";
		for (int i = quantidade - 1; i >= 0; i--) {
			resultado += ponteiroAuxiliar.getDado();
			if (i != 0) {
				resultado += ",";
			}
			ponteiroAuxiliar = ponteiroAuxiliar.getAnterior();
		}
		return resultado + "]";
	}
}