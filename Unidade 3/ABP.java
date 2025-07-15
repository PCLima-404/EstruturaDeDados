public class ABP<T> implements Arborizavel<T> {
    NoTriplo<T> raiz;

    public ABP(){
        raiz=null;
    }
    NoTriplo<T> getRaiz(){
        return raiz;
    }
    @Override
    public void limpar() {
       raiz=null;
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
    @Override
    public void inserir(T dado) {
        NoTriplo<T> novoNo = new NoTriplo<>();
        novoNo.setDado(dado);
        NoTriplo<T> aux = raiz;

        while(true){
            if((Integer)dado <= (Integer) raiz.getDado()){
                //devo ir para esquerda
                if(aux.getEsquerda()!=null){
                      
                    //vou para esquerda
                    aux=aux.getEsquerda();
                }else{
                    //insiro aqui
                    novoNo.setGenitor(aux);
                    aux.setEsquerda(novoNo);
                    break;
                }
                aux = aux.getEsquerda();
            }else{
                //devo ir pra direita
                if( aux.getDireita()!=null){
                    //vou pra direita
                    aux=aux.getDireita();
                }else{
                    //insiro aqui
                    novoNo.setGenitor(aux);
                    aux.setDireita(novoNo);
                    break;
                }
            }
        }
        
    }
 public T apagar(T dado) {
        NoTriplo<T> noAuxiliar = buscar(dado);
        if (noAuxiliar == null)   
            return null;

        if (noAuxiliar.getEsquerda() == null &&
                noAuxiliar.getDireita() == null)
            apagarNoFolha(noAuxiliar);
        else if (noAuxiliar.getEsquerda() == null ||
                noAuxiliar.getDireita() == null)
            apagarComUmFilho(noAuxiliar);
        else
            apagarComDoisFilhos(noAuxiliar);

        return dado;
    }    

    private NoTriplo<T> buscar(T dado) {
        NoTriplo<T> aux = raiz;
        while (aux != null) {
            if (dado.equals(aux.getDado())) {
                return aux;
            } else if ((Integer)dado < (Integer)aux.getDado()) {
                aux = aux.getEsquerda();
            } else {
                aux = aux.getDireita();
            }
        }
        return null; 
    }

    private void apagarNoFolha(NoTriplo<T> nodo) {
        NoTriplo<T> pai = nodo.getGenitor();
        if (pai == null) {
            raiz = null;
        } else {
            if (nodo.equals(pai.getEsquerda()))
                pai.setEsquerda(null);
            else       
                pai.setDireita(null);

            nodo.setGenitor(null);
        }
    }

    private void apagarComUmFilho(NoTriplo<T> nodo) {
        NoTriplo<T> avo = nodo.getGenitor();
        NoTriplo<T> neto = (nodo.getEsquerda() != null ? nodo.getEsquerda() : nodo.getDireita());        
        if (avo == null) {
            raiz = neto;
            raiz.setGenitor(null);
        } else {
            neto.setGenitor(avo);
            if (nodo.equals(avo.getEsquerda())) {
                avo.setEsquerda(neto);
            } else {
                avo.setDireita(neto);
            }
        }
    }

    private void apagarComDoisFilhos(NoTriplo<T> nodo) {
        NoTriplo<T> sucessor = encontraMenorDireita(nodo);
        
        T temp = nodo.getDado();
        nodo.setDado(sucessor.getDado());
        sucessor.setDado(temp);

        if (sucessor.getEsquerda() == null && 
        sucessor.getDireita() == null) {
            apagarNoFolha(sucessor);
        } else {
            apagarComUmFilho(sucessor);
        }
    } 

    private NoTriplo<T> encontraMenorDireita(NoTriplo<T> nodo) {
        NoTriplo<T> sucessor = nodo.getDireita();
        while (sucessor.getEsquerda() != null)
            sucessor = sucessor.getEsquerda();

        return sucessor;
    }  
    private NoTriplo<T> encontraMaiorEsquerda(NoTriplo<T> nodo) {
        NoTriplo<T> sucessor = nodo.getEsquerda();
        while (sucessor.getDireita() != null)
            sucessor = sucessor.getDireita();

        return sucessor;
    } 

    public boolean existeRecChamada(T dado) {
    return existeRec(raiz, dado);
}

    //FAZER EM CASA
   private boolean existeRec(NoTriplo<T> no, T dado) {
    if (no == null) {
        return false;
    }

    if (no.getDado().equals(dado)) {
        return true;
    }

    if ((Integer) dado < (Integer) no.getDado()) {
        return existeRec(no.getEsquerda(), dado);
    } else {
        return existeRec(no.getDireita(), dado);
    }
}
   

    

    @Override
    public boolean existe(T dado) {
    NoTriplo<T> novoNo = new NoTriplo<>();
    
        NoTriplo<T> aux = raiz;
        boolean encontrado=false;

        while(true){
            if((Integer)dado <= (Integer) raiz.getDado()){
                //devo ir para esquerda
                if(aux.getEsquerda()!=null){
                      
                    //vou para esquerda
                    aux=aux.getEsquerda();
                }else{
                   return false;
                }
            }else{
                //devo ir pra direita
                if( aux.getDireita()!=null){
                    //vou pra direita
                    aux=aux.getDireita();
                }else{
                   return false;
                }
            }
        }
    }

    
    //questão 1 atividade gchat
     public int contarNos() {
        return contarNosRec(raiz);
    }

    
    private int contarNosRec(NoTriplo no) {
        if (no == null) 
            return 0;

        int esquerda = contarNosRec(no.getEsquerda());
        int direita = contarNosRec(no.getDireita());

        return 1 + esquerda + direita;
    }
    private int contarFolhas(NoTriplo<T> no) {
        if (no == null) return 0;
        if (no.getEsquerda() == null && no.getDireita() == null) return 1;
        
    return contarFolhas(no.getEsquerda()) + contarFolhas(no.getDireita());
}


}


  public int altura(NoTriplo<T> no) {
    if (no == null) return 0;
    return 1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita()));
}
