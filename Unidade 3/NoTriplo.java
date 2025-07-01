
public class NoTriplo <T>{
    NoTriplo<T> esquerda;
    NoTriplo<T> direita;
    NoTriplo<T> genitor;
    T dado;
    public NoTriplo<T> getEsquerda() {
        return esquerda;
    }
    public void setEsquerda(NoTriplo<T> esquerda) {
        this.esquerda = esquerda;
    }
    public NoTriplo<T> getDireita() {
        return direita;
    }
    public void setDireita(NoTriplo<T> direita) {
        this.direita = direita;
    }
    public NoTriplo<T> getGenitor() {
        return genitor;
    }
    public void setGenitor(NoTriplo<T> genitor) {
        this.genitor = genitor;
    }
    public T getDado() {
        return dado;
    }
    public void setDado(T dado) {
        this.dado = dado;
    }
 
    
}
