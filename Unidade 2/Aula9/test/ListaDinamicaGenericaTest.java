package Aula9.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import Aula9.src.Listavel;
import Aula9.src.ListaDinamicaGenerica;
import Aula9.src.OverflowExeption;

public class ListaDinamicaGenericaTest {
    
@Test
public void testListaComDiferentesTipos(){
Listavel<String> lista = new ListaDinamicaGenerica<>(5);
lista.inserir(0,"A");
lista.inserir(0,"B");
lista.inserir(0,"C");
lista.inserir(0,"D");   
lista.inserir(0,"E");
try{
    lista.inserir(0,"F");
    fail("Não deveria estar aqui");
}catch(OverflowExeption e){
    assertEquals("Lista cheia", e.getMessage());
}

}

@Test
public void testInserirEstandoCheia(){
Listavel<String> lista = new ListaDinamicaGenerica<>(5);
lista.inserir(0,"A");
lista.inserir(0,"B");
lista.inserir(0,"C");
lista.inserir(0,"D");
lista.inserir(0,"E");
assertEquals("E", lista.selecionar(0));
}
}
