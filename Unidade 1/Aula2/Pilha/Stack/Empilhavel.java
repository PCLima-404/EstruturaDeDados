package Pilha.Stack;


public interface Empilhavel {
    
    // Operações principais
    void empilhar(Object elemento); // Adiciona um elemento ao topo da pilha (push)
    Object desempilhar();           // Remove e retorna o elemento do topo da pilha (pop)
    Object espiar();                  // Mostra elemento do topo ams não remove (top)
    void atualizar(Object elemento); // Atualiza o topo da pilha com um novo valor (update)

    // Operações auxiliares
    boolean estaCheia(); // Similar isFull
    boolean estaVazia(); // Similar ao isEmpty
    String imprimir();   // Retorna um print

    
}
