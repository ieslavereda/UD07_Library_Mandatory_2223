package es.ieslavereda.library;
import es.ieslavereda.tad.Lista;

public class Libro extends Publicacion {

    private String autor;
    private String titulo;
    private String ISBN;

    private Lista<Ejemplar> ejemplares;

    public Libro(String editorial, int numPaginas, Impresion impresion, String autor, String titulo, String ISBN) {
        super(editorial, numPaginas, impresion);
        this.autor = autor;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.ejemplares = new Lista<>();

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

    public Lista<Ejemplar> ejemplaresDisponibles(){

        Lista<Ejemplar> aux = new Lista<>();

        for (int i = 0; i < ejemplares.size(); i++) {
            if(!(ejemplares.get(i).isPrestado()))
                aux.add(ejemplares.get(i));
        }
        return aux;
    }

    public Lista<Ejemplar> ejemplaresPrestados(){

        Lista<Ejemplar> aux = new Lista<>();

        for (int i = 0; i < ejemplares.size(); i++) {
            if((ejemplares.get(i).isPrestado()))
                aux.add(ejemplares.get(i));
        }

        return aux;
    }

    public Ejemplar getEjemplar(int cod){

        Ejemplar ejemplar;
        int i=0;
        while ((ejemplar = ejemplares.get(i))!=null) {
            if(ejemplar.getCodigo()==cod)
                return ejemplar;
            i++;
        }

        return null;
    }
    public void crearEjemplar(){
        ejemplares.add(new Ejemplar(this,ejemplares.size()+1));
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
