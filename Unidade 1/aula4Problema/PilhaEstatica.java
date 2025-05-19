

package aula4Problema;
public class PilhaEstatica implements Empilhavel {
    //variaveis de intancia
    private Object[] dados;//tem que ser tipo Object
    private int ponteiroTopo;//tem que ser tipo inteiro

     //construtores, para inicializar as variaveis de instancia
    public PilhaEstatica(){
         this(10); //usa isso quando chama um construtor dentro do outro, tipo o SUPER, 
        // como só tem um construtor que recebe int não tem duplicidade então ele manda pro inteiro
    }

    public PilhaEstatica(int tamanho) {
        dados = new Object[tamanho];
        ponteiroTopo = -1;
    }
    //não precisa colocar retorno pois ele retorna o mesmo nome do metodo então seria PilhasEstaticas Pilhas Estaticas
    
    //metodos auxiliares
    @Override
    public boolean estaCheia() {
        return(ponteiroTopo==dados.length-1);
    }


    @Override
    public boolean estaVazia(){
       return(ponteiroTopo==-1);


    }

    @Override
    public String imprimir(){//string pra poder fazer o que quiser com o que vier
        String aux= "[";
        for(int i = ponteiroTopo; i >=0;i++){
            if(i==0){
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
           ponteiroTopo++;
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
        ponteiroTopo--;
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
   



     
        
    
    //métodos principais
   

}

