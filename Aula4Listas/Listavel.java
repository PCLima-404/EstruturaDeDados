package Aula4Listas;

public interface Listavel {
void inserir(Object dado); //C   insert
void anexar (Object dado, int posicao); //C  append
Object selecionar(int posicao);//R  select
Object[] selecionarTodos(); //R selectAll
void atualizar (Object dado, int posicao); //U update
Object apagar(int posicao); //D delete
//S sort

void limpar(); //D
boolean contem(); //S

/*extra
int primeiraOcorrencia(Object dado);    
int ultimaOcorrencia(Object dado);
 */

boolean estaCheia();
boolean estaVazia();
String imprimir();
}
