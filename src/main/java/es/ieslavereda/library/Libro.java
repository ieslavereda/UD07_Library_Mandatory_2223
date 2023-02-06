package es.ieslavereda.library;

import es.ieslavereda.tad.ListLib;

public class Libro extends Publicacion {
    private String autor;
    private String titulo;
    private String ISBN;
    private int cantidadEjemplares;
    private ListLib<Ejemplar> ejemplares;

    public Libro(String editorial, int numPaginas, boolean enColor, String autor, String titulo, String ISBN, int cantidadEjemplares) {
        super(editorial, numPaginas, enColor);
        this.autor = autor;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.ejemplares = new ListLib<>();
        if (cantidadEjemplares>0) {
            for (int i = 0; i < cantidadEjemplares; i++) {
                ejemplares.add(new Ejemplar(this));
            }
        }
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

    @Override
    public String toString() {
        return super.toString() + "\n - Libro: " + ", ISBN=" + ISBN + ", ejemplares=" + ejemplares;
    }
}
