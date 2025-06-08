package Aula10.src;
//Heap = monte
//Heapify organizar dados em forma de uma heap
//Heapifiable- amontoavel
public interface Amontoavel<T> {
	void inserir(T dado);	// C
	T obterRaiz();			// R
	T extrair();			// D

	//auxiliares
	String imprimir();
	boolean estaVazia();
	boolean estaCheia();
}