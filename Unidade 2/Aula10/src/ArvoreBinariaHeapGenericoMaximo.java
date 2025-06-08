package Aula10.src;

import java.util.NoSuchElementException;

import Aula9.src.OverflowExeption;

public class ArvoreBinariaHeapGenericoMaximo<T> implements Amontoavel<T> {
    private T[] dados;
    private int ponteiroFim;

    
	 
    public ArvoreBinariaHeapGenericoMaximo(int tamanho) {
		dados = (T[]) new Object[tamanho];
        ponteiroFim = -1;
    }

	
    public ArvoreBinariaHeapGenericoMaximo() {
		this(10);
    }

    
   

    
    @Override
    public T obterRaiz() {
        if (estaVazia()) {
            throw new OverflowExeption("Heap está Vazia!");
		}  
        T dadoRaiz = dados[0];      
        return dadoRaiz;
    }

    @Override
    public void inserir(T dado) {
        if(estaCheia()){
           throw new OverflowExeption("Heap está cheia!");
        }else{
            
             ponteiroFim++;
            dados[ponteiroFim]=dado;
            ajustarAcima(ponteiroFim);
        }
    }

    @Override
    public T extrair() {
        if(estaVazia()){
            throw new OverflowExeption("heap vazia");
        }
        T dadoRaiz = dados[0];
        dados[0] = dados[ponteiroFim];
        ponteiroFim--;
        ajustarAbaixo(0);
        return dadoRaiz;
    }

     public boolean estaVazia() {
        return (ponteiroFim == -1);
    }

    
    public boolean estaCheia() {
        return (ponteiroFim == dados.length-1);
    }

	
	@Override	
    public String imprimir() {
		String resultado = "[";
        for (int i = 0; i <= ponteiroFim; i++) {
            resultado += dados[i];
			if (i == ponteiroFim) {
			    resultado += ",";
			}
        }
		return resultado += "]";
    }
      private int indiceFilhoEsquerdo(int pai) {
        return 2 * pai + 1;
    }

        
    private int indiceFilhoDireito(int pai) {
        return 2 * pai + 2;
    }
     private int indicePai(int filho) {
        return (int)((filho-1) / 2);
    }
    private void trocar(int i, int j){
        T temp = dados[i];
        dados[i] = dados[j];
        dados[j] = temp;
    }

    private void ajustarAcimaRec(int indice){
        if (indice!=0){
            int indicePai=indicePai(indice);
            if((Integer) dados[indice] > (Integer) dados[indicePai(indice)]) {
                trocar(indice, indicePai);
                
        }
        ajustarAcimaRec(indice);

    }
}
     private void ajustarAcima(int indice) {    
        int indiceFilho = indice;
        
        while (indice > 0) {
            int indicePai=indicePai(indiceFilho);
            if ((Integer) dados[indice] > (Integer) dados[indicePai(indice)]) {
                trocar(indiceFilho, indicePai);
                
            } 
            indiceFilho = indicePai;
        }
    }

    private void ajustarAbaixo(int pai) {    
        int filhoEsquerdo = indiceFilhoEsquerdo(pai);
        int filhoDireito = indiceFilhoDireito(pai);
        int maior = pai;    
        if (filhoEsquerdo <= ponteiroFim) { //está dentro dos valores válidos do array?
            if ((Integer) dados[filhoEsquerdo] > (Integer) dados[maior]) {
                maior = filhoEsquerdo;
            }
        }

        if (filhoDireito <= ponteiroFim) {  //está dentro dos valores válidos do array?
            if ((Integer) dados[filhoDireito] > (Integer) dados[maior]) {
                maior = filhoDireito;
            }
        }

        if (maior != pai) {
            trocar(pai, maior);
            ajustarAbaixo(maior);
        }
    }
    //PARA CASA FAZER O ABAIXO ACIMA RECURSIVO
    }
