package Filaaula3;

public class FilaCircularPrincipal {
    public static void main(String[] args) {
        FilaestaticaCircular fila = new FilaestaticaCircular(5);

        
        fila.enfileirar("Pedro");
        fila.enfileirar("César");
        fila.enfileirar("E");
        fila.enfileirar("seus");
        fila.enfileirar("colegas");

        
        fila.enfileirar("F"); // Deve exibir erro: "Queue is full"

        
        System.out.println("Fila atual: " + fila.imprimir());

        //elemento da frente, no caso 
        System.out.println("Frente da fila: " + fila.frente());

        // Atualizando inicio e fim
        fila.atualizarInicio("X");
        fila.atualizarFim("Y");
        System.out.println("Fila após atualização: " + fila.imprimir());

        // Removendo 
        System.out.println("Elemento removido: " + fila.desenfileirar()); 
        System.out.println("Elemento removido: " + fila.desenfileirar()); 
        System.out.println("Fila após remoção: " + fila.imprimir()); 
        // testando se está funcionando a forma de circulo
        fila.enfileirar("F");
        fila.enfileirar("G");
        System.out.println("Fila após novas adições: " + fila.imprimir());
    }
}
