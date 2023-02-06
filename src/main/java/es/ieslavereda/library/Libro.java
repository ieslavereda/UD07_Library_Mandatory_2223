package es.ieslavereda.library;

import es.ieslavereda.tad.ListLib;

/**
 *     Libros: Autor, Titulo, ISBN y cantidad de ejemplares
 */
public class Libro extends Publicacion {
    private String autor;
    private String titulo;
    private String ISBN;
    private int cantidadEjemplares;
    private ListLib<Ejemplar> ejemplares;

    public Libro(String editorial, int numPaginas, boolean enColor, String autor, String titulo, String ISBN) {
        super(editorial, numPaginas, enColor);
        this.autor = autor;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.ejemplares = new ListLib<>();
        this.cantidadEjemplares = ejemplares.size();
    }

    public String getAutor() {
        return autor;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getISBN() {
        return ISBN;
    }
    public int getCantidadEjemplares() {
        return ejemplares.size();
    }
    public ListLib<Ejemplar> getEjemplares() {
        return ejemplares;
    }


}
