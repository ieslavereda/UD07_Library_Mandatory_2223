package es.ieslavereda.library;

public abstract class Publicacion {

    private String editorial;
    private int numPaginas;
    private Impresion impresion;

    public Publicacion(String editorial, int numPaginas, Impresion impresion){
        this.editorial = editorial;
        this.numPaginas = numPaginas;
        this.impresion = impresion;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public Impresion getImpresion() {
        return impresion;
    }

    @Override
    public String toString() {
        return "Publicación: " +
                "editorial=" + editorial +
                ", numPaginas=" + numPaginas +
                ", impresion=" + impresion ;
    }

    public enum Impresion {
        COLOR,BN
    }
}
