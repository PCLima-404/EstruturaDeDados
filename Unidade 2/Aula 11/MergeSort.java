     package Ordenacao;
     
     public class MergeSort implements Ordenavel{
        private Object[] dados;

        @Override
        public void ordenar() {
          Object[] temp = new Object[dados.length];
            mergesort(temp, 0, dados.length-1);
        }

        public void mergesort(Object[] temp, int esquerda, int direita){
            if(esquerda<direita){
                int meio = (esquerda+direita)/2;
                mergesort(temp, esquerda, meio);
                mergesort(temp, meio+1, direita);
                intercalar(temp,esquerda,meio,direita);
            }
        }
        private void intercalar(Object[] temp, int esquerda, int meio, int direita){
            for(int i=esquerda;i<=direita;i++){
                temp[i]= dados[i];
            }
        int i = esquerda;
        int j = meio + 1;
        int k = esquerda;
            while(i<meio&&j<direita){
                if((Integer)temp[i]<=(Integer) temp[j]){
                    dados[k] = temp[i];
                    i++;
                }else{
                    dados[k]= temp[j];
                    j++;
                }
                k++;
            }
            while(i<=meio){
                dados[k] =temp[i];
                i++;
                k++;
            }

            while(j<=direita){
                dados[k] = temp[j];
                j++;
                k++;
            }



        }

       @Override
	public String imprimir() {
		String resultado = "[";
		for (int i = 0; i < dados.length; i++) {
			if (i == dados.length - 1) {
				resultado += dados[i];
			} else {
				resultado += dados[i] + ",";				
			}
		}
		return resultado + "]";
	}


     }