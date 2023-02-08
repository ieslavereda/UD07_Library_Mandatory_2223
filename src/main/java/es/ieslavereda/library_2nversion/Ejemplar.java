package es.ieslavereda.library_2nversion;

import es.ieslavereda.tad.Lista;

import java.time.LocalDate;

public class Ejemplar {

    private Libro libro;
    private static int codigo;
    private String codigoEj;
    private boolean prestado;
    private Lista<Prestamo<Cliente>> historicoPrestados;

    public Ejemplar(Libro libro) {
        this.libro = libro;
        this.codigoEj = libro.getISBN()+"-"+codigo++;
        this.historicoPrestados = new Lista<>();
        this.prestado = false;
    }

    public String getcodigoEj() {return codigoEj;}
    public boolean isPrestado() {
        return prestado;
    }
    public Lista<Prestamo<Cliente>> getHistoricoPrestados() {
        return historicoPrestados;
    }

    public boolean prestar(Cliente cliente){
        if(prestado)
            return false;

        if(cliente.prestar(this)){
            historicoPrestados.add(new Prestamo<>(cliente));
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
