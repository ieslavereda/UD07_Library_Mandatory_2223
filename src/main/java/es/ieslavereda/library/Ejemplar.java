package es.ieslavereda.library;
import es.ieslavereda.tad.Lista;

/**
 * Llevando un control de a quien se le ha prestado un ejemplar desde su compra.
 */

public class Ejemplar {

    private Libro libro;
    private int codigo;
    private Lista<Prestamo<Cliente>> historicoPrestados;

    public Ejemplar(Libro libro,int codigo) {
        this.libro = libro;
        this.codigo = codigo;
        this.historicoPrestados = new Lista<>();
    }

    public Libro getLibro() {
        return libro;
    }

    public int getCodigo() {
        return codigo;
    }

    public boolean isPrestado() {

        if(historicoPrestados.getHead()==null || historicoPrestados.getHead().getFechaDevolucion()!=null)
            return false;

        return true;

    }
    public Lista<Prestamo<Cliente>> getHistoricoPrestados() {
        return historicoPrestados;
    }

    public void añadirRegistroPrestamo(Cliente cliente){
        historicoPrestados.add(new Prestamo<>(cliente));
    }

    public void devolver(){
        historicoPrestados.getHead().devolver();
    }

    public boolean puedeDevolver(Cliente cliente){

        if(!isPrestado())
            return false;

        if(historicoPrestados.getHead().getInfo().equals(cliente))
            return true;

       return false;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Ejemplar) {
            Ejemplar e = (Ejemplar) obj;
            return e.libro.getISBN().compareTo(libro.getISBN())==0 && e.codigo == codigo;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ISBN: " + libro.getISBN() +", codigo " +  codigo+ ", Titulo: " + libro.getTitulo() + ", Prestado: " + isPrestado();
    }
}
