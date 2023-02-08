package es.ieslavereda.library_2nversion;
import es.ieslavereda.tad.Lista;

public class Libro extends Publicacion {
    private String autor;
    private String titulo;
    private String ISBN;
    private int cantidadEjemplares;
    private Lista<Ejemplar> ejemplares;

    public Libro(String editorial, int numPaginas, boolean enColor, String autor, String titulo, String ISBN) {
        super(editorial, numPaginas, enColor);
        this.autor = autor;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.ejemplares = new Lista<>();
        this.cantidadEjemplares = ejemplares.size();
    }
    public Libro(String editorial, int numPaginas, boolean enColor, String autor, String titulo, String ISBN, int cantidadEjemplares) {
        this(editorial, numPaginas, enColor, autor, titulo, ISBN);
        if (cantidadEjemplares>0)
            crearEjemplares(cantidadEjemplares);
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
    public Lista<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public int ejemplarDisponible(){
        for (int i = 0; i < ejemplares.size(); i++) {
            if(!(ejemplares.get(i).isPrestado()))
                return i;
        }
        return -1;
    }

    public int ejemplarPrestado(Cliente cliente){
        for (int i = 0; i < ejemplares.size(); i++) {
            if((ejemplares.get(i).isPrestado()))
                if(ejemplares.get(i).devolver(cliente))
                    return i;
        }
        return -1;
    }

    public void crearEjemplar(){
        ejemplares.add(new Ejemplar(this));
    }
    public void crearEjemplares(int cantidad){
        for (int i=0;i<cantidad;i++)
            crearEjemplar();
    }

    @Override
    public String toString() {
        return super.toString() + "\n - Libro: " + ", ISBN=" + ISBN + ", ejemplares=" + ejemplares;
    }
}
