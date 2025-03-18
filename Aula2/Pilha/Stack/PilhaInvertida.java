

package Pilha.Stack;
public class PilhaInvertida implements Empilhavel {
    //variaveis de intancia
    private Object[] dados;//tem que ser tipo Object
    private int ponteiroTopo;//tem que ser tipo inteiro

     //construtores, para inicializar as variaveis de instancia
    public PilhaInvertida(){
         this(10); //
    }

    public PilhaInvertida(int tamanho) {
        ponteiroTopo = tamanho;
        dados = new Object[tamanho];
        
    }
    
    
    //metodos auxiliares
    @Override
    public boolean estaCheia() {
		return (ponteiroTopo == 0);
    }


    @Override
    public boolean estaVazia(){
       return(ponteiroTopo== dados.length);


    }

    @Override
    public String imprimir(){//string pra poder fazer o que quiser com o que vier
        String aux= "[";
        for(int i = ponteiroTopo; i <dados.length;i++){
            if(i == dados.length-1){
                aux+=dados[i];
            }
         else
            aux += dados[i] + ", "; //concatenação não da erro pois o objeto converte para toString antes de retornar
        }
        return aux + "]";
    }


//métodos principais


    @Override
     public void empilhar(Object dado){
        if(!estaCheia()){
           ponteiroTopo--;
           dados[ponteiroTopo] = dado;
        }else{
            System.err.println("Pilha cheia"); //exceção
        }
     }

     @Override
     public Object desempilhar(){ //retorna o dado que saiu
        Object aux = null;
        if(!estaVazia()){
        aux = dados[ponteiroTopo];   
        ponteiroTopo++;
        }else{
            System.out.println("Stack is empty"); //exceção
            aux= null;
        }
        return aux;
       

     }




     @Override        
     public Object espiar(){
        Object aux = null;
        if(!estaVazia()){
        aux = dados[ponteiroTopo];   
        }else{
            System.out.println("Stack is empty"); //exceção
            aux= null;
        }
        return aux;
       
        
            
     }
     @Override           
     public void atualizar(Object dado){
        if(!estaVazia()){
           dados[ponteiroTopo] = dado;
        }else{
            System.err.println("Stack is empty"); //exceção
        }
     }
   



     
        
    
 
   

}

