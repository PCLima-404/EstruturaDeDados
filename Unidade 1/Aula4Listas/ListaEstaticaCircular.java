package Aula4Listas;

public class ListaEstaticaCircular implements Listavel {
	private Object[] dados;
	private int ponteiroInicio;
	private int ponteiroFim;
	private int quantidade;

	public ListaEstaticaCircular(int tamanho) {
		ponteiroInicio = 0;
		ponteiroFim = -1;
		quantidade = 0;
		dados = new Object[tamanho];
	}

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

	// mesmo de enfileirar na fila estatica circular
	public void anexar(Object dado) {
		if (!estaCheia()) {
			ponteiroFim = avancar(ponteiroFim);
			dados[ponteiroFim] = dado;
			quantidade++;
		} else {
			System.err.println("Queue is full");
		}
	}

	private int avancar(int ponteiro) {
		return (ponteiro + 1) % dados.length;
	}
	private int retroceder(int ponteiro) {
		return ((ponteiro -1)+dados.length) % dados.length;
	}

	// precisa fazer um mapeamento do lógico pra fisico, o usuariio entente que o
	// primeiro indice é o 1 e o array começa em 0
	int mapeamento(int logica) {
		return (logica + ponteiroInicio) % dados.length;
	}

	public void atualizar(Object dado, int posicao) {
		if (!estaVazia()) {
			if (posicao >= 0 && posicao < quantidade) { // verifica se a posição é valida
				int posicaoFisica = mapeamento(posicao);
				dados[posicaoFisica] = dado;
			} else {
				System.err.println("invalid index");
			}
		} else {
			System.err.println("List is empty");
		}
	}

	public Object selecionar(int posicao) { // ou index ao inves de posição
		Object aux=null;
		if (!estaVazia()) {
			if (posicao >= 0 && posicao < quantidade) { // verifica se a posição é valida, é verificada dessa forma pois
														// caso um usuario final
				// esteja querendo usar uma lista de cores, como ususario não sabe em qual
				// posição do array está fisicamente(posição fisica e logica começam em 0
				// mas se você começar a fazer operações de remoção o indice fisico muda em
				// relação ao logica, ex 1234 é o logico, se remove o 1 fica 234 com o 2 sendo o
				// primeiro indice logico(0) mas no fisico não muda a ordem então seria o
				// segundo indice(1))
				int posicaoFisica = mapeamento(posicao);
				aux = dados[posicaoFisica];
			}   
	}return aux;

}
	/*public Object[] selecionarTodos(){
		 Object[] aux = new Object[quantidade];
		if (!estaVazia()) {
			for(int i=0; i<=quantidade;i++){
				if(dados[(i+ponteiroInicio)%dados.length]!=null){
					aux[i] = dados[(i+ponteiroInicio)%dados.length];
				}
			}
		}else{
			System.err.println("List is Empty");
		}
				return aux;
	}*/
	public Object[] selecionarTodos(){
		 Object[] aux = new Object[quantidade];
		 int ponteiroAux = ponteiroInicio;
		if (!estaVazia()) {
			for(int i=0; i<=quantidade;i++){
				aux[i] =dados[ponteiroAux];
				ponteiroAux=avancar(ponteiroAux);
			}
		}else{
			System.err.println("List is Empty");
		}
				return aux;
	}
	//reinicia para como era no começo como se tivesse sido criada agora
	public void limpar(){
		quantidade=0;
		ponteiroInicio=0;
		ponteiroFim=-1;
	}

	public Object apagar(int posicao){
		Object dadoAux =null;
		if(!estaVazia()){
			if(posicao>=0&&posicao<quantidade){
				int posicaoFisica=mapeamento(posicao);
				dadoAux=dados[posicaoFisica];
				int x =posicaoFisica;
				int y =avancar(x);

				for(int i = 0;i<quantidade - posicao-1;i++){
					dados[x]=dados[y];
					x= avancar(x);
					y=avancar(y);
					
					
					
				}
				quantidade--;
				ponteiroFim = retroceder(ponteiroFim);
			}
		}
				return dadoAux;
	}

	@Override
	public void inserir(Object dado,int posicao) {
		if(!estaCheia()){
			if(posicao>=0 && posicao<=quantidade){
				int posicaoFisica=mapeamento(posicao);
				int x =ponteiroFim;
				int y =avancar(x);
				for(int i =0;i<quantidade-posicao;i++){
					dados[x]=dados[y];
					x= retroceder(x);
					y=retroceder(y);
					
				}
				dados[posicaoFisica]=dado;
				quantidade++;
				avancar(ponteiroFim);
			}
		}
		


	}

	@Override
	public boolean contem(Object dado) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'contem'");
	}

	@Override
	public int primeiraOcorrencia(Object dado) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'primeiraOcorrencia'");
	}







/* 
FAZER EM CASA E TENTAR DEIXAR O APAGAR E O INSERIR EFICIENTE
	public int primeiraOcorrencia(Object dado){
		if(!estaVazia()){
			for(int i=0;i<quantidade;i++){

			}
		}

	}
	public boolean contem(Object dado){

	}
	public boolean comparator(Object dado){

	}*/

}
