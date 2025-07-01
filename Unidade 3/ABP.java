public class ABP<T> implements Arborizavel<T> {
    NoTriplo<T> raiz;

    public ABP(){
        raiz=null;
    }
    NoTriplo<T> getRaiz(){
        return raiz;
    }
    
    public void inserirREC(T dado) {
        //FAZER EM CASA
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



    //FAZER EM CASA
    public boolean existeRec(NoTriplo<T> subarvore,T dado){

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

    @Override
    public void limpar() {
       raiz=null;
    }

}
