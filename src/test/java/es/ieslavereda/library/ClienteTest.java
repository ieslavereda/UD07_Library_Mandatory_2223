package es.ieslavereda.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    Cliente cliente;
    Libro libro;
    Ejemplar e1,e2,e3,e4;

    @BeforeEach
    void beforeEach() {
        cliente = new Cliente("Joaquin Alonso", "1234");
        libro = new Libro("Bruguera", 140, Publicacion.Impresion.COLOR, "Uno cualquiera", "Un titulo", "123455123");
        libro.crearEjemplares(10);
        e1 = libro.getEjemplar(1);
        e2 = libro.getEjemplar(2);
        e3 = libro.getEjemplar(3);
        e4 = libro.getEjemplar(4);
    }

    @Test
    @DisplayName("Pruebas de prestamo de libros")
    void prestar() {
        assertFalse(cliente.prestar(libro.getEjemplar(77)));
        assertTrue(cliente.prestar(e1));
        assertEquals(1,e1.getHistoricoPrestados().size());
        assertEquals(1,cliente.getPrestados().size());
        assertTrue(cliente.prestar(e2));
        assertEquals(2,cliente.getPrestados().size());
        assertTrue(cliente.prestar(e3));
        assertEquals(3,cliente.getPrestados().size());
        assertFalse(cliente.prestar(e4));
    }

    @Test
    @DisplayName("Pruebas de devolucion de libros")
    void devolver() {
        cliente.prestar(e1);
        cliente.prestar(e2);
        cliente.prestar(e3);

        assertFalse(cliente.devolver(e4));
        assertEquals(3,cliente.cantidadPrestados());
        assertTrue(cliente.devolver(e1));
        assertNotNull(cliente.getPrestados().get(2).getFechaDevolucion());
        assertNotNull(e1.getHistoricoPrestados().getHead().getFechaDevolucion());
        assertTrue(cliente.devolver(e3));
        assertNotNull(cliente.getPrestados().get(0).getFechaDevolucion());
        assertTrue(cliente.devolver(e2));
        assertNotNull(cliente.getPrestados().get(1).getFechaDevolucion());
    }

    @Test
    @DisplayName("Pruebas de cantidad de ejemplares prestados a un cliente")
    void cantidadPrestados() {
        assertEquals(0,cliente.cantidadPrestados());

        cliente.prestar(e1);
        assertEquals(1,cliente.cantidadPrestados());
        cliente.prestar(e2);
        assertEquals(2,cliente.cantidadPrestados());
        cliente.prestar(e3);
        assertEquals(3,cliente.cantidadPrestados());
        cliente.prestar(e4);
        assertEquals(3,cliente.cantidadPrestados());

    }
}