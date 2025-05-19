package Aula6;

public class Ordenacao {

    int dados[] = { 6, 8, 3, 1, 9, 0, 3, 5 };

    private void troca(int indice1, int indice2) {
        int temp = dados[indice1];
        dados[indice1] = dados[indice2];
        dados[indice2] = temp;
    }

    public void imprimirTela() {
        for (int dado : dados) {
            System.out.println(dado + " ");
        }
        System.out.println(" ");
    }

    public void BubleSort() {

        for (int j = 0; j < dados.length; j++) {
            for (int i = 0; i < dados.length - 1 - j; i++) { // -j para não fazer a rotação completa ja que ja sabe que
                                                             // o ultimo numero é o maior e o j cresce de 1 em 1 então
                                                             // toda rotação 1 a menos é chamado
                if (dados[i] > dados[i + 1]) {
                    troca(i, i + 1);
                }
            }

        }

    }

    public static void main(String[] args) {
        Ordenacao sort = new Ordenacao(); 
        System.out.println("antes");
        sort.imprimirTela();
        sort.insertionSort();
        System.out.println("depois");
        sort.imprimirTela();

    }

    public void selectionSort() {

        for (int j = 0; j < dados.length; j++) {
            int menor = j;
            for (int i = 1 + j; i < dados.length; i++) { // i começa em 1 porque o menor começa em 0 e precisa da
                                                         // comparação. como é i+j vai ser 1 depois 1+1 e segue
                if (dados[menor] > dados[i]) {
                    menor = i;
                }
                troca(j, menor);
            }
        }
    }

    public void insertionSort() { // considera um pivo- do pivo para esquerda está tudo ordenado ou seja, se achar
                                  // um elemento maior que ele voce para então se o segundo elemento é maior que o
                                  // primeiro voce deixa ele lá, se não voce faz comparações até ficar no lugar
                                  // certo
        
        for(int j=1;j<dados.length;j++){
        int pivo=j;
            for(int i=j-1;i>=0;i--){
              if(dados[i+1]<dados[i]){
                troca(i,i+1);
            }else
            break;
        }} 
    }

}
