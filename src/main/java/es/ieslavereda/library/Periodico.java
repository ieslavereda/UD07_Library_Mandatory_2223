package es.ieslavereda.library;

import java.time.LocalDate;

/**
 *     Periodicos: Nombre y dia de publicacion
 */

public class Periodico extends Publicacion{
    private String nombre;
    private LocalDate diaPublicacion;

    public Periodico(String editorial, int numPaginas, boolean enColor, String nombre, LocalDate diaPublicacion) {
        super(editorial, numPaginas, enColor);
        this.nombre = nombre;
        this.diaPublicacion = diaPublicacion;
    }
}
