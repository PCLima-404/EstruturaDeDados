/*package Aula8.teste;

import Aula8.src.FilaDinamica;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Test {

    @Test
    public void testEnfileirarEDesenfileirar() {
        FilaDinamica<Integer> fila = new FilaDinamica<>(5);
        fila.enfileirarFim(10);
        fila.enfileirarFim(20);
        fila.enfileirarFim(30);

        assertEquals(10, fila.desenfileirarInicio());
        assertEquals(20, fila.frente());
        assertFalse(fila.estaVazia());
    }

    @Test
    public void testAtualizarInicioEFim() {
        FilaDinamica<String> fila = new FilaDinamica<>(3);
        fila.enfileirarFim("A");
        fila.enfileirarFim("B");

        fila.atualizarInicio("Z");
        fila.atualizarFim("Y");

        assertEquals("Z", fila.frente());
        assertEquals("[Z,Y]", fila.imprimirDeFrenteParaTras());
    }

    @Test
    public void testFilaCheia() {
        FilaDinamica<Integer> fila = new FilaDinamica<>(2);
        fila.enfileirarFim(1);
        fila.enfileirarFim(2);

        assertThrows(java.util.NoSuchElementException.class, () -> {
            fila.enfileirarFim(3);
        });
    }

    @Test
    public void testFilaVazia() {
        FilaDinamica<Integer> fila = new FilaDinamica<>(2);

        assertTrue(fila.estaVazia());
        assertThrows(java.util.NoSuchElementException.class, () -> {
            fila.frente();
        });
    }
    @Test
public void testFilaComTipoBoolean() {
    FilaDinamica<Double> fila = new FilaDinamica<>();
    fila.enfileirarFim(true);
    fila.enfileirarFim(false);

    assertEquals(Boolean.TRUE, fila.frente());
    assertEquals(Boolean.TRUE, fila.desenfileirarInicio());
    assertEquals(Boolean.FALSE, fila.frente());
}

@Test
public void testFilaComTipoString() {
    FilaDinamica<Double> fila = new FilaDinamica<>();
    fila.enfileirarFim("primeiro");
    fila.enfileirarFim("segundo");

    assertEquals("primeiro", fila.frente());
    assertEquals("primeiro", fila.desenfileirarInicio());
    assertEquals("segundo", fila.frente());
}

@Test
public void testFilaComTipoDouble() {
    FilaDinamica<Double> fila = new FilaDinamica<>();
    fila.enfileirarFim(3.14);
    fila.enfileirarFim(2.718);

    assertEquals(3.14, fila.frente());
    assertEquals(3.14, fila.desenfileirarInicio());
    assertEquals(2.718, fila.frente());
}

@Test
public void testFilaComTipoPersonalisado() {
    class Pessoa {
        String nome;
        Pessoa(String nome) { this.nome = nome; }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pessoa)) return false;
            return nome.equals(((Pessoa) o).nome);
        }
    }

    FilaDinamica<Pessoa> fila = new FilaDinamica<>();
    Pessoa p1 = new Pessoa("João");
    Pessoa p2 = new Pessoa("Maria");

    fila.enfileirarFim(p1);
    fila.enfileirarFim(p2);

    assertEquals(p1, fila.frente());
    assertEquals(p1, fila.desenfileirarInicio());
    assertEquals(p2, fila.frente());
}

}
 */