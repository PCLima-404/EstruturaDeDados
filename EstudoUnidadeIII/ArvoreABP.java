package EstudoUnidadeIII;
import NoTriplo;

public class ArvoreABP<T extends Comparable> {

    private NoTriplo<T> raiz= null;

    public ArvoreABP(NoTriplo<T> raiz) {
        raiz=null;
    }

    
    public NoTriplo<T> getRaiz() {
        return raiz;
    }


    public void inserir(T novoDado){
        NoTriplo<T> novoNo = new NoTriplo<>();
        novoNo.setDado(novoDado);
        NoTriplo<T> aux = raiz;
        if(raiz==null){
            this.raiz=novoNo;
        }else{
            while (true) {
                if(novoDado.compareTo(aux.getDado())<0 ){
                if(aux.getEsquerda()!=null){
                    aux= aux.getEsquerda();
                }else{
                    novoNo.setGenitor(aux);
                    aux.setEsquerda(novoNo);
                    break;
                }}
                else{
                    if(aux.getDireita()!=null){
                        aux= aux.getDireita();
                    }else{
                        novoNo.setGenitor(aux);
                        aux.setDireita(novoNo);
                        break;
                    }
                }
            }

        }


    }


    //esquerda, cima, direita em cada sub arvore(filho, pai filho)
 public String imprimirEmOrdem(NoTriplo<T> raizAtual){
    if(raizAtual==null){
        return " ";
    }
    return imprimirEmOrdem(raizAtual.getEsquerda()) + " " + raizAtual.getDado() + " " + imprimirEmOrdem(raizAtual.getDireita());

 }
 //cima, esquerda, direita em cada sub arvore(pai, filhos)
  public String imprimirPreOrdem(NoTriplo<T> raizAtual){
    if(raizAtual==null){
        return " ";
    }
    return  raizAtual.getDado()  +  " " + imprimirPreOrdem(raizAtual.getEsquerda()) +  " " + imprimirPreOrdem(raizAtual.getDireita());

 }
 //esquerda, direita, cima em cada subarvore(irmãos, pai)
 public String imprimirPosOrdem(NoTriplo<T> raizAtual){
    if(raizAtual==null){
        return " ";
    }
    return  imprimirPreOrdem(raizAtual.getEsquerda()) +  " " + imprimirPreOrdem(raizAtual.getDireita()) + " " + raizAtual.getDado();

 }

 public NoTriplo<T> busca(T dado){
    NoTriplo<T> aux = raiz;
    while(aux!=null){
    if(aux.getDado().equals(dado)){
        return aux;
    }
    if(dado.compareTo(aux.getDado()) < 0){
        aux = aux.getEsquerda();
    }else{
    aux=aux.getDireita();
    }
    

 }



    return null;

 }
 public boolean existe(T dado){
    return busca(dado) !=null;

 }
public void apagarNoFolha(NoTriplo<T> nodo){
    NoTriplo<T> pai = nodo.getGenitor();
    if(pai==null){
        raiz = null;
    }else{
        if(nodo.equals(pai.getEsquerda())){
        pai.setEsquerda(null);}
        else{
            pai.setDireita(null);
        }
    }

}
public void apagarNoumFilho(NoTriplo<T> nodo){
    NoTriplo<T> avo = nodo.getGenitor();
    NoTriplo<T> neto;
    if(nodo.getEsquerda()!=null){
 neto = nodo.getEsquerda();
    }else{
       neto= nodo.getDireita();
    }
    if(avo==null){
        raiz = neto;
        raiz.setGenitor(null);
    }else{
        neto.setGenitor(avo);

        if(nodo.equals(avo.getEsquerda())){
            avo.setEsquerda(neto);
        }else{
            avo.setDireita(neto);
        }
    }

   
}
public void apagarNodoisFilhos(NoTriplo<T> nodo) {
    // Passo 1: Encontrar o sucessor(aux) (menor da subárvore direita)
    NoTriplo<T> aux= nodo.getDireita();
    while (aux.getEsquerda() != null) {
        aux = aux.getEsquerda();
    }
    // Passo 2: Copiar o valor do sucessor para o nodo
    nodo.setDado(aux.getDado()); //agora esse nodo é o menor da subarvore direita e voce chama o metodo pra apagar o aux

    // Passo 3: Remover o sucessor (que terá no máximo um filho)
    if (aux.getEsquerda() == null && aux.getDireita() == null) {
        apagarNoFolha(aux);
    } else {
        apagarNoumFilho(aux);
    }
}

public T remover(T dado){
//busca elemento na arvore
NoTriplo<T> aux = busca(dado);
  if(aux!=null){
    //não tem filhos
 if(aux.getDireita()==null && aux.getEsquerda()==null){
    apagarNoFolha(aux);
//tem 1 filho
 } else if(aux.getDireita()==null||aux.getEsquerda()==null){
    apagarNoumFilho(aux);
//tem 2 filhos
 }else{
    apagarNodoisFilhos(aux);

 }

    return dado;
  }else{
    return null;
  }





}
   private NoTriplo<T> encontraMenorDireita(NoTriplo<T> nodo) {
        NoTriplo<T> noAuxiliar = nodo.getDireita();
        while (noAuxiliar.getEsquerda() != null)
            noAuxiliar = noAuxiliar.getEsquerda();

        return noAuxiliar;
    }  

    private NoTriplo<T> encontraMaiorEsquerda(NoTriplo<T> nodo) {
        NoTriplo<T> noAuxiliar = nodo.getEsquerda();
        while (noAuxiliar.getDireita() != null)
            noAuxiliar = noAuxiliar.getDireita();

        return noAuxiliar;
    } 



}
