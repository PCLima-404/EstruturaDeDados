package aula4Problema;

public interface Enfileiravel {
void enfileirar(Object dado);//enfileirar, C enqueue
Object frente();  ////Frente, R front 
void atualizarInicio(Object dado); //Atualizar, U update
void atualizarFim(Object dado); //Atualizar, U update
Object desenfileirar();//Desenfileirar, D dequeue

boolean estaCheia();
boolean estaVazia();
String imprimir();

}