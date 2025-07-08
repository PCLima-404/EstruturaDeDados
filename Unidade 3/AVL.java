public class AVL<T> implements Arborizavel<T> {

    private NoTriplo<T> raiz;

    public AVL() {
        raiz = null;
    }

    public NoTriplo<T> getRaiz() {
        return raiz;
    }

    @Override
    public void limpar() {
        raiz = null;
    }
    
  
    private int balanceamento(NoTriplo<T> nodo) {

        int alturaEsquerda = nodo.getEsquerda() != null ? nodo.getEsquerda().getAltura(): -1;
        int alturaDireita = nodo.getDireita() != null ? nodo.getDireita().getAltura(): -1;

        return alturaEsquerda - alturaDireita;
    }

    private void atualizaAltura(NoTriplo<T> nodo) {
           
        int alturaEsquerda = nodo.getEsquerda() != null ? nodo.getEsquerda().getAltura(): -1;
        int alturaDireita = nodo.getDireita() != null ? nodo.getDireita().getAltura(): -1;
        nodo.setAltura(1 + 
                Math.max(alturaEsquerda, alturaDireita));
    }
    private NoTriplo<T> rotacaoDireita(NoTriplo<T> y) {
        NoTriplo<T> T0 = y.getGenitor();
        NoTriplo<T> x  = y.getEsquerda();
        NoTriplo<T> T2 = x.getDireita();

        if (T0 != null)
            if (y.equals(T0.getEsquerda()))
                T0.setEsquerda(x);
            else
                T0.setDireita(x);

        x.setGenitor(T0);

  
        x.setDireita(y);
        y.setGenitor(x);   

    
        y.setEsquerda(T2);        
        if (T2 != null)
            T2.setGenitor(y);

        atualizaAltura(y);
        atualizaAltura(x);
       
        return x;
    }

  
    private NoTriplo<T> rotacaoEsquerda(NoTriplo<T> y) {

        NoTriplo<T> T0 = y.getGenitor();        
        NoTriplo<T> x  = y.getDireita();
        NoTriplo<T> T2 = x.getEsquerda();

        if (T0 != null)        
            if (y.equals(T0.getEsquerda()))
                T0.setEsquerda(x);
            else
                T0.setDireita(x);
                
        x.setGenitor(T0);
        

        x.setEsquerda(y);
        y.setGenitor(x); 

        y.setDireita(T2);        
        if (T2 != null)
            T2.setGenitor(y);

        atualizaAltura(y);
        atualizaAltura(x);

        return x;
    }

  
    private void rebalancear(T dado, NoTriplo<T> noAuxiliar) {
     
        while (noAuxiliar != null) {

            atualizaAltura(noAuxiliar);
            int desnivel = balanceamento(noAuxiliar);
             
            if (desnivel > 1 && (Integer) dado < (Integer) noAuxiliar.getEsquerda().getDado()) {
                noAuxiliar = rotacaoDireita(noAuxiliar);
            }

            else if (desnivel < -1 && (Integer) dado > (Integer) noAuxiliar.getDireita().getDado()) {
                noAuxiliar = rotacaoEsquerda(noAuxiliar);
            }
            else if (desnivel > 1 && (Integer) dado > (Integer) noAuxiliar.getEsquerda().getDado()) {
                noAuxiliar.setEsquerda(rotacaoEsquerda(noAuxiliar.getEsquerda()));
                noAuxiliar = rotacaoDireita(noAuxiliar);
            }
            else if (desnivel < -1 && (Integer) dado < (Integer) noAuxiliar.getDireita().getDado()) {
                noAuxiliar.setDireita(rotacaoDireita(noAuxiliar.getDireita()));
                noAuxiliar = rotacaoEsquerda(noAuxiliar);
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
    public void inserir(T dado) {
        NoTriplo<T> novoNo = new NoTriplo<>();
        novoNo.setDado(dado);
        if (raiz == null) {
            raiz = novoNo;
        } else {
            NoTriplo<T> noAuxiliar = raiz;
            while (noAuxiliar != null) {
                if ((Integer) dado < (Integer) noAuxiliar.getDado()) {
                  
                    if (noAuxiliar.getEsquerda() != null) {
                        noAuxiliar = noAuxiliar.getEsquerda();
                    } else {
                      
                        noAuxiliar.setEsquerda(novoNo);
                        novoNo.setGenitor(noAuxiliar);
                        break;
                    }
                } else {
                 
                    if (noAuxiliar.getDireita() != null) {
                        noAuxiliar = noAuxiliar.getDireita();
                    } else {
                       
                        noAuxiliar.setDireita(novoNo);
                        novoNo.setGenitor(noAuxiliar);
                        break;
                    }
                }
            }
           
            rebalancear(dado, novoNo);
        }
    }

    
    @Override
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

        rebalancear(dado, noAuxiliar);        
        
        return dado;
    }    

    private NoTriplo<T> buscar(T dado) {
        NoTriplo<T> noAuxiliar = raiz;
        while (noAuxiliar != null) {
            if (dado.equals(noAuxiliar.getDado())) {
                return noAuxiliar;
            } else {
                if ((Integer) dado < (Integer) noAuxiliar.getDado())
                    noAuxiliar = noAuxiliar.getEsquerda();
                else
                    noAuxiliar = noAuxiliar.getDireita();
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

    //existe
    @Override
    public boolean existe(T dado) {
        boolean retorno = false;
        NoTriplo<T> noAuxiliar = raiz;
        while (noAuxiliar != null) {
            if (dado.equals(noAuxiliar.getDado())) {
                retorno = true;
                break;
            } else {
                if ((Integer) dado < (Integer) noAuxiliar.getDado())
                    noAuxiliar = noAuxiliar.getEsquerda();
                else
                    noAuxiliar = noAuxiliar.getDireita();
            }
        }
        return retorno;
    }
    


    private String imprimirPreOrdemRec(NoTriplo<T> raiz) {
        String resultado = "";
        if (raiz != null) {
            resultado = raiz.getDado() + " " + 
                imprimirPreOrdemRec(raiz.getEsquerda()) +  " " +
                imprimirPreOrdemRec(raiz.getDireita());
        }
        return resultado;
    }

    private String imprimirEmOrdemRec(NoTriplo<T> raiz) {
        String resultado = "";        
        if (raiz != null) {
            resultado = imprimirEmOrdemRec(raiz.getEsquerda()) + " " + 
            raiz.getDado() + " " +
            imprimirEmOrdemRec(raiz.getDireita());
        }
        return resultado;       
    }

    private String imprimirPosOrdemRec(NoTriplo<T> raiz) {
        String resultado = "";        
        if (raiz != null) {
            resultado = imprimirPosOrdemRec(raiz.getEsquerda()) + " " +
                imprimirPosOrdemRec(raiz.getDireita()) +  " " +
                raiz.getDado();
        }
        return resultado;            
    }

    private String formataSaida(String msg) {
        String resultado;
        do {
            resultado = msg;
            msg = msg.replace("  ", " "); //remove excesso de espaços
        } while (!msg.equals(resultado));
        msg = msg.trim(); //remove espaços em branco do inicio e fim, se existir
        msg = msg.replace(" ", ","); //troca espaço por vírgula
        return "[" + msg + "]";
    }    
}
