package Aula8.src;
/**
 * Esse código serve como interface para implementar a fila
 * 
 * @author Lima P. C. P., observando aula de claudio
 * @version 1.0
 * @since 2025-05-12
 */

public interface Enfileiravel<T> {

    void enfileirarInicio(T dado);
    void enfileirarFim(T dado);

    T frente();
    T tras();

    void atualizarInicio(T dado);
    void atualizarFim(T dado);

    T desenfileirarInicio();
    T desenfileirarFim();

    boolean estaCheia();
    boolean estaVazia();
    String imprimirDeTrasParaFrente();
    String imprimirDeFrenteParaTras();

    
}
