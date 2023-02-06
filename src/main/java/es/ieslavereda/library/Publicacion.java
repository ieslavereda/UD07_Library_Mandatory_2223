package es.ieslavereda.library;

public abstract class Publicacion {

    private String editorial;
    private int numPaginas;
    private boolean enColor;

    public Publicacion(String editorial, int numPaginas, boolean enColor){
        this.editorial = editorial;
        this.numPaginas = numPaginas;
        this.enColor = enColor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public boolean isEnColor() {
        return enColor;
    }

    @Override
    public String toString() {
        return "Publicación: " +
                "editorial=" + editorial +
                ", numPaginas=" + numPaginas +
                ", enColor=" + ((enColor)?" en color " : " en blanco y negro ");
    }
}
