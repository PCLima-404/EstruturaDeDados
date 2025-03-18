package EstruturaDeDados.Aula1;

public interface Empilhavel {
    
    // Operações principais
    void empilhar(Object elemento); // Adiciona um elemento ao topo da pilha (push)
    Object desempilhar();           // Remove e retorna o elemento do topo da pilha (pop)
    Object topo();                  // Mostra elemento do topo ams não remove (top)
    void atualizar(Object elemento); // Atualiza o topo da pilha com um novo valor (update)

    // Operações auxiliares
    boolean estaCheia(); // Similar isFull
    boolean estaVazia(); // Similar ao isEmpty
    String imprimir();   // Retorna um print
}

/* CONJUNTO ESTRUTURAS DE DADOS:
C - Create 
R - Read 
U - Update
D - Delete 
S - Sort (ordenar)

-----------------------------------------

TIPOS DE DADOS:
- Numéricos:
    - Inteiros:
        - unsigned int
        - tinyint, smallint
        - int
        - long, longint, bigint
    - Ponto flutuante:
        - float
        - double
    - Ponto fixo
- String
- Char
- Lógico:
    - boolean, bool
- Vetor, array, matriz unidimensional
- Ponteiro
- Objeto
*/
