package es.ieslavereda.library;


import java.time.LocalDate;

public class Prestamo<T> {
    private T info;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(T info) {
        this.info = info;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
    }

    public T getInfo() {
        return info;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void devolver() {
        this.fechaDevolucion = LocalDate.now();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Prestamo){
            Prestamo p = (Prestamo) obj;
            return info.equals(p.info) && fechaPrestamo.equals(p.fechaPrestamo) && fechaDevolucion.equals(p.fechaDevolucion);
        }
        return false;
    }

    @Override
    public String toString() {
        return " Prestamo: info " + info + ", " +
                " fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion;
    }


}
