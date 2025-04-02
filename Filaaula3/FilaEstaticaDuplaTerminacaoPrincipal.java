package Filaaula3;

public class FilaEstaticaDuplaTerminacaoPrincipal {
    public static void main(String[] args) {
		DuplamenteEnfileiravel fila = new FilaDequeue();
		fila.enfileirarInicio("Pedro");
		System.out.println(fila.imprimirFrenteTras()); 
		System.out.println(fila.tras()); 
		System.out.println(fila.frente()); 
		fila.enfileirarInicio("César");
		fila.desenfileirarFim();
		fila.enfileirarFim("IFBA");
		fila.atualizarInicio("alou");
		fila.desenfileirarInicio();
		fila.enfileirarInicio("Pedrada"); 
		System.out.println(fila.imprimirTrasFrente()); 
		fila.frente(); 
		fila.desenfileirarFim();
		System.out.println(fila.tras()); 
		fila.enfileirarInicio("Dev");
		System.out.println(fila.frente()); 
		fila.desenfileirarInicio();
		System.out.println(fila.imprimirFrenteTras()); 
	}
}
