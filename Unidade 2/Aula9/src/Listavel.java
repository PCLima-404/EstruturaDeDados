package Aula9.src;
/**
 * Esse código serve para implementar uma lista dinamica, ele serve para mostrar o comportamento dos nos
 * 
 * @author Lima P. C. P., observando aula de claudio
 * @version 1.0
 * @since 2025-05-19
 */

public interface Listavel<T> {
void inserir(int posicao, T dado); //C   insert
void anexar(T dado); //C  append
T selecionar(int posicao);//R  select
T[] selecionarTodos(); //R selectAll
void atualizar (int posicao,T dado); //U update
T apagar(int posicao); //D delete
//S sort

void limpar(); //D
boolean contem(T dado); //S
int primeiraOcorrencia(T dado);  
/*extra
  
int ultimaOcorrencia(Object dado);
 */

boolean estaCheia();
boolean estaVazia();
String imprimir();
}

    

