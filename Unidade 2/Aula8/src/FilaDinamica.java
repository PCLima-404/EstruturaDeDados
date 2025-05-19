package Aula8.src;

import java.util.NoSuchElementException;

/**
 * Esse código serve para implementar uma fila dinamica generica
 * 
 * @author Lima P. C. P., observando aula de claudio
 * @version 1.0
 * @param <T>
 * @since 2025-05-12
 */


public class FilaDinamica<T> implements Enfileiravel<T> {
    private NodoDuplo <T> ponteiroInicio;
    private NodoDuplo<T> ponteiroFim;
    private int tamanho;
    private int quantidade;


    public FilaDinamica() {
        this(10);
    }
     public FilaDinamica(int tamanho) {
        ponteiroInicio=null;
        ponteiroFim=null;
        quantidade=0;
        this.tamanho=tamanho;
        
    }
   /**
 	* 
 	* 
 	* @throws UnsupportedOperationExeption gera exeção pois não é suportada
 	*
    */
    @Override
    public void enfileirarInicio(T dado) {
        throw new UnsupportedOperationException("Operação não suportada para essa fila'");
    }
    /**
 	* 
 	* 
 	* @throws UnsupportedOperationExeption gera exeção pois não é suportada
 	*
    */
  @Override
    public T tras() {
        throw new UnsupportedOperationException("Operação não suportada para essa fila'");
    }
    /**
 	* 
 	* 
 	* @throws UnsupportedOperationExeption gera exeção pois não é suportada
 	*
    */
 @Override
    public T desenfileirarFim() {
         throw new UnsupportedOperationException("Operação não suportada para essa fila'");
    }
    /**
 	* 
 	* 
 	* @throws UnsupportedOperationExeption gera exeção pois não é suportada
 	*
    */
     @Override
    public String imprimirDeTrasParaFrente() {
       throw new UnsupportedOperationException("Operação não suportada para essa fila'");
    }



   /**
 	*verifica o dado da frente e retorna
 	* @param
 	* @throws NoSuchElementException se a fila estiver vazia
    *@param dado - recebe o dado a ser enfileirado
    */
    

       /**
 	*adiciona novo elemento a fila
 	* @param dado o dado a ser enfileirado
 	* @throws NoSuchElementException se a fila estiver vazia
    */
    @Override
    public void enfileirarFim(T dado) {
       if(estaCheia()){
        throw new NoSuchElementException("fila vazia");
       }
       NodoDuplo<T> novoNodo = new NodoDuplo<>(dado); //o novo nodo não é desalocado pois é igualado a ponteiro fim
       novoNodo.setAnterior(ponteiroFim);
       if(!estaVazia()){ //faz em todas menos na primeira
            ponteiroFim.setProximo(novoNodo);}
            else{//só faz na primeira
                ponteiroInicio=novoNodo;
            }
       ponteiroFim = novoNodo;
       quantidade++;
    }
     /**
 	*verifica o dado da frente e retorna
 	* 
 	* @throws NoSuchElementException se a fila estiver vazia
 	*@return retorna o dado da frente
    */
    @Override
    public T frente() {
        if(estaVazia()){
            throw new NoSuchElementException("Não é possivel realizar com a fila vazia");
        }
         return ponteiroInicio.getDado();
      
    }
    /**
 	* atualiza um elemento na ser atualizado
 	* 
 	* @param dado é o dado a sert atualizado
 	* @throws NoSuchElementException lançada se a fila estuver vazia
 	*
    */
    @Override
    public void atualizarInicio(T dado) {
if(estaVazia()){
    throw new NoSuchElementException("Fila vazia");
}
     ponteiroInicio.setDado(dado);
    }
        /**
 	*verifica o dado da frente e retorna
 	* @param
 	* @throws NoSuchElementException lançada se a fila estiver vazia
 	*@param dado recebe o dado a ser atualizado

    */
    @Override
    public void atualizarFim(T dado) {
        if(estaVazia()){
    throw new NoSuchElementException("Fila vazia");
}
     ponteiroFim.setDado(dado);
    }
       
   /**
 	*desenfileira um dado do inicio e retorna ele
 	* 
 	* @throws NoSuchElementException se a fila estiver vazia
 	*@return retorna o dado desenfileirado
    */
    @Override
    public T desenfileirarInicio() {
        
        if(estaVazia()){
            throw new NoSuchElementException("Fila vazia");
        }
        T dadoInicio = ponteiroInicio.getDado();
        ponteiroInicio=ponteiroInicio.getProximo();
        ponteiroInicio.setAnterior(null);
        quantidade--;
        return dadoInicio;
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
    public String imprimirDeFrenteParaTras() {
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










