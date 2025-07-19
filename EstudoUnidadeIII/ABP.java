package EstudoUnidadeIII;

public class ABP<T> {
    NoTriplo<T> raiz;
    
      public ABP(){
        raiz=null;
    }
    NoTriplo<T> getRaiz(){
        return raiz;
    }
  public void inserir(T dado) {
        NoTriplo<T> novoNo = new NoTriplo<T>();
        novoNo.setDado(dado);

        if (raiz == null) {
        raiz = novoNo;
        return;
    }
        NoTriplo<T> aux = raiz;

        while(true){
            if((Integer)dado <= (Integer) aux.getDado()){
                if(aux.getEsquerda()!=null){

                    aux=aux.getEsquerda();
                }else{
                   
                    novoNo.setGenitor(aux);
                    aux.setEsquerda(novoNo);
                    break;
                }
            }else{
             
                if( aux.getDireita()!=null){
                  
                    aux=aux.getDireita();
                }else{
            
                    novoNo.setGenitor(aux);
                    aux.setDireita(novoNo);
                    break;
                }
            }
        }
        
    }
    
private void inserirRecursivo(NoTriplo<T> atual, NoTriplo<T> novoNo) {
    if ((Integer) novoNo.getDado() <= (Integer) atual.getDado()) {
        if (atual.getEsquerda() != null) {
            inserirRecursivo(atual.getEsquerda(), novoNo);
        } else {
            novoNo.setGenitor(atual);
            atual.setEsquerda(novoNo);
        }
    } else {
        if (atual.getDireita() != null) {
            inserirRecursivo(atual.getDireita(), novoNo);
        } else {
            novoNo.setGenitor(atual);
            atual.setDireita(novoNo);
        }
    }
}
  public void inserirRecChamada(T dado) {
    NoTriplo<T> novoNo = new NoTriplo<>();
    novoNo.setDado(dado);

    if (raiz == null) {
        raiz = novoNo;
    } else {
        inserirRecursivo(novoNo, novoNo);
    }
}
//imprime raiz, ai todos da esquerda, ai todos da direita da esquerda, ai da direita, vai verificando a esquerda da direita e todos da direita da direita
    public String ImprimirPreOrdemRec(NoTriplo<T> raizAtual){
        if(raizAtual==null){
            return " ";
        }
        return raizAtual.getDado() + " " + ImprimirPreOrdemRec(raizAtual.getEsquerda())+ " " +ImprimirPreOrdemRec(raizAtual.getDireita());

    }
    public String imprimirPreOrdem(){
        return ImprimirPreOrdemRec(raiz);
    }
    public String ImprimirEmOrdemRec(NoTriplo<T> raizAtual){
        if(raizAtual==null){
            return " ";
        }
        //Imprime na ordem crescente, ultimo da esquerda, ai o de cima, ai o da direita do de cima
        return ImprimirEmOrdemRec(raizAtual.getEsquerda()) + " " + raizAtual.getDado() + " " +ImprimirEmOrdemRec(raizAtual.getDireita());
    }
    public String imprimirEmOrdem(){
        return ImprimirEmOrdemRec(raiz);
    }
    //imprime o mais a esquerda, depois o irmão dele e ai o pai. Depois o mais a direita, irmão e pai
    public String ImprimirPosOrdemRec(NoTriplo<T> raizAtual){
        if(raizAtual==null){
            return " ";
        }else{
            return ImprimirPosOrdemRec(raizAtual.getEsquerda()) +" " + ImprimirPosOrdemRec(raizAtual.getDireita())+" " + raizAtual.getDado();
        }
        
    }
    public String imprimirPosOrdem(){
        return ImprimirPosOrdemRec(raiz);
    }


public void limpar(){
    raiz = null;
}



public NoTriplo<T> buscar(T dado){
    NoTriplo<T> aux = raiz;
    while (aux!=null) {
        if(dado.equals(aux.getDado())){
            return aux;
        }
        if((Integer)dado<(Integer)aux.getDado()){
            aux= aux.getEsquerda();
        }else{
            aux=aux.getDireita();
        }
        
    }
    return null;



}
//adicionar  apagar e existe


}
