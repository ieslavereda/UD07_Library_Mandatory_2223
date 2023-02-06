package es.ieslavereda.library;

import java.time.LocalDate;

public class Periodico extends Publicacion{
    private String nombre;
    private LocalDate diaPublicacion;

    public Periodico(String editorial, int numPaginas, boolean enColor, String nombre, LocalDate diaPublicacion) {
        super(editorial, numPaginas, enColor);
        this.nombre = nombre;
        this.diaPublicacion = diaPublicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getDiaPublicacion() {
        return diaPublicacion;
    }

    @Override
    public String toString() {
        return super.toString() + "\n - Periódico: " + " nombre= " + nombre + ", diaPublicacion=" + diaPublicacion;
    }
}
