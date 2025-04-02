package aula4Problema;

   //necessario refazer para entender o processo sem consultar o github

public class FilaEstaticaCircular implements Enfileiravel  {
private Object dados[];
    private int ponteiroInicio; 
    private int ponteiroFim;
    private int quantidade;


    public FilaEstaticaCircular() {
     this(10);
    }
    public FilaEstaticaCircular(int tamanho) {
     dados = new Object[tamanho];
     ponteiroInicio = 0;
     ponteiroFim = -1;
    }

    @Override
    public boolean estaCheia(){
        return quantidade ==dados.length;
    }
     @Override
    public boolean estaVazia(){
        return quantidade ==0;
    }
      @Override
   public String imprimir(){
    String retorno = "[";
    for(int i = ponteiroInicio;i<quantidade + ponteiroInicio; i++){
    
       // if(i==dados.length){
       //     i=0;
        //}
       
        if(i == quantidade + ponteiroInicio -1){ //quando ele for o ultimo valor da fila
        retorno +=dados[i% dados.length];}
        else{ retorno += dados[i% dados.length] + ",";
        
    }}
        return retorno + "]";
    }
   
    @Override
public void enfileirar(Object dado) {
    if (!estaCheia()) {
        ponteiroFim = (ponteiroFim + 1) % dados.length; // Corrigido
        dados[ponteiroFim] = dado;
        quantidade++;
    } else {
        System.err.println("Queue is full");
    }
}

        
      
    
    @Override
    public Object frente() {
        Object aux = null;
        if ((!estaVazia())) {
            aux= dados[ponteiroInicio];
        }else{System.err.print("queue is empty");
    }
        return aux;
    }
    @Override
    public void atualizarInicio(Object dado) { 
        if(!estaVazia()){
            dados[ponteiroInicio] = dado;
        }else{
            System.err.println("Queue is empty!");
        }
        
    }
    @Override
    public void atualizarFim(Object dado) {
         if(!estaVazia()){
            dados[ponteiroFim] = dado;
        }else{
            System.err.println("Queue is empty!");
        }
    }
    @Override
    public Object desenfileirar() { 
        Object aux = null;
        if ((!estaVazia())) {
            aux = dados[ponteiroInicio];
            ponteiroInicio= (ponteiroInicio+1)%dados.length;
           /* if(ponteiroInicio==dados.length){
                ponteiroInicio=0;
            }*/
            quantidade--;
        }else{System.err.print("queue is empty");
    }
        return aux;
       
    }


}

