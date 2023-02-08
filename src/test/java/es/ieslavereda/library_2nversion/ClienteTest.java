package es.ieslavereda.library_2nversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    Cliente cliente;
    Libro libro;

    @BeforeEach
    void beforeEach() {
        cliente = new Cliente("Joaquin Alonso", "1234");
        libro = new Libro("Bruguera", 140, true, "Uno cualquiera", "Un titulo", "123455123", 10);
    }

    @Test
    @DisplayName("Pruebas de prestamo de libros")
    void prestar() {

        assertFalse(cliente.prestar(libro.getEjemplares().get(77)));
        assertTrue(cliente.prestar(libro.getEjemplares().get(0)));
        assertEquals(1,cliente.getPrestados().size());
        assertTrue(cliente.prestar(libro.getEjemplares().get(1)));
        assertEquals(2,cliente.getPrestados().size());
        assertTrue(cliente.prestar(libro.getEjemplares().get(2)));
        assertEquals(3,cliente.getPrestados().size());
        assertFalse(cliente.prestar(libro.getEjemplares().get(3)));
    }

    @Test
    @DisplayName("Pruebas de devolucion de libros")
    void devolver() {
        cliente.prestar(libro.getEjemplares().get(0));
        cliente.prestar(libro.getEjemplares().get(1));
        cliente.prestar(libro.getEjemplares().get(2));

        assertFalse(cliente.devolver(libro.getEjemplares().get(3)));
        assertEquals(3,cliente.getPrestados().size());
        assertNull(cliente.getPrestados().get(2).getFechaDevolucion());
        assertTrue(cliente.devolver(libro.getEjemplares().get(2)));
        assertTrue(cliente.devolver(libro.getEjemplares().get(1)));
        assertTrue(cliente.devolver(libro.getEjemplares().get(0)));

    }

}