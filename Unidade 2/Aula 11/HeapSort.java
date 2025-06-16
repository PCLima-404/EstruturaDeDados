package Ordenacao;

public class HeapSort {
    public static void main(String[] args) {
        int[] vetor = new int[10];


        for(int i=0;i<vetor.length;i++){
            vetor[i]= (int) Math.floor(Math.random()*vetor.length);

        }
        System.out.println("vetor desordenado");
         for(int i=0;i<vetor.length;i++){
            System.out.print(vetor[i]+ " ");
         }


         int n = vetor.length;

         for(int i=n/2-1;i>=0;i--){
            aplicarHeap(vetor,n,i);
         }
//joga o primeiro maior pro fim, aplica o heap- o segundo maior fica no começo. faz isso com o segundo maior aplica o heap, terceiro maior no começo até que o primeiro maior fique no lugar certo
         for(int j=n-1;j>0;j--){
            int aux=vetor[0];
            vetor[0] = vetor[j];
            vetor[j] = aux;

            aplicarHeap(vetor, j, 0);
         }

    System.out.println("vetor ordenado");
         for(int i=0;i<vetor.length;i++){
            System.out.print(vetor[i]+ " ");
         }


    }
    private static void aplicarHeap(int[] vetor, int n, int i){
        int raiz =i;
        int esquerda=2*i+1;
        int direita=2*i +2;


        if(esquerda<n && vetor[esquerda]>vetor[raiz]){
            raiz=esquerda;
        }

        if(direita<n && vetor[direita]>vetor[raiz]){
            raiz=direita;
        }
        if(raiz!=i){
            int aux =vetor[i];
            vetor[i] = vetor[raiz];
            vetor[raiz]= aux;

            aplicarHeap(vetor, n, raiz);
        }
    }




}
