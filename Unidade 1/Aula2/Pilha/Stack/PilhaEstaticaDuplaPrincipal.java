package Pilha.Stack;

public class PilhaEstaticaDuplaPrincipal {
    public static void main(String[] args) {
        
        EmpilhavelDupla pilha = new PilhaEstaticaDupla(14);

        
        pilha.empilhar1("Instituto");
        pilha.empilhar1("Federal");
        System.out.println("Espiar Pilha1: " + pilha.topo1());  // Espiar 

        // Empilhando elementos na pilha 2
        pilha.empilhar2("Universidade");
        pilha.empilhar2("Estadual");

        // Empilhando mais elementos na pilha 1
        pilha.empilhar1("de");
        pilha.empilhar1("Educação");
        System.out.println("Espiar Pilha2: " + pilha.topo2());  // Espiar 
        pilha.empilhar2("do");

        
        pilha.empilhar1("Ciência");
        pilha.empilhar2("Rio");
        pilha.empilhar2("Grande");

        pilha.empilhar1("e");
        System.out.println("Espiar Pilha1: " + pilha.topo1());  // Espiar o topo da pilha 1

        // Desempilhando e empilhando novamente
        Object conteudo = pilha.desempilhar1();
        pilha.desempilhar1();
        pilha.empilhar2("do");
        pilha.empilhar1("Tecnologia");
        pilha.empilhar1("da");
        System.out.println("Espiar Pilha2: " + pilha.topo2());  // Espiar o topo da pilha 2

        
        conteudo = pilha.desempilhar2();
        
        pilha.empilhar1("Bahia");
        pilha.empilhar1(pilha.desempilhar1());
        pilha.desempilhar2();
        pilha.empilhar2("Sul");
        pilha.empilhar1(conteudo);
        pilha.empilhar2(pilha.desempilhar2());
        pilha.empilhar2(conteudo);

        
        System.out.println("Pilha1 = " + pilha.imprimir1());
        System.out.println("Pilha2 = " + pilha.imprimir2());
    }
}
