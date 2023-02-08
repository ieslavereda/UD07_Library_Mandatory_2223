package es.ieslavereda.library_2nversion;
import es.ieslavereda.tad.Lista;

public class Biblioteca {
    private Lista<Cliente> clientes;
    private Lista<Publicacion> publicaciones;

    public Biblioteca() {
        clientes = new Lista<>();
        publicaciones = new Lista<>();
    }

    public void altaCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public boolean bajaCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            if(cliente.getPrestados().size()>0)
                return false; //exception no ha devuelto todo
            clientes.remove(clientes.search(cliente));
            return true;
        }
        return false;
    }

    public void altaPublicacion(Publicacion publicacion){
        publicaciones.add(publicacion);
    }

    public boolean bajaPublicacion(Publicacion publicacion){
        if(publicaciones.contains(publicacion)){
            publicaciones.remove(publicaciones.search(publicacion));
            return true;
        }
        return false;
    }

    public boolean prestarEjemplarLibro(Libro libro, Cliente cliente){
        if(libro==null || !(libro instanceof Libro)
                || (cliente==null) || !(clientes.contains(cliente))
                || !(publicaciones.contains(libro)))
            return false;
        int index = libro.ejemplarDisponible();
        if(index>=0) {
            libro.getEjemplares().get(index).prestar(cliente);
            return true;
        }
        return false;
    }

    public boolean devolverEjemplarLibro(Libro libro, Cliente cliente){
        if(libro==null || !(libro instanceof Libro)
                || (cliente==null) || !(clientes.contains(cliente))
                || !(publicaciones.contains(libro)))
            return false;

        if(libro.ejemplarPrestado(cliente)>=0)
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "Biblioteca: " +
                "\n clientes=" + clientes +
                "\n publicaciones=" + publicaciones;
    }






}
