package es.ieslavereda.library;

import es.ieslavereda.tad.ListLib;
import java.time.LocalDate;

public class Ejemplar {

    private Libro libro;
    private static int codigo;
    private String codigoEj;
    private boolean prestado;
    private ListLib<Prestamo> historicoPrestados;

    public Ejemplar(Libro libro) {
        this.libro = libro;
        this.codigoEj = libro.getISBN()+"-"+codigo++;
        this.historicoPrestados = new ListLib<>();
        this.prestado = false;
    }

    public String getcodigoEj() {return codigoEj;}
    public boolean isPrestado() {
        return prestado;
    }
    public ListLib<Prestamo> getHistoricoPrestados() {
        return historicoPrestados;
    }

    public boolean prestar(Cliente cliente){
        if(prestado)
            return false;

        if(cliente.prestar(this)){
            historicoPrestados.add(new Prestamo<Cliente>(cliente, LocalDate.now()));
            prestado = true;
            return prestado;
        }
        return false;
    }

    public boolean devolver(Cliente cliente){
        if(!prestado)
            return false;
        if(cliente.devolver(this)){
            Prestamo<Cliente> prestamo = historicoPrestados.remove(0);
            prestamo.setFechaDevolucion(LocalDate.now());
            historicoPrestados.add(prestamo);
            prestado = false;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return " codigo " +  codigoEj;
    }
}
