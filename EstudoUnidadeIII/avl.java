public class avl<T extends Comparable<T>> implements Comparable {

      private NoTriplo<T> raiz= null;

    public avl(NoTriplo<T> raiz) {
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
                if(novoDado.compareTo(aux.getDado()) < 0){
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
        rebalancear(novoDado, aux);


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
NoTriplo<T> pai = aux.getGenitor();
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

 if(aux!=null){
    rebalancear(dado, pai);
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


   

    public int balanceamento(NoTriplo<T> nodo){
         int alturaEsquerda;
         int alturaDireita;
        if(nodo.getEsquerda()!=null){
             alturaEsquerda = nodo.getEsquerda().getAltura();
        }else{
            alturaEsquerda=-1;
        }
         if(nodo.getDireita()!=null){
             alturaDireita = nodo.getDireita().getAltura();
        }else{
            alturaDireita=-1;
        }
        return alturaEsquerda-alturaDireita;
    }

    public NoTriplo<T> rotacaoDireita(NoTriplo<T> nodo){ //quando esquerda >direita, positivo
        NoTriplo<T> pai= nodo.getGenitor();
        NoTriplo<T> filhoEsquerdo = nodo.getEsquerda();
        NoTriplo<T> subarvoreDireitadoFilhoEsquerda = filhoEsquerdo.getDireita();

        filhoEsquerdo.setDireita(nodo);
        if(pai!=null){
            if(nodo.equals(pai.getEsquerda())){
                pai.setEsquerda(filhoEsquerdo);
            }else{
                pai.setDireita(filhoEsquerdo);
            }
        }
        filhoEsquerdo.setGenitor(pai);

        filhoEsquerdo.setDireita(nodo);
        nodo.setGenitor(filhoEsquerdo);

        nodo.setEsquerda(subarvoreDireitadoFilhoEsquerda);
        if(subarvoreDireitadoFilhoEsquerda!=null){
            subarvoreDireitadoFilhoEsquerda.setGenitor(nodo);
        }

        atualizarAltura(nodo);
        atualizarAltura(filhoEsquerdo);


        return filhoEsquerdo;
       



    }

    public NoTriplo<T> rotacaoEsquerda(NoTriplo<T> nodo){ //quando direita>esquerda, negativo
        NoTriplo<T> pai = nodo.getGenitor();
        NoTriplo<T> filhoDireita = pai.getDireita();
        NoTriplo<T> subarvoreEsquerdaFilhoDireita = filhoDireita.getEsquerda();

        filhoDireita.setEsquerda(nodo);
         if(pai!=null){
           if(nodo.equals(pai.getEsquerda())){
            pai.setDireita(filhoDireita);
           } else{
            pai.setEsquerda(filhoDireita);
           }
        }
        filhoDireita.setGenitor(pai);
        nodo.setGenitor(filhoDireita);

        nodo.setDireita(subarvoreEsquerdaFilhoDireita);

        if(subarvoreEsquerdaFilhoDireita!=null){
            subarvoreEsquerdaFilhoDireita.setGenitor(nodo);
        }

        atualizarAltura(nodo);
        atualizarAltura(filhoDireita);

        return filhoDireita;

    }
    public void atualizarAltura(NoTriplo<T> nodo){
        int alturaEsquerda;
        int alturaDireita;
        if(nodo.getEsquerda()!=null){
            alturaEsquerda= nodo.getEsquerda().getAltura();
        }else{
            alturaEsquerda=-1;
        }
        if(nodo.getDireita()!=null){
            alturaDireita=nodo.getDireita().getAltura();
        }else{
            alturaDireita=-1;
        }
        nodo.setAltura(1 + Math.max(alturaEsquerda, alturaDireita));}
 //a altura do nodo é 1 + maior altura entre esquerda e direita
    
   private void rebalancear(T dado, NoTriplo<T> noAuxiliar) { //ESSE METODO É PRA QUANDO TA INSERINDO, POR ISSO COMPARA DADO COM O A ESQUERDA DO NO AUX
        while (noAuxiliar != null) {
            atualizarAltura(noAuxiliar);
            int desnivel = balanceamento(noAuxiliar);
            // Caso 1: Rotação à direita
            if (desnivel > 1 && dado.compareTo(noAuxiliar.getEsquerda().getDado()) < 0) {//o lado esquerdo esta mais alto então é direita e o valor está vindo da esquerda do filho da esquerda então é simples a direita
                noAuxiliar=rotacaoDireita(noAuxiliar);
               
            }
            // Caso 2: Rotação à esquerda
            else if (desnivel < -1 && dado.compareTo(noAuxiliar.getDireita().getDado()) > 0) { //o valor está mais alto a direita e o valor está vindo do filho a direita do filho a direita então é simples esquerda
                noAuxiliar=rotacaoEsquerda(noAuxiliar);
                
            }
            // Caso 3: Rotação dupla a direita
            else if (desnivel > 1 && dado.compareTo(noAuxiliar.getEsquerda().getDado()) > 0) { // desnível é positivo (esquerda mais alta), mas o valor veio da direita do filho da esquerda. Primeiro: faz uma rotação à esquerda no filho esquerdo, depois: rotação à direita no nó atual.
               noAuxiliar.setEsquerda(rotacaoEsquerda(noAuxiliar.getEsquerda()));
                noAuxiliar=rotacaoDireita(noAuxiliar);
                
            }
            // Caso 4: Rotação dupla a esquerda
            else if (desnivel < -1 && dado.compareTo(noAuxiliar.getDireita().getDado()) < 0) {//O desnível é negativo (direita mais alta), mas o valor veio da esquerda do filho da direita. Primeiro: faz uma rotação à direita no filho direito, depois: rotação à esquerda no nó atual
                noAuxiliar.setDireita(rotacaoDireita(noAuxiliar.getDireita()));
                noAuxiliar=rotacaoEsquerda(noAuxiliar);
              
                if(noAuxiliar.getGenitor()!=null){
                     if (noAuxiliar.equals(noAuxiliar.getGenitor().getEsquerda())) {
                 noAuxiliar.getGenitor().setEsquerda(noAuxiliar);
    }else{
        noAuxiliar.getGenitor().setDireita(noAuxiliar);
    }
                }else{
                    raiz= noAuxiliar;
                }
               noAuxiliar= noAuxiliar.getGenitor();



            }
            if (noAuxiliar.getGenitor() != null) {
                if (noAuxiliar.equals(noAuxiliar.getGenitor().getEsquerda())) {
                    noAuxiliar.getGenitor().setEsquerda(noAuxiliar);
                } else {
                    noAuxiliar.getGenitor().setDireita(noAuxiliar);
                }
            } else {
                raiz = noAuxiliar;
            }
            noAuxiliar = noAuxiliar.getGenitor();
        }
    }


   @Override
   public int compareTo(Object o) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
   }



 


}