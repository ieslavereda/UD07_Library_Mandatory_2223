package es.ieslavereda.library_2nversion;


import es.ieslavereda.library_2nversion.Cliente;
import es.ieslavereda.library_2nversion.Ejemplar;

import java.time.LocalDate;

public class Prestamo<T> {
    private T type;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(T type) {
        this.type = type;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
    }

    public T getType() {
        return type;
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
        if (type instanceof Cliente)
            return " Prestamo: " + ((Cliente)type).getNombre() + " fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion;
        else
            return " Prestamo: " + ((Ejemplar)type).getcodigoEj() + " fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion;

    }

}
