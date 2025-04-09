package Aula4Listas;

public interface Listavel {
void inserir(Object dado,int posicao); //C   insert
void anexar(Object dado); //C  append
Object selecionar(int posicao);//R  select
Object[] selecionarTodos(); //R selectAll
void atualizar (Object dado, int posicao); //U update
Object apagar(int posicao); //D delete
//S sort

void limpar(); //D
boolean contem(Object dado); //S
int primeiraOcorrencia(Object dado);  
/*extra
  
int ultimaOcorrencia(Object dado);
 */

boolean estaCheia();
boolean estaVazia();
String imprimir();
}
