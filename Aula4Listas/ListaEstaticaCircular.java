package Aula4Listas;

public class ListaEstaticaCircular implements Listavel{
 private Object[] dados;
 private int ponteiroInicio;
 private int ponteiroFim;
 private int quantidade;
    
 public ListaEstaticaCircular(int tamanho) {
		ponteiroInicio = 0;
		ponteiroFim = -1;
		quantidade = 0;		
		dados = new Object[tamanho];}

    @Override
	public boolean estaCheia() {
		return (quantidade == dados.length);
	}
	
	
	@Override
	public boolean estaVazia() {
		return (quantidade == 0);
	}
	public String imprimir() {
		String resultado = "[";
		for (int i = 0, ponteiroAux = ponteiroInicio; i < quantidade; i++, ponteiroAux++) {
			if (i == quantidade - 1) {
				resultado += dados[ponteiroAux % dados.length];
			} else {
				resultado += dados[ponteiroAux % dados.length] + ",";		
			}
		}	
		return resultado + "]";
	}
//mesmo de enfileirar na fila estatica circular
	public void anexar(Object dado) {
    if (!estaCheia()) {
        ponteiroFim = avancar(ponteiroFim); 
        dados[ponteiroFim] = dado;
        quantidade++;
    } else {
        System.err.println("Queue is full");
    }
}
private int avancar(int ponteiro){
        return(ponteiro+1)%dados.length;
    }
//precisa fazer um mapeamento do lógico pra fisico, o usuariio entente que o primeiro indice é o 1 e o array começa em 0
 int mapeamento(int logica){
	return (logica + ponteiroInicio)%dados.length;
 }

public void atualizar(Object dado,int posicao){
		if(!estaVazia()){
			if(posicao >=0 && posicao<quantidade){
				int posicaoFisica = mapeamento(posicao);
				dados[posicaoFisica]=dado;
			}else{
				System.err.println("invalid index");
			}
		}else{
			System.err.println("List is empty");
		}
	}



}
