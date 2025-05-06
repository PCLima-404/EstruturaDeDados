package Aula7.src;


public interface Empilhavel <T> {
  /*  
    Usar em todos os codigos a partir de agora:
    (explicação)
    Esta interface indica as operações que uma classe que deseja ter o comportamento de ser empilhavel precisa

/**
 * @author autor, observando aula de claudio
 * @version 1.1
 * @since data
 */

 
   void empilhar(T dado);
	T desempilhar();
	T espiar();
	void atualizar(T dado);
	
	boolean estaCheia();
	boolean estaVazia();
	String imprimir();
}