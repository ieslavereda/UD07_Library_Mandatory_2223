package es.ieslavereda.library;


import java.time.LocalDate;

public class Prestamo {
    private Cliente cliente;
    private Ejemplar ejemplar;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Cliente cliente, Ejemplar ejemplar, LocalDate fechaPrestamo) {
        this.cliente = cliente;
        this.ejemplar = ejemplar;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = null;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public Ejemplar getEjemplar() {
        return ejemplar;
    }
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fecha) {
        fechaDevolucion = fecha;
    }

    @Override
    public String toString() {
        return " Prestamo: " + "\n cliente=" + cliente +
                                "\n ejemplar=" + ejemplar +
                                "\n fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion;
    }

}
