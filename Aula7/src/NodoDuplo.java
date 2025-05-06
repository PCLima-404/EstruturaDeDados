package Aula7.src;

public class NodoDuplo<T> {
	private NodoDuplo<T> anterior;
	private T dado;
	private NodoDuplo<T> proximo;
	
	
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