package Aula9.src;


/**
 * Esse código serve para implementar uma lista dinamica, ele serve para mostrar o comportamento dos nos
 * 
 * @author Lima P. C. P., observando aula de claudio
 * @version 1.0
 * @since 2025-05-19
 */

  
public class NodoDuplo<T> {
	private NodoDuplo<T> anterior;
	private T dado;
	private NodoDuplo<T> proximo;

    public NodoDuplo() {
        
    }
	
	public NodoDuplo(T dado) {
        this.dado = dado;
    }

    public T getDado() {
		return dado;
	}

	public void setDado(T dado) {
		this.dado = dado;
	}

	public NodoDuplo<T> getAnterior() {
		return anterior;
	}

	public NodoDuplo<T> getProximo() {
		return proximo;
	}
	
	public void setAnterior(NodoDuplo<T> anterior) {
		this.anterior = anterior;
	}
	
	public void setProximo(NodoDuplo<T> proximo) {
		this.proximo = proximo;
	}
}
    



