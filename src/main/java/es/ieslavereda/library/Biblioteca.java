package es.ieslavereda.library;
import es.ieslavereda.tad.Lista;

public class Biblioteca {

    public static final int MAX_EJEMPLARES_CLIENTE = 3;

    private Lista<Cliente> clientes;
    private Lista<Publicacion> publicaciones;

    public Biblioteca() {
        clientes = new Lista<>();
        publicaciones = new Lista<>();
    }

    public void altaCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public boolean bajaCliente(String DNI) {
        Cliente cliente = getCliente(DNI);
        if(cliente==null || cliente.cantidadPrestados()>0)
            return false;

        clientes.remove(clientes.search(cliente));

        return true;
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

    public Libro getLibro(String ISBN){

        Publicacion publicacion;
        int i=0;
        while ((publicacion = publicaciones.get(i))!=null){
            if(publicacion instanceof Libro){
                Libro l = (Libro) publicacion;
                if(l.getISBN().compareTo(ISBN)==0)
                    return l;
            }
            i++;
        }
        return null;
    }
    public Cliente getCliente(String DNI){

        Cliente c;
        int i=0;
        while((c = clientes.get(i))!=null){
            if(c.getDni().compareTo(DNI)==0)
                return c;
            i++;
        }

        return null;
    }

    public boolean devolver(String ISBN, int codigoEjemplar, String DNI){

        Libro libro = getLibro(ISBN);
        if(libro==null) return false;

        Ejemplar ejemplar = libro.getEjemplar(codigoEjemplar);
        if(ejemplar==null) return false;

        Cliente cliente = getCliente(DNI);
        if(cliente==null) return false;

        return cliente.devolver(ejemplar);
    }

    public boolean prestar(String ISBN, int codigoEjemplar, String DNI){

        Libro libro = getLibro(ISBN);
        if(libro==null) return false;

        Ejemplar ejemplar = libro.getEjemplar(codigoEjemplar);
        if(ejemplar==null) return false;

        Cliente cliente = getCliente(DNI);
        if(cliente==null) return false;


        return cliente.prestar(ejemplar);
    }


    @Override
    public String toString() {
        return "Biblioteca: " +
                "\n clientes=" + clientes +
                "\n publicaciones=" + publicaciones;
    }






}
