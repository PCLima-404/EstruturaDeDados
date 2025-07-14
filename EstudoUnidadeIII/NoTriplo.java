package EstudoUnidadeIII;

public class NoTriplo<T> {
    private T dado;
    private NoTriplo<T> esquerda;
    private NoTriplo<T> genitor;
    private int altura;
    private NoTriplo<T> direita;

  

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public NoTriplo getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoTriplo esquerda) {
        this.esquerda = esquerda;
    }

    public NoTriplo getGenitor() {
        return genitor;
    }

    public void setGenitor(NoTriplo genitor) {
        this.genitor = genitor;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NoTriplo getDireita() {
        return direita;
    }

    public void setDireita(NoTriplo direita) {
        this.direita = direita;
    }





}
