package es.ieslavereda.library;
import es.ieslavereda.tad.Lista;
import java.util.Objects;


public class Cliente {

    private String nombre;
    private String dni;

    private Lista<Prestamo<Ejemplar>> prestados;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.prestados = new Lista<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public Lista<Prestamo<Ejemplar>> getPrestados() {
        return prestados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    public boolean prestar(Ejemplar ejemplar) {
        if (ejemplar == null || ejemplar.isPrestado() || cantidadPrestados() >= Biblioteca.MAX_EJEMPLARES_CLIENTE)
            return false;

        prestados.add(new Prestamo<>(ejemplar));
        ejemplar.aĆ±adirRegistroPrestamo(this);
        return true;

    }

    public boolean devolver(Ejemplar ejemplar) {
        if (ejemplar == null || !ejemplar.puedeDevolver(this))
            return false;

        Prestamo<Ejemplar> prestamo;

        int i=0;
        while ((prestamo = prestados.get(i))!=null) {
            if(prestamo.getInfo().equals(ejemplar) && prestamo.getFechaDevolucion()==null) {
                prestamo.devolver();
                ejemplar.devolver();
                return true;
            }
            i++;
        }

        return false;
    }

    public int cantidadPrestados(){

        Prestamo<Ejemplar> prestamo;
        int cantidad=0;
        int i=0;
        while ((prestamo = prestados.get(i))!=null) {
            if(prestamo.getFechaDevolucion()==null)
                cantidad++;
            i++;
        }

        return cantidad;
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
