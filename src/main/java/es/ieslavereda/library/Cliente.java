package es.ieslavereda.library;

import es.ieslavereda.tad.ListLib;

import java.time.LocalDate;
import java.util.Objects;


public class Cliente {
    private String nombre;
    private String dni;

    private ListLib<Prestamo> prestados;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.prestados = new ListLib<>();
    }

    public String getNombre() {
        return nombre;
    }
    public String getDni() {
        return dni;
    }
    public ListLib<Prestamo> getPrestados() {
        return prestados;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }


    public boolean prestar(Ejemplar ejemplar){
        if(ejemplar==null || prestados.size() >= 3)
            return false;
        prestados.add(new Prestamo(this, ejemplar, LocalDate.now()));
        return true;
    }

    public boolean devolver(Ejemplar ejemplar){
        if(ejemplar==null || getPrestados().isEmpty())
            return false;

        for (int i = 0; i < getPrestados().size(); i++) {
            if(prestados.get(i).getEjemplar().equals(ejemplar)){
                prestados.get(i).setFechaDevolucion(LocalDate.now());
                prestados.remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(dni, cliente.dni);
    }

    @Override
    public String toString() {
        return "Cliente: nombre= " + nombre + " dni= " + dni + ", prestados= " + prestados;
    }
}
