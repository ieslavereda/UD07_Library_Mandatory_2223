package es.ieslavereda.library;

/**
 * De todos ellos se pretende almacenar su editorial, número de páginas y si están en color o blanco y negro
 */

public abstract class Publicacion {

    private String editorial;
    private int numPaginas;
    private boolean enColor;

    public Publicacion(String editorial, int numPaginas, boolean enColor){
        this.editorial = editorial;
        this.numPaginas = numPaginas;
        this.enColor = enColor;
    }

}
