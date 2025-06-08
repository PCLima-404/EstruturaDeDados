package Aula9.src;

import java.util.NoSuchElementException;

/**
 * Esse código serve para implementar uma lista dinamica, ele serve para mostrar o comportamento dos nos01
 * 
 * @author Lima P. C. P., observando aula de claudio
 * @version 1.0
 * @since 2025-05-19
 */

public class ListaDinamicaGenerica<T> implements Listavel<T> {
    private NodoDuplo ponteiroInicio;
    private NodoDuplo ponteiroFim;
    private int quantidade;
    private int tamanho;

    public ListaDinamicaGenerica(int tamanho) {
        this.ponteiroInicio = null;
        this.ponteiroFim = null;
        this.quantidade = 0;
        this.tamanho = 0;                
    }
    public ListaDinamicaGenerica() {
        this(10);
    }

    @Override
    public void inserir(int posicao, Object dado) {
        if(estaVazia()){
            //lança exeção
        }if (!(posicao>=0&&posicao<=quantidade)){
            //lanço exeção
        }
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for(int i=0;i<posicao;i++){
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
        }
        NodoDuplo<T> noTemp = new NodoDuplo<>();
        noTemp.setProximo(ponteiroAuxiliar);
        NodoDuplo<T> anterior = ponteiroAuxiliar.getAnterior();
        noTemp.setAnterior(anterior);
        ponteiroAuxiliar.setAnterior(noTemp);
        anterior.setProximo(noTemp);
        quantidade++;
    }

        /**
 	*adiciona novo elemento a lista
 	* @param dado o dado a ser anexado
 	* @throws OverFlowExeption se a fila estiver cheia
    */
    @Override
    public void anexar(T dado) {
       if(estaCheia()){
        throw new OverflowExeption("msg");
       }
       NodoDuplo<T> novoNodo = new NodoDuplo<>(dado); 
        novoNodo.setAnterior(ponteiroFim);
        if(!estaVazia()){
            ponteiroFim.setProximo(novoNodo);
        }else{
            ponteiroInicio = novoNodo;
        }
       
        ponteiroFim=novoNodo;
        
            
       quantidade++;
    }
    

    @Override
    public T selecionar(int posicao) {
        if(estaVazia()){
            throw new NoSuchElementException();
        }if (!(posicao>=0&& posicao<quantidade)){
            throw new NoSuchElementException();
        }
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for(int i=0;i<posicao;i++){
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
           
        }
         return ponteiroAuxiliar.getDado();
    }

    @Override
    public T[] selecionarTodos() {
     if(estaVazia()){
        throw new UnderflowExeption("indice invalido");
     }
     Object[] dados = new Object[quantidade];
     NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
     for(int i=0;i<quantidade;i++){
        dados[i]=ponteiroAuxiliar.getDado();
        ponteiroAuxiliar=ponteiroAuxiliar.getProximo();
     }
     return (T[]) dados;
    }

    @Override
    public void atualizar(int posicao, T dado) {
        if(estaVazia()){
            throw new NoSuchElementException();
        }if (!(posicao>=0&& posicao<quantidade)){
            throw new NoSuchElementException();
        }
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for(int i=0;i<posicao;i++){
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
           
        }
         ponteiroAuxiliar.setDado(dado);
    }

    @Override
    public T apagar(int posicao) {
        if(estaVazia()){
            //lança exeção
        }if (!(posicao>=0&&posicao<quantidade)){
            //lanço exeção
        }
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for(int i=0;i<posicao;i++){
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
        }
        NodoDuplo<T> anterior = ponteiroAuxiliar.getAnterior();
        NodoDuplo<T> proximo = ponteiroAuxiliar.getProximo();
        anterior.setProximo(proximo);
        proximo.setAnterior(anterior);
        quantidade--;
        return ponteiroAuxiliar.getDado();
    }

    @Override
    public void limpar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limpar'");
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
  /**
 	* verifica se a estrutura esta cheia
 	* 
 	* 
 	* @return retorna se a fila está cheia ou não
 	*/
    @Override
    public boolean estaCheia() {
       return quantidade == tamanho;
    }
    /**
 	* verifica se a estrutura de dados esta vazia
 	* @return retorna se a fila esta vazia ou não
 	*/
    @Override
    public boolean estaVazia() {
        return quantidade==0;
    }
      /**
 	*verifica o dado da frente e retorna
 	* 
 	* @throws NoSuchElementException se a fila estiver vazia
 	*@return retorna os dados a serem impressos
    */
    @Override
    public String imprimir() {
    NodoDuplo<T> aux = ponteiroInicio;
        String retorno= "[";
        for(int i=0;i<quantidade;i++){
            retorno += aux.getDado();
            if(i!=quantidade-1){
                retorno += ",";
            }



            aux=aux.getProximo();
    }
        return retorno+"]";

    }

    
}
