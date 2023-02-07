package es.ieslavereda.library;


import java.time.LocalDate;

public class Prestamo<T> {
    private T type;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(T type, LocalDate fechaPrestamo) {
        this.type = type;
        this.fechaPrestamo = fechaPrestamo;
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
